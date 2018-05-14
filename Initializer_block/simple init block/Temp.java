class Temp
{
 {
  System.out.println("init block");
 }
 Temp()
 {
  System.out.println("default");
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
default
*/