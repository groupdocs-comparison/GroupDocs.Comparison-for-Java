# .bashrc for OS X and Ubuntu
# ====================================================================
# - https://github.com/junegunn/dotfiles
# - junegunn.c@gmail.com

# System default
# --------------------------------------------------------------------

export PLATFORM=$(uname -s)
[ -f /etc/bashrc ] && . /etc/bashrc

BASE=$(dirname $(readlink $BASH_SOURCE))

# Options
# --------------------------------------------------------------------

### Append to the history file
shopt -s histappend

### Check the window size after each command ($LINES, $COLUMNS)
shopt -s checkwinsize

### Better-looking less for binary files
[ -x /usr/bin/lesspipe    ] && eval "$(SHELL=/bin/sh lesspipe)"

### Bash completion
[ -f /etc/bash_completion ] && . /etc/bash_completion

### Disable CTRL-S and CTRL-Q
[[ $- =~ i ]] && stty -ixoff -ixon


# Environment variables
# --------------------------------------------------------------------

### man bash
export HISTCONTROL=ignoreboth:erasedups
export HISTSIZE=
export HISTFILESIZE=
export HISTTIMEFORMAT="%Y/%m/%d %H:%M:%S:   "
[ -z "$TMPDIR" ] && TMPDIR=/tmp

### Global
export GOPATH=~/gosrc
mkdir -p $GOPATH
if [ "$PLATFORM" = 'Darwin' ]; then
  export PATH=~/bin:/usr/local/opt/ruby/bin:/usr/local/lib/ruby/gems/2.6.0/bin:$GOPATH/bin:$PATH
else
  export PATH=~/bin
  export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.:/usr/local/lib
fi
export EDITOR=nvim
export LANG=en_US.UTF-8
export LC_ALL=en_US.UTF-8

### OS X
export COPYFILE_DISABLE=true

# Aliases
# --------------------------------------------------------------------

alias ..='cd ..'
alias ...='cd ../..'
alias ....='cd ../../..'
alias .....='cd ../../../..'
alias ......='cd ../../../../..'
alias cd.='cd ..'
alias cd..='cd ..'
alias l='ls -alF'
alias ll='ls -l'
alias vi='nvim'
alias vim='nvim'
alias which='type -p'
alias k5='kill -9 %%'
alias gv='vim +GV +"autocmd BufWipeout <buffer> qall"'
ext() {
  ext-all --exclude .git --exclude target --exclude "*.log"
}
ext-all() {
  local name=$(basename $(pwd))
  cd ..
  tar -cvzf "$name.tgz" $* --exclude "$name.tgz" "$name"
  cd -
  mv ../"$name".tgz .
}

temp() {
  vim +"set filetype=$1" +AutoSave /tmp/temp-$(date +'%Y%m%d-%H%M%S')
}

if [ "$PLATFORM" = 'Darwin' ]; then
  alias tac='tail -r'
  o() {
    open --reveal "${1:-.}"
  }
fi

### Tmux
alias tmux="tmux -2"
alias tmuxls="ls $TMPDIR/tmux*/"
tping() {
  for p in $(tmux list-windows -F "#{pane_id}"); do
    tmux send-keys -t $p Enter
  done
}
tpingping() {
  [ $# -ne 1 ] && return
  while true; do
    echo -n '.'
    tmux send-keys -t $1 ' '
    sleep 10
  done
}

# Prompt
# --------------------------------------------------------------------

if [ "$PLATFORM" = Linux ]; then
  PS1="\[\e[1;38m\]\u\[\e[1;34m\]@\[\e[1;31m\]\h\[\e[1;30m\]:"
  PS1="$PS1\[\e[0;38m\]\w\[\e[1;35m\]> \[\e[0m\]"
else
  ### git-prompt
  __git_ps1() { :;}
  if [ -e ~/.git-prompt.sh ]; then
    source ~/.git-prompt.sh
  fi
  PS1='\[\e[34m\]\u\[\e[1;32m\]@\[\e[0;33m\]\h\[\e[35m\]:\[\e[m\]\w\[\e[1;30m\]$(__git_ps1)\[\e[1;31m\]> \[\e[0m\]'
fi

# Tmux tile
# --------------------------------------------------------------------

tt() {
  if [ $# -lt 1 ]; then
    echo 'usage: tt <commands...>'
    return 1
  fi

  local head="$1"
  local tail='echo -n Press enter to finish.; read'

  while [ $# -gt 1 ]; do
    shift
    tmux split-window "$SHELL -ci \"$1; $tail\""
    tmux select-layout tiled > /dev/null
  done

  tmux set-window-option synchronize-panes on > /dev/null
  $SHELL -ci "$head; $tail"
}


# Shortcut functions
# --------------------------------------------------------------------

..cd() {
  cd ..
  cd "$@"
}

_parent_dirs() {
  COMPREPLY=( $(cd ..; find . -mindepth 1 -maxdepth 1 -type d -print | cut -c3- | grep "^${COMP_WORDS[COMP_CWORD]}") )
}

complete -F _parent_dirs -o default -o bashdefault ..cd

viw() {
  vim "$(which "$1")"
}

csbuild() {
  [ $# -eq 0 ] && return

  cmd="find `pwd`"
  for ext in $@; do
    cmd=" $cmd -name '*.$ext' -o"
  done
  echo ${cmd: 0: ${#cmd} - 3}
  eval "${cmd: 0: ${#cmd} - 3}" > cscope.files &&
  cscope -b -q && rm cscope.files
}

tx() {
  tmux splitw "$*; echo -n Press enter to finish.; read"
  tmux select-layout tiled
  tmux last-pane
}

gitzip() {
  git archive -o $(basename $PWD).zip HEAD
}

gittgz() {
  git archive -o $(basename $PWD).tgz HEAD
}

gitdiffb() {
  if [ $# -ne 2 ]; then
    echo two branch names required
    return
  fi
  git log --graph \
  --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr)%Creset' \
  --abbrev-commit --date=relative $1..$2
}

alias gitv='git log --graph --format="%C(auto)%h%d %s %C(black)%C(bold)%cr"'

miniprompt() {
  unset PROMPT_COMMAND
  PS1="\[\e[38;5;168m\]> \[\e[0m\]"
}

repeat() {
  local _
  for _ in $(seq $1); do
    eval "$2"
  done
}

make-patch() {
  local prefix="$(git log --oneline HEAD^.. | awk '{print $2}')"
  local suffix=
  for i in {2..10}; do
    local name=$prefix$suffix.patch
    [ -e "$name" ] || break
    suffix=-v$i
  done
  echo $name
  git format-patch HEAD^.. --stdout > "$name"
}

pbc() {
  perl -pe 'chomp if eof' | pbcopy
}

cheap-bin() {
  local PID=$(jps -lv |
      fzf --height 30% --reverse --inline-info \
          --preview 'echo {}' --preview-window bottom:wrap | awk '{print $1}')
  [ -n "$PID" ] && jmap -dump:format=b,file=cheap.bin $PID
}

EXTRA=$BASE/bashrc-extra
[ -f "$EXTRA" ] && source "$EXTRA"


if [ "$PLATFORM" = 'Darwin' ]; then
  resizes() {
    mkdir -p out &&
    for jpg in *.JPG; do
      echo $jpg
      [ -e out/$jpg ] || sips -Z 2048 --setProperty formatOptions 80 $jpg --out out/$jpg
    done
  }

  j() { export JAVA_HOME=$(/usr/libexec/java_home -v1.$1); }
fi


jfr-remote() (
  set -x -o pipefail
  if [ $# -ne 3 ]; then
    echo 'usage: jfr-remote HOST SUDOUSER DURATION'
    return 1
  fi
  local pid path dur
  pid=$(ssh -t "$1" "sudo -i sudo -u $2 jcmd" 2> /dev/null | grep -v jcmd |
        fzf --height 30% --reverse | cut -d' ' -f1) || return 1
  path="/tmp/jfr-$(date +'%Y%m%d-%H%M%S').jfr"
  dur="${3:-60}s"
  date
  ssh -t "$1" "sudo -i sudo -u $2 jcmd $pid JFR.start duration=$dur filename=$path || return"
  sleep $dur
  sleep 3
  ssh -t "$1" "sudo -i sudo -u $2 chmod o+r $path"
  scp "$1:$path" /tmp && open "$path"
)

tail-until() (
  pattern=$1
  shift
  grep -m 1 "$pattern" <(exec tail -F "$@"); kill $!
)

w3mdump() {
  curl -s "$@" | w3m -dump -T text/html
}

# fzf (https://github.com/junegunn/fzf)
# --------------------------------------------------------------------

Rg() {
  local selected=$(
    rg --column --line-number --no-heading --color=always --smart-case "$1" |
      fzf --ansi --preview "~/.vim/plugged/fzf.vim/bin/preview.sh {}"
  )
  [ -n "$selected" ] && $EDITOR "$selected"
}

RG() {
  RG_PREFIX="rg --column --line-number --no-heading --color=always --smart-case "
  INITIAL_QUERY="$1"
  local selected=$(
    FZF_DEFAULT_COMMAND="$RG_PREFIX '$INITIAL_QUERY' || true" \
      fzf --bind "change:reload:$RG_PREFIX {q} || true" \
          --ansi --phony --query "$INITIAL_QUERY" \
          --preview "~/.vim/plugged/fzf.vim/bin/preview.sh {}"
  )
  [ -n "$selected" ] && $EDITOR "$selected"
}

fzf-down() {
  fzf --height 50% "$@" --border
}

export FZF_DEFAULT_OPTS='--color "preview-bg:237"'
export FZF_CTRL_R_OPTS="--preview 'echo {}' --preview-window down:3:hidden:wrap --bind '?:toggle-preview' --bind 'ctrl-y:execute-silent(echo -n {2..} | pbcopy)+abort' --header 'Press CTRL-Y to copy command into clipboard' --border"

if command -v fd > /dev/null; then
  export FZF_DEFAULT_COMMAND='fd --type f --hidden --follow --exclude .git'
  export FZF_ALT_C_COMMAND='fd --type d --hidden --follow --exclude .git'
  export FZF_CTRL_T_COMMAND='fd --type f --type d --hidden --follow --exclude .git'
fi

command -v bat  > /dev/null && export FZF_CTRL_T_OPTS="--preview 'bat -n --color=always {}'"
command -v blsd > /dev/null && export FZF_ALT_C_COMMAND='blsd'
command -v tree > /dev/null && export FZF_ALT_C_OPTS="--preview 'tree -C {} | head -200'"

# Figlet font selector => copy to clipboard
fgl() (
  [ $# -eq 0 ] && return
  cd /usr/local/Cellar/figlet/*/share/figlet/fonts
  local font=$(ls *.flf | sort | fzf --no-multi --reverse --preview "figlet -f {} $@" --preview-window up) &&
  figlet -f "$font" "$@" | pbcopy
)

# fco - checkout git branch/tag
fco() {
  local tags branches target
  tags=$(git tag | awk '{print "\x1b[31;1mtag\x1b[m\t" $1}') || return
  branches=$(
    git branch --all | grep -v HEAD             |
    sed "s/.* //"    | sed "s#remotes/[^/]*/##" |
    sort -u          | awk '{print "\x1b[34;1mbranch\x1b[m\t" $1}') || return
  target=$(
    (echo "$tags"; echo "$branches") | sed '/^$/d' |
    fzf-down --no-hscroll --reverse --ansi +m -d "\t" -n 2 -q "$*") || return
  git checkout $(echo "$target" | awk '{print $2}')
}

if [ -n "$TMUX_PANE" ]; then
  # https://github.com/wellle/tmux-complete.vim
  fzf_tmux_words() {
    tmuxwords.rb --all --scroll 500 --min 5 | fzf-down --multi | paste -sd" " -
  }

  # ftpane - switch pane (@george-b)
  ftpane() {
    local panes current_window current_pane target target_window target_pane
    panes=$(tmux list-panes -s -F '#I:#P - #{pane_current_path} #{pane_current_command}')
    current_pane=$(tmux display-message -p '#I:#P')
    current_window=$(tmux display-message -p '#I')

    target=$(echo "$panes" | grep -v "$current_pane" | fzf +m --reverse) || return

    target_window=$(echo $target | awk 'BEGIN{FS=":|-"} {print$1}')
    target_pane=$(echo $target | awk 'BEGIN{FS=":|-"} {print$2}' | cut -c 1)

    if [[ $current_window -eq $target_window ]]; then
      tmux select-pane -t ${target_window}.${target_pane}
    else
      tmux select-pane -t ${target_window}.${target_pane} &&
      tmux select-window -t $target_window
    fi
  }

  # Bind CTRL-X-CTRL-T to tmuxwords.sh
  bind '"\C-x\C-t": "$(fzf_tmux_words)\e\C-e\er"'
elif [ -d ~/github/iTerm2-Color-Schemes/ ]; then
  ftheme() {
    local base
    base=~/github/iTerm2-Color-Schemes
    $base/tools/preview.rb "$(
      ls {$base/schemes,~/.vim/plugged/seoul256.vim/iterm2}/*.itermcolors | fzf)"
  }
fi

# Switch tmux-sessions
fs() {
  local session
  session=$(tmux list-sessions -F "#{session_name}" | \
    fzf --height 40% --reverse --query="$1" --select-1 --exit-0) &&
  tmux switch-client -t "$session"
}

# Z integration
source "$BASE/z.sh"
unalias z 2> /dev/null
z() {
  [ $# -gt 0 ] && _z "$*" && return
  cd "$(_z -l 2>&1 | fzf --height 40% --nth 2.. --reverse --inline-info +s --tac --query "${*##-* }" | sed 's/^[0-9,.]* *//')"
}

# v - open files in ~/.viminfo
v() {
  local files
  files=$(grep '^>' ~/.viminfo | cut -c3- |
          while read line; do
            [ -f "${line/\~/$HOME}" ] && echo "$line"
          done | fzf -d -m -q "$*" -1) && vim ${files//\~/$HOME}
}


# so - my stackoverflow favorites
so() {
  $BASE/bin/stackoverflow-favorites |
    fzf --ansi --reverse --with-nth ..-2 --tac --tiebreak index |
    awk '{print $NF}' | while read -r line; do
      open "$line"
    done
}

# https://stackoverflow.com/a/18787544/755334
rpmx() {
  # brew install rpm2cpio
  rpm2cpio.pl "$1" | cpio -idmv
}

# GIT heart FZF
# -------------

is_in_git_repo() {
  git rev-parse HEAD > /dev/null 2>&1
}

gf() {
  is_in_git_repo || return
  git -c color.status=always status --short |
  fzf-down -m --ansi --nth 2..,.. \
    --preview '(git diff --color=always -- {-1} | sed 1,4d; cat {-1}) | head -500' |
  cut -c4- | sed 's/.* -> //'
}

gb() {
  is_in_git_repo || return
  git branch -a --color=always | grep -v '/HEAD\s' | sort |
  fzf-down --ansi --multi --tac --preview-window right:70% \
    --preview 'git log --oneline --graph --date=short --color=always --pretty="format:%C(auto)%cd %h%d %s" $(sed s/^..// <<< {} | cut -d" " -f1) | head -200' |
  sed 's/^..//' | cut -d' ' -f1 |
  sed 's#^remotes/##'
}

gt() {
  is_in_git_repo || return
  git tag --sort -version:refname |
  fzf-down --multi --preview-window right:70% \
    --preview 'git show --color=always {} | head -200'
}

gh() {
  is_in_git_repo || return
  git log --date=short --format="%C(green)%C(bold)%cd %C(auto)%h%d %s (%an)" --graph --color=always |
  fzf-down --ansi --no-sort --reverse --multi --bind 'ctrl-s:toggle-sort' \
    --header 'Press CTRL-S to toggle sort' \
    --preview 'grep -o "[a-f0-9]\{7,\}" <<< {} | xargs git show --color=always | head -200' |
  grep -o "[a-f0-9]\{7,\}"
}

gr() {
  is_in_git_repo || return
  git remote -v | awk '{print $1 "\t" $2}' | uniq |
  fzf-down --tac \
    --preview 'git log --oneline --graph --date=short --pretty="format:%C(auto)%cd %h%d %s" {1} | head -200' |
  cut -d$'\t' -f1
}

gs() {
  is_in_git_repo || return
  git stash list | fzf-down --reverse -d: --preview 'git show --color=always {1}' |
  cut -d: -f1
}

# Extra
gp() {
  ps -ef | fzf-down --header-lines 1 --info inline --layout reverse --multi |
    awk '{print $2}'
}

gg() {
  _z -l 2>&1 | fzf --height 40% --nth 2.. --reverse --inline-info --tac | sed 's/^[0-9,.]* *//'
}


[[ -r /usr/local/etc/profile.d/bash_completion.sh ]] && . /usr/local/etc/profile.d/bash_completion.sh
[[ -r /usr/local/etc/bash_completion.d/kubectl ]] && . /usr/local/etc/bash_completion.d/kubectl
[ -f ~/.fzf.bash ] && source ~/.fzf.bash
_fzf_setup_completion path git kubectl