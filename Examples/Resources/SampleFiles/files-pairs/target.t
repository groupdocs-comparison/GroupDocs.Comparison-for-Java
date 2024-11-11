    use strict;
    use warnings;
     
    use Test::More;
     
    plan tests => 3;
     
    use_ok('SimpleApp');
     
    ok(App::add(1, 1) == 2, "1+1 = 2");
     
    is(App::add(150, 200),  350, "150+200 = 350");