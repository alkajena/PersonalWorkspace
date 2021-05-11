package Files;

public class SerializationDeserialization {

	public static void main(String args[]) 
    { 
        try
        { 
            // Throw an object of user defined exception 
            throw new MyException("abc"); 
        } 
        catch (MyException ex) 
        { 
            System.out.println("Caught"); 
            System.out.println(ex.getMessage()); 
        } 
    } 
	 static void fun() 
	    { 
	        try
	        { 
	            throw new NullPointerException("demo"); 
	        } 
	       
	        catch(NullPointerException e) 
	        { 
	            System.out.println("Caught inside fun()."); 
	            throw e; // rethrowing the exception 
	        } 
	        
	       
	    } 

}

class MyException extends Exception 
{ 
  public MyException(String e){
	  super(e);
  }
} 
