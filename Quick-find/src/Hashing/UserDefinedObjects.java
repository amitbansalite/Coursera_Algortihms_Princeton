package Hashing;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.introcs.StdOut;

//	StdOut.print(Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE);


public class UserDefinedObjects {

	private final String who;
	private final double amount;
	private int[] stack = new int[10];
	
	public UserDefinedObjects(String who, double amount){
		this.who = who;
		this.amount = amount;				
		
		for (int i = 0; i< 5; i++)
			stack[i] = i;
	}
	
	public int hashcode(){
		int hash = 17;
		hash = 31*hash + who.hashCode();
		hash = 31*hash + ((Double) amount).hashCode();
		hash = hash*31 + Arrays.hashCode(stack);  		// java also has a Arrays.deephashcode() for User defined objects
		return hash;
	}
	
	public static void main(String[] args){
				
		UserDefinedObjects udo = new UserDefinedObjects("Amit",  2.00);
		
		UserDefinedObjects udo2 = new UserDefinedObjects("Amit_2", 3.00);
		
		UserDefinedObjects udo3 = new UserDefinedObjects("Amit", 2.00);
		
		HashMap<UserDefinedObjects, Integer> x = new HashMap<UserDefinedObjects, Integer>();
		x.put(udo, 1);
		x.put(udo2, 2);
		x.put(udo3, 3);
		
		for(UserDefinedObjects y : x.keySet()){
			StdOut.println("true");
		}
		
	}
	
	
}
