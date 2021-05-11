package AlgorithmPractice;

public class LongestPalidromicSubsequnece {

	public static void main(String[] args) {
		String s="GEEKSFORGEEKS";
		int l=0;
		int h=s.length()-1;
		System.out.print("The length BruteForce is : "+palidromicSubsequence(s, l, h));
		
		StringBuilder sb=new StringBuilder(s);
		sb.reverse();
		String rev=sb.toString();
		
		int m=s.length();
		int n=rev.length();
		
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(s.charAt(i-1)==rev.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.print(" The length dp is : "+dp[m][n]);
		int length=dp[m][n];
		char[] arr=new char[length+1];
		arr[length]='\0';
		
		int i=m;int j=n;
		while(i > 0 && j > 0){
			
			if(s.charAt(i-1)==rev.charAt(j-1)){
				arr[length-1]=s.charAt(i-1);
				i--;
				j--;
				length--;
			}
			else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}
			else{
				j--;
			}
			
		}
		System.out.print(" the dp approach : ");
		for(char ch:arr){
			System.out.print(ch);
		}

	}

	public static int palidromicSubsequence(String s,int l,int h){
		
		if(l==h)
			return 1;
		if(l+1==h && s.charAt(l)==s.charAt(h))
			return 2;
		if(s.charAt(l)==s.charAt(h))
			return palidromicSubsequence(s, l+1, h-1)+2;
		else 
			return Math.max(palidromicSubsequence(s, l, h-1), palidromicSubsequence(s, l+1, h));
	}
}
