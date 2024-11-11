if [[ $BASH_PREVIEW ]];
then
  unset BASH_PREVIEW 
  echo "
  Previewing Bash-it Themes
  "

  THEMES="$BASH_IT/themes/*/*.theme.bash"
  for theme in $THEMES
  do
    echo "
    $BASH_IT_THEME"
    echo "" | bash --init-file "${BASH_IT}/bash_it.sh" -i
  done
fi