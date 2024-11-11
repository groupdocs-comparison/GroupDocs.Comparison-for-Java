#!/usr/bin/env nqp

# create a line => words splitting function
my $line := ' #   one  two ';

say("\$line: '$line'");

my @w := words($line);

say("'$line' => words");
for @w {
    say("  word: $_");
}

my $line1 := ' # text ';
my $line2 := ' text ';

my $o1 := nqp::create(Foo);
$o1.set-line($line1);
my $o2 := nqp::create(Foo);
$o2.set-line($line2);

my $L1 := nqp::getattr($o1, Foo, '$!line');
my $L2 := nqp::getattr($o2, Foo, '$!line');
say("\$o1.line: '$L1'");
say("\$o2.line: '$L2'");

my @arr := nqp::list(
    'elem 0',
    'elem 1',
);

$o1.set-contents(@arr);

my @list := nqp::getattr($o1, Foo, '@!contents');
say("\$o1's contents:");
for @list {
    say("  $_");
}

$o1.add2contents('another elem');
@list := nqp::getattr($o1, Foo, '@!contents');
say("\n\$o1's contents after an update:");
for @list {
    say("  $_");
}

$o1.empty-contents;
@list := nqp::getattr($o1, Foo, '@!contents');
say("\n\$o1's contents after emptying:");
if !nqp::elems(@list) {
    say("  \$o1's \@contents are empty");
}
else {
    for @list {
        say("  $_");
    }
}

my $o3:= nqp::create(Foo);
$o3.set-contents(@arr);
$o3.set-line('line 3');

$o3.show-contents;
$o3.show-line;

sub words($line) {
    my @arr := nqp::split(' ', $line);
    my @words := [];
    for @arr {
        my $s := $_;
        # remove any whitespace
        $s := subst($s, /\s+/, '', :global);
        next if !$s;
        @words.push($s);
    }

    return @words;
}