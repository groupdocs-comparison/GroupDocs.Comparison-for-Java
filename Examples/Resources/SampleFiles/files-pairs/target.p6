use v6;
 
# Single line comments like this one start with '#'. 
my $file  = open 'scores.txt'; # Comments can also follow code on a line. 
my @names = $file.get.words;
 
my %matches;
my %sets;
 
#`(  Multiple line comments
     are denoted by a #, then `, then one of {,[, or (
     and closed by the corresponding },], and ).
     Nested pairs of square brackets, curly braces and
     parentheses are matched, so
     something like this () will not end the comment.
     In this case, closed by: )
for $file.lines -> $line {
    next unless $line; # ignore any empty lines 
 
    my ($pairing, $result) = $line.split(' | ');
    my ($p1, $p2)          = $pairing.words;
    my ($r1, $r2)          = $result.split(':');
 
    %sets{$p1} += $r1;
    %sets{$p2} += $r2;
 
    if $r1 > $r2 {
        %matches{$p1}++;
    } else {
        %matches{$p2}++;
    }
}
 
#`[
  This is another multi-line comment. ]
#`{ So is this, though it's not actually multi-line. }
my @sorted = @names.sort({ %sets{$_} }).sort({ %matches{$_} }).reverse;
 }