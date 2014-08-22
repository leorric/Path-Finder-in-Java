package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMap {
	
	public static void main(String[] args){
		Ta a = new TestMap().new Ta();
		Map<Integer,Integer> m = new LinkedHashMap<Integer,Integer>();
			
		a.s.put(1, 2);
		a.s.put(2, 4);
		m.putAll(a.s);
		for(Integer k : m.keySet()) {
			System.out.println(k);
		}
	}
	
	class Ta{
		Map<Integer,Integer> s = new LinkedHashMap();
	}
}
