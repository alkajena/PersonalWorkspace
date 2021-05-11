package AlgorithmPractice;

public class CoinChange {

	public static void main(String[] args) {
	int[] arr={1,2,3,4};
	int m=arr.length;
	int n=4;
	System.out.println("coins are : "+coinChange(arr,m,n));

	}
	
	public static int coinChange(int[] arr,int m,int n){
		
		if(n==0)
			return 1;
		if(m<=0 && n > 0)
			return 0;
		if(n<0)
			return 0;
		return coinChange(arr,m-1,n)+coinChange(arr,m,n-arr[m-1]);
	}
}
