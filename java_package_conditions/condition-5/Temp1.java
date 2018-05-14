package p2;
public class Temp1
{
	public void show()	
	{
		System.out.println("pac p1 from f2 parallel");
	}
	public static void main(String... w)
	{
		new Temp1().show();
	}
}

// save at M:\f2

/*
save another copy at J:\f1(with package p1;) -

package p1;
public class Temp1
{
	public void show()	
	{
		System.out.println("pac p1 from f1");
	}
	public static void main(String... w)
	{
		new Temp1().show();
	}
}
*/