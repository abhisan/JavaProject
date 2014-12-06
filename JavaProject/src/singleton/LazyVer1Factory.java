package singleton;

public class LazyVer1Factory {
	static class ObjectHolder {
		private static final Resource e = new Resource();
	}

	public static Resource getInstance() {
		return ObjectHolder.e;
	}
}

class Resource {

}
