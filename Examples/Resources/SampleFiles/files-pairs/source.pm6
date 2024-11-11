unit class Email::Simple;

use Email::Simple::Header;
use DateTime::Format::RFC2822;

has $!body;
has $!header;
has $!crlf;

grammar Message {
  regex TOP {
    <headers>
    <header-separate>
    <body>
  }
  token header-separate {
      [\x0a\x0d\x0a\x0d] | [\x0d\x0a\x0d\x0a] | \x0a ** 2 | \x0d ** 2
  }
  token body {
    .*
  }
  regex headers {
    .*?
  }
}

multi method new (Str $text, :$header-class = Email::Simple::Header) {
    my $parsed = Message.parse($text);
    unless $parsed {
        # no header separator found, so it must be a header-only email
        my $crlf = ~($text ~~ /\xa\xd|\xd\xa|\xa|\xd/);
        return self.bless(
                body   => '',
                header => Email::Simple::Header.new($text, :$crlf),
                :$crlf,
        );
    }
    my $newlines = ~$parsed<header-separate>;
    my $crlf = $newlines.NFC[^($newlines.codes / 2)]>>.chr.join;
    my $headers = ~$parsed<headers>;
    $headers ~= $crlf;
    my $header-object = $header-class.new($headers, crlf => $crlf);
    self.bless(body => ~$parsed<body>, header => $header-object, crlf => $crlf);
}

multi method new (Array $header, Str $body, :$header-class = Email::Simple::Header) {
    self.create(header => $header, body => $body, :$header-class);
}

method create (Array :$header, Str :$body, :$header-class = Email::Simple::Header) {
    my $header-object = $header-class.new($header, crlf => "\r\n");
    if !($header-object.header('Date')) {
        $header-object.header-set('Date', DateTime::Format::RFC2822.to-string(DateTime.now));
    }
    self.bless(body => $body, header => $header-object, crlf => "\r\n");
}

submethod BUILD (:$!body, :$!header, :$!crlf) { }

method header-obj {
    return $!header;
}

method header-obj-set ($obj) {
    $!header = $obj;
}

method header ($name, :$multi) { $!header.header($name, :$multi); }
method header-set ($name, *@lines) { $!header.header-set($name, |@lines); }
method header-names { $!header.header-names; }
method headers { self.header-names; }
method header-pairs { $!header.header-pairs; }

method body {
    return $!body;
}

method body-set ($text) {
    $!body = $text;
}

method as-string {
    return $!header.as-string ~ $!crlf ~ $!body;
}
method Str { self.as-string; }

method crlf {
    return $!crlf;
}