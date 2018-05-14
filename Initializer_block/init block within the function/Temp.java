class Temp
{
 {
  System.out.println("init block");
 }
 Temp()
 {
  System.out.println("default constructor");
 }
 Temp(int x)
 {
  System.out.println(x);
 }
 public static void main(String... s)
 {
  new Temp();
  new Temp(10);
  {
  System.out.println("not a init block");
  }
 }
}

/* OUTPUT-
init block
default constructor
init block
10
not a init block


NOTE-
Here one init block is present within the function.If init block is within the function then the statements present within it are treated as normal satements of that function.  */