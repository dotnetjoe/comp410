package Assignment0;
public class HelloWorld implements HelloWorld_Interface {


  public HelloWorld ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }
  
  // rest of your code to implement the various operations
  public String say_it() {
  	return "hello world";
  }

  public String say_it_loud() {
  	return "HELLO WORLD";
  }
}