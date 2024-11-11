use strict;

use ExtUtils::MakeMaker;

WriteMakefile(
    VERSION_FROM => 'lib/Someone/CLI/Util.pm',
    ABSTRACT     => 'A simple command-line interface to the Linode platform.',
    AUTHOR       => 'Someone, LLC',
    PREREQ_PM    => {
        'JSON'               => 0,
        'LWP::UserAgent'     => 0,
        'Mozilla::CA'        => 0,
        'Try::Tiny'          => 0,
        'WebService::Someone' => 0,
    },
    PMLIBDIRS    => [
        'lib/Someone',
    ],
    EXE_FILES    => [
        'linode',
        'linode-account',
        'linode-domain',
        'linode-linode',
        'linode-nodebalancer',
        'linode-stackscript',
    ],
);