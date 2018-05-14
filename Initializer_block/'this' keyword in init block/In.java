class In
{	
	In()
	{
		System.out.println("constructor");
	}
	{
		System.out.println("init "+this);
		show();
	}
	public void show()
	{
		System.out.println("show "+this);
	}
	public static void main(String... w)
	{
		new In();
	}
}
	
/* OUTPUT-
init In@a200d0c
show In@a200d0c
constructor */