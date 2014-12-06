package singleton;

public class EagerVer0Factory {
	private EagerVer0Factory() {

	}
	private static final Resource e = new Resource();

	public static Resource getInstance() {
		return e;
	}
}
