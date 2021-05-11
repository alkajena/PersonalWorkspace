package Coolections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Map1 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		TreeMap<String,String> map=new TreeMap();
		map.put("1", "eepu");
		map.put("4", "alka");
		map.put("2", "baba");
		map.put("3", "xer");
		
		Set set=map.entrySet();
		
		ArrayList<Map.Entry> list=new ArrayList<>(set);
		
		TreeSet<Map.Entry> tSet=new TreeSet<>(new MyComparator());
		for(Map.Entry e:list){
			tSet.add(e);
		}
		for(Map.Entry m:tSet){
			System.out.println(m.getKey()+" : "+m.getValue());
		}

	}

}

@SuppressWarnings("rawtypes")
class MyComparator implements Comparator{


	@Override
	public int compare(Object o1, Object o2) {
		Map.Entry map1=(Map.Entry)o1;
		Map.Entry map2=(Map.Entry)o2;
		String s1=(String)map1.getValue();
		String s2=(String)map2.getValue();
		return s2.compareTo(s1);
		
	}
	
}