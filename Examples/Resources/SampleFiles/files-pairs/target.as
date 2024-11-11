package mockolate
{
    public class StubbingMockolates
    {
        // shorthands
        public function proceedWhen(target:IEventDispatcher, eventName:String, timeout:Number=30000, timeoutHandler:Function=null):void
        {
            Async.proceedOnEvent(this, target, eventName, timeout, timeoutHandler);
        }
        
        [Before(async, timeout=30000)]
        public function prepareMockolates():void
        {
            proceedWhen(
                prepare(Flavour, DarkChocolate),
                Event.COMPLETE);
        }
        
        
        [Test]
        public function stubbingGetter():void
        {
            var instance:Flavour = nice(Flavour);
            var answer:Object = "Gublerscotch";
            
            stub(instance).getter("name").returns(answer);
            
            assertThat(instance.name, strictlyEqualTo(answer));
        }

        // getter throws
        // setter throws
        // getter calls
        // setter calls
        // getter dispatches event
        // setter dispatches event
         
        [Test]
        public function stubbingMethod():void
        {
            var instance:Flavour = nice(Flavour);
            var answer:Object = nice(Flavour);
            
            stub(instance).method("combine").args(nullValue()).returns(answer);
            
            assertThat(instance.combine(null), strictlyEqualTo(answer));
        }
        
        [Test]
        public function stubbingMethodWithArgs():void
        {
            var instance:Flavour = nice(Flavour);
            var arg:Flavour = new DarkChocolate();
            var answer:Flavour = nice(Flavour);
            
            stub(instance).method("combine").args(arg).returns(answer);
            
            assertThat(instance.combine(arg), strictlyEqualTo(answer));
        }
        
        [Test]
        public function stubbingMethodWithArgMatchers():void
        {
            var instance:Flavour = nice(Flavour);
            var arg:Flavour = new DarkChocolate();
            var answer:Flavour = nice(Flavour);
            
            stub(instance).method("combine").args(strictlyEqualTo(arg)).returns(answer);
            
            assertThat(instance.combine(arg), strictlyEqualTo(answer));
        }
        
        [Test(expected='mockolate.sample.FlavourMismatchError')]
        public function stubbingMethodToThrowError():void 
        {
            var instance:Flavour = nice(Flavour);
            var arg1:Flavour = nice(Flavour, 'Anchovies');
            var arg2:Flavour = nice(Flavour, 'IceCream');
            var answer:Flavour = nice(Flavour);
            
            stub(instance).method("combine").args(arg1, arg2).throws(new FlavourMismatchError("Eww, Anchovies and IceCream dont mix"));
            
            instance.combine(arg1, arg2);        	
        }
        
        [Test]
        public function stubbingMethodToCallFunction():void 
        {
            var called:Boolean = false;
            var instance:Flavour = nice(Flavour);
            
            stub(instance).method("combine").args(anything()).calls(function():void {
                called = true;	
            });
            
            instance.combine(null);
            
            assertThat(called, equalTo(true));
        }
        
        [Test]
        public function stubbingMethodToDispatchEvent():void 
        {
            var dispatched:Boolean = false;
            var instance:DarkChocolate = nice(DarkChocolate);
          
            stub(instance).method("combine").args(anything()).dispatches(new Event("flavoursCombined"));
          
            instance.addEventListener("flavoursCombined", function(event:Event):void {
                dispatched = true;
            });
            
            instance.combine(null);
            
            assertThat(dispatched, equalTo(true));
        }
    }
}