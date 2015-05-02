package practice;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) 
	{	
		char lchar = new Test().getAbcByNum(2);
		System.out.println(lchar);
		
	}
	
	private char getAbcByNum(int num) {
		return (char) ('A'+num-1);
	}

}
