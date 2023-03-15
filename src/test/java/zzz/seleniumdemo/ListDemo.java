package zzz.seleniumdemo;

import java.util.ArrayList;
import java.util.HashMap;

public class ListDemo {

	public static void main(String[] args) {

		HashMap<Integer, String> map1 = new HashMap<Integer, String>();// Creating HashMap

		map1.put(1, "Mango"); // Put elements in Map
		map1.put(2, "Apple");
		map1.put(3, "Banana");
		map1.put(4, "Grapes");

		System.out.println(map1);

		System.out.println(map1.get(3));

		HashMap<Integer, String> map2 = new HashMap<Integer, String>();

		map2.put(1, "pink");
		map2.put(2, "yellow");
		
		System.out.println(map2);
		System.out.println(map2.get(2));
		
		ArrayList<HashMap<Integer, String>> list=new ArrayList<HashMap<Integer, String>>();
		
		list.add(map1);
		list.add(map2);
		
		System.out.println(list.get(1).get(2));
		
		System.out.println(list.get(0).get(4));
	}
}
