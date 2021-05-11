package Arrays;

public class staticMethodsVarBlock {
	public static int d;
	public static int gh;
	
	public static void main(String[] args) {
		//static int x=10;//static local variable can not be possible in java
		//System.out.println(x);
		m1();//only static methods can be called from one static method
		d=90;//instance variable can not be used inside static method.
			//only static and local variable can be used inside static method
		staticMethodsVarBlock bb=new staticMethodsVarBlock();
		bb.m2();
		
	}
	public void m2(){
		System.out.println(new staticMethodsVarBlock().toString());
	}
	{
		System.out.println("inside Instance initiallizer block");
	}
	//Static block executed first even before constructor also.
	static{
		d=80;
		gh=0;//instance variable can not be used inside both static method and block
		System.out.println("inside static block");
	}
	staticMethodsVarBlock(){
		System.out.println("inside constructor");
	}
	
	public static void m1(){
		System.out.println("static method");
	}
	
	private String function() 
    { 
        return ("GFG"); 
    } 
    public final static String function(int data) 
    { 
        return ("GeeksforGeeks"); 
    } 
    public int foo(){
    	return 1;
    }
}
