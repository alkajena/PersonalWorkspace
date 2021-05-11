package AlgorithmPractice;

public class FindAllAnagrams {

	public static void main(String[] args) {
		String s="ABC";
		findAnagrams("ABC",0,s.length());

	}
	public static void findAnagrams(String s,int st,int end){
		
		if(st==end-1)
			System.out.println(s);
		else{
			for(int i=0;i<s.length();i++){
				s=swapChar(s,st,i);
				findAnagrams(s, st+1, end);
				s=swapChar(s,st,i);
			}
		}
	}
	
	public static String swapChar(String s,int st,int end){
		char[] arr=s.toCharArray();
		char temp=arr[st];
		arr[st]=arr[end];
		arr[end]=temp;
		
		return String.valueOf(arr);
	}
}
