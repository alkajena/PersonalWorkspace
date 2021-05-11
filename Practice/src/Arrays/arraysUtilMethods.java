package Arrays;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class arraysUtilMethods {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,2,6,8};
		Integer[] arr1=new Integer[]{1,2,6,8};
		Integer[] arr2=new Integer[]{1,2,7,8};
		/*Arrays.asList() treats array as list which is a collection 
		but it does not convert array to a list so any kind of modifications 
		operations can not be done but reading(getting)/iterations can be done*/
		
		System.out.println(Arrays.asList(arr));
		System.out.println((Arrays.asList(arr)).get(1));
		
		/*Arrays.binarySearch search specified element 
		 * with the help of binary search algorithm if key is present gives taht index 
		 * if not present then check the exact position of given key in sorted array
		 * and provide a negative of that index*/
		
		System.out.println(Arrays.binarySearch(arr, 3));
		//1 is fromIndex and 3 is toIndex
		System.out.println(Arrays.binarySearch(arr,1,3, 3));
		
		//Arrays.copyOf(arr,newLength)..It will copy the specified array 
		//with padding or truncating default values to te given array
		arr=Arrays.copyOf(arr, 6);
		System.out.println(Arrays.asList(Arrays.copyOf(arr, 6)));
		arr[4]=88;
		System.out.println(Arrays.asList(arr));
		
		//Arrays.copyOfRange(arr,fromIndex,toIndex)..same as copyOf
		System.out.println(Arrays.asList(Arrays.copyOfRange(arr,1,3)));
		
		//Arrays.deepEquals(arr1,arr2)..It compare the value deeply in case of 1d or 
		//multi dimensioanl array both
		
		System.out.println(Arrays.deepEquals(arr1, arr2));
		
		// Get the Arrays 
        Integer intArr[][] = new Integer[][]{ { 10, 20, 15, 22, 35 } }; 
  
        // Get the second Arrays 
        Integer intArr1[][] = new Integer[][]{ { 10, 20, 15, 22, 35} }; 
  
        // To compare both arrays 
        System.out.println("Integer Arrays on comparison: "
                           + Arrays.deepEquals(intArr, intArr1)); 
        
       //Arrays.deepHashCode(arr1,arr2)
        //Arrays.deepToString(arr1,arr2)
        //Arrays.equals(arr1,arr2)
        //Arrays.fill(arr,keyToFill)
        //Arrays.sort(arr)
        //Arrays.sort(arr,fromIndex,toIndex)
        //Arrays.sort(arr,comparator)
        //Arrays.sort(arr,fromIndex,toIndex,comparator)
        //Arrays.toString();
       /* DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try {
            java.util.Date date=sdf.parse("02/28/19avcabcd");
            System.out.print("date is : "+date);
        } catch (Exception e) {
           System.out.println("invalid");
        }*/
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        try {
            LocalDate.parse("200501", dateFormatter);
        } catch (DateTimeParseException e) {
        	 System.out.println("cust invalid");
        }
        //System.out.println("cust valid");
	}

}
