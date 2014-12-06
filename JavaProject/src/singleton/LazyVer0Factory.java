package singleton;

public class LazyVer0Factory {
	private LazyVer0Factory() {

	}
	private static Resource l;
	public synchronized static Resource getInstance() {
		if (l == null) {
			l = new Resource();
		}
		return l;
	}
}