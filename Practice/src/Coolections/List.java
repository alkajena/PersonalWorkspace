package Coolections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class List {

	public static void main(String[] args) {
		ArrayList<String> students = new ArrayList<String>(); 
		  LinkedList ls=new LinkedList();
		  Vector v=new Vector();
		  TreeSet<Integer> t=new TreeSet<>();
		 
        // Add Strings to list 
        // each string represents student name 
        students.add("Ram"); 
        students.add("Mohan"); 
        students.add("Sohan"); 
        students.add("Rabi"); 
        students.add("Shabbir"); 
  
        // apply removeIf() method 
        // we are going to remove names 
        // start with S 
        students.removeIf(n -> (n.charAt(0) == 'S')); 
  
        System.out.println("Students name Does not start with S"); 
     // print list 
        for (String str : students) { 
            System.out.println(str); 
        } 

	}

}
