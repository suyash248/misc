class InitStatic
{
	static
	{
		System.out.println("static block");
	}
	{
		System.out.println("Init block");
	}
	InitStatic()
	{
		this(10);
	}
	InitStatic(int x)	
	{
		System.out.println(x);
	}
	public static void main(String... w)
	{
		new InitStatic();
	}
}

/* OUTPUT-
static block
Init block
10  */

/* NOTE-If static block and init block both are present in a java file then static block will be executed first(ie. at class loading time)and if any
constructor is used for creating a new object then the init block will be executed. */