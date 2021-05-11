package AlgorithmPractice;

//Longest Common Subsequnece
public class PrintLCS {

	public static void main(String[] args) {
		String s1="ABCDGH";
		String s2="AEDFHR";
		
		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();
		
		int m=arr1.length;
		int n=arr2.length;
		
		int[][] dp=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(arr1[i-1]==arr2[j-1])
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		System.out.print("The length of LCS is : "+dp[m][n]);
		int length=dp[m][n];
		char[] arr=new char[length+1];
		arr[length]='\0';
		
		int i=m;
		int j=n;
		
		while(i > 0 && j > 0){
			if(arr1[i-1]==arr2[j-1]){
				arr[length-1]=arr1[i-1];
				length--;
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}
			else
			{
				j--;
			}
		}
		System.out.print(" The  LCS is : ");
		for(char ch:arr)
			System.out.print(ch);
		

	}

}
