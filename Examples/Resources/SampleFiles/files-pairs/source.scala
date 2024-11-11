
// Scala program of Field  
// Overriding 
  
// Creating class 
class Shapes 
{ 
  
    // Creating a variable with  
    // val keyword 
    val description:String = "shape"
}  
  
// Creating a subclass 
class shape_1 extends Shapes 
{  
  
    // Overriding field using 
    // 'override' keyword  
    override val description:String ="It is a circle."
  
    // Defining a method 
    def display() 
    {  
      
        // Displays output 
        println(description)  
    }  
}  
  
// Creating a subclass 
class shape_2 extends Shapes 
{  
  
    // overriding field using 
    // 'override' keyword  
    override val description:String ="It is a square."
  
    // Defining a method 
    def display() 
    {  
      
        // Displays output 
        println(description)  
    }  
}  
  
// Creating object 
object GfG 
{  
  
    // Main method 
    def main(args:Array[String]) 
    {  
      
        // Creating instances for all 
        // the sub-classes 
        var x = new shape_1()  
        var y = new shape_2()  
      
        // Calling methods 
        x.display() 
        y.display() 
      
    }  
}  
