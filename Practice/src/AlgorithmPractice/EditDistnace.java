package AlgorithmPractice;

//How many operations required to convert from String1 to String2
public class EditDistnace {

	public static void main(String[] args) {
		
		String s1="SUNDAY";
		String s2="SATURDAY";
		
		System.out.print("BruteForce Approach : "+editDistance(s1,s2,s1.length(),s2.length()));
		
		int m=s1.length();
		int n=s2.length();
		
		int[][] dp=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
			}
		}
		System.out.print(" Dynamic Approach : "+dp[m][n]);

	}
	
	public static int editDistance(String s1,String s2,int m,int n){
		
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(s1.charAt(m-1)==s2.charAt(n-1))
			return editDistance(s1, s2, m-1, n-1);
		else
			return 1+(min(editDistance(s1,s2,m-1,n),editDistance(s1,s2,m,n-1),editDistance(s1,s2,m-1,n-1)));
	}

	public static int min(int x,int y,int z){
		if(x < y){
			if(x < z){
				return x;
			}
			else{
				return z;
			}
		}
		else{
			if(y < z)
				return y;
			else
				return z;
		}
	}
}
