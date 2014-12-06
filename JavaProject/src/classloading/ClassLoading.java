package classloading;

class A {

	static {
		System.out.println("loading A static 0 " + A.a);
	}
	
	
	
	
	static int a = 10;

	static {
		System.out.println("loading A static 1 " + A.a);
	}
	static {
		System.out.println("loading A static 2 B.c= " + B.c);
	}
	static {
		System.out.println("loading static 3");
	}
	
	{
		
	}
	
	A() {

	}
}

class B extends A {
	static {
		System.out.println("loading B A.a= " + A.a);
	}

	static {
		System.out.println("loading A static 2 B.c= " + B.c);
	}
	static int c = 50;
}

public class ClassLoading {
	public static void main(String[] args) {
		new B();
	}
}