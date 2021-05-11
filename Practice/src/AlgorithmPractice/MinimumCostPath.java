package AlgorithmPractice;

public class MinimumCostPath {

	public static void main(String[] args) {
		
		int[][] arr={{1,2,3},{4,8,2},{1,5,3}};
		
		int m=2;
		int n=2;
		
		System.out.print("Bruteforce approach : "+minimumCostPath(arr,m,n));
		
		int[][] dp=new int[m+1][n+1];
		dp[0][0]=arr[0][0];
		
		for(int i=1;i<=m;i++){
			dp[0][i]=dp[0][i-1]+arr[0][i];
		}
		
		for(int i=1;i<=n;i++){
			dp[i][0]=dp[i-1][0]+arr[i][0];
		}
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j]=arr[i][j]+min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
			}
		}
		System.out.print(" Dynamic approach : "+dp[m][n]);
	}

	public static int minimumCostPath(int[][] arr,int m,int n){
		
		if(m < 0 || n < 0)
			return Integer.MAX_VALUE;
		else if(m==0 && n==0)
			return arr[0][0];
		else 
			return arr[m][n]+min(minimumCostPath(arr,m-1,n),minimumCostPath(arr,m,n-1),minimumCostPath(arr,m-1,n-1));
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
