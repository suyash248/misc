class A
{
	A()
	{
		System.out.println("parent class constructor invoked");
	}
}
class B extends A
{
	B()
	{
		super();		/* If we won't add 'super()' then compiler will add it implicitly. 						                  Because parent class constructor is executed beforeexecuting the 						     child's constructor. */
		System.out.println("child class constructor invoked");
	}
	
	{
		System.out.println("init block");
	}
	
	public static void main(String... w)
	{
		B b=new B();
	}
}

/* OUTPUT-
parent class constructor invoked
init block
child class constructor invoked   */


/* NOTE- init blok is invoked after the parent class constructor is invoked (ie. after super() ). */