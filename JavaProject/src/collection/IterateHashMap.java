package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IterateHashMap {
	public static void main(String s[]) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> map1 = new TreeMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

		}
		for (Integer i : map.values()) {

		}
		for (String st : map.keySet()) {

		}
	}
}
