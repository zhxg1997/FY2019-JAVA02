package com.practice;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo1 {

	public static void main(String[] args) {

		set();	
		list();
		
	}
	
	public static  void set() {
		Set set = new HashSet<>();
		set.add(1);
		set.add("c");
		set.add("weq");
		set.add("猪");
		
		//System.out.println(set);
		Iterator a = set.iterator();
		while (a.hasNext()) {
			
			System.out.println(a.next());
			
		}
	}
	
	public static void list() {
		List list = new ArrayList<>();
		list.add(1);
		list.add("c");
		list.add("weq");
		list.add("猪");
		//System.out.println(list);
		
		Iterator a = list.iterator();
		/*while (a.hasNext()) {
			
			System.out.println(a.next());
			
		}*/
		
	}
	
	
}
