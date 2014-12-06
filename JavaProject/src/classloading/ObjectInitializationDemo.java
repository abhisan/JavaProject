package classloading;

//ObjectInitializationDemo5.java
class Parent {
	int x = 1;
	{
		System.out.println("x = " + ++x);
	}
	
	Parent() {
		System.out.println("Executing superclass constructor");
	}
}

class ObjectInitializationDemo extends Parent {
	int a = 2;
	{
		System.out.println("a = " + ++a);
	}

	ObjectInitializationDemo() {
		System.out.println("Executing subclass constructor");
	}

	ObjectInitializationDemo(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		ObjectInitializationDemo oid51 = new ObjectInitializationDemo();
		ObjectInitializationDemo oid52 = new ObjectInitializationDemo("Executing other subclass constructor");
	}
}
//2
//3
//Executing superclass constructor
//Executing subclass constructor

//2
//3
//Executing superclass constructor
//Executing other subclass constructor