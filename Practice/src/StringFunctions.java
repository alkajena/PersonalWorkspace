
public class StringFunctions {

	public static void main(String[] args) {
		String s1="alka";
		String s2=new String("alkaJena");
		char[] ch=new char[]{'a','l','k','a','I','e','n','a'};
		String s3=new String(ch);
		String s4=new String(ch,1,3);//both are inclusive
		System.out.println(s4);
		//byte[] bt=new byte[]{};//you have to give ASCII value of character
		//String s5=new String(bt);
		//String s6=new String(bt,1,4);
		StringBuffer sf=new StringBuffer("alka");
		String st1=new String(sf);
		String st2=sf.toString();
		StringBuilder sb=new StringBuilder("jena");
		String sb1=new String(sb);
		String sb2=sb.toString();
		System.out.println(sb1+"    "+sb2);
		
		
		//utility methods
		int l=s2.length();
		System.out.println(l);
		System.out.println(s2.charAt(2));
		System.out.println(s2.substring(3));
		System.out.println(s2.substring(3,6));
		System.out.println(s2.toLowerCase());
		System.out.println(s2.toUpperCase());
		System.out.println(s2.toCharArray());
		System.out.println(s2.equalsIgnoreCase(s3));
		System.out.println(s2.compareTo(s3));
		System.out.println(s2.compareToIgnoreCase(s3));
		System.out.println(s2.startsWith("alka"));
		System.out.println(s2.endsWith("alka"));
		System.out.println(s2.contains("alka"));
		String s8=s1.concat(s2);
		System.out.println(s8);
		
		String str=new String("00000123569");
		String[] arr=str.split("0");
		for(String s:arr){
			System.out.println(s);
		}
		System.out.println(arr.length-1);
		
		
		//StringBuffer methods
		StringBuffer s = new StringBuffer("GeeksforGeeks"); 
        s.delete(0, 5); 
        System.out.println(s); // returns forGeeks 
        s.deleteCharAt(7); 
        System.out.println(s); // returns forGeek 
        System.out.println(s.codePointBefore(4));
        System.out.println(s.append("alk"));
        System.out.println(s.insert(5,"alk"));
        System.out.println(s.reverse());
        System.out.println(s.delete(0,4)+"    "+s.deleteCharAt(3));
        System.out.println(s.replace(1,3,"jena"));

        //Integer to String conversion
        Integer i=new Integer(10);
        String s88=i.toString();
        int i1=10;
        Integer.toString(10);
        String.valueOf(i1);
        StringBuffer sf3=new StringBuffer();//same gos for StringBuilder as well
        sf3.append(10);
        String ss=sf3.toString();
        
        System.out.println(Integer.toBinaryString(7890));
        System.out.println(Integer.toOctalString(6789));
        System.out.println(Integer.toHexString(5678));
        
        //String to Integer
        System.out.println(Integer.parseInt("1111011010010",2)); //parseDouble,parseLong(premitive type)  
        System.out.println(Integer.valueOf("1111011010010",2)); //reference type(Integer)
        
        String gh="alkajena";
        System.out.println(gh.matches("[a-zA-Z]+"));
        
	}

}
