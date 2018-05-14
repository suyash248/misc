class Temp
{
 {
  System.out.println("init block");
 }
 Temp()
 {
  this(10);
  System.out.println("default");
 }
 Temp(int x)
 {
  this(10,20);
  System.out.println(x);
 }
 Temp(int x,int y)
 {
  System.out.println(x+y);
 }
 public static void main(String... s)
 {
  new Temp();
 } 
 {
  System.out.println("second init block");
 }
}

/* OUTPUT-
init block
second init block
30
10
default

NOTE-
This is the example of "constructor chaining" and "init block".In constructor chaining,
the new object is only once hence init block will also execute once and when new object
is created then first of all init blocks will be executed then "this()" will execute. */