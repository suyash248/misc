class Init
{
	{
		System.out.println("init");
	}
	Init()
	{
		this(10);
	}
	Init(int x)
	{
		System.out.println(x);	
	}
	public static void main(String... w)
	{
		new Init();
	}
}

/*OUTPUT-
init
10  */