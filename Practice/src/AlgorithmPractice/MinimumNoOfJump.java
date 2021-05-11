package AlgorithmPractice;

public class MinimumNoOfJump {

	public static void main(String[] args) {
		 int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
	        int n = arr.length;
	        System.out.print("Minimum number of jumps to reach end is "
	                         + minimumJump(arr, 0, n - 1));

	}
	public static int minimumJump(int[] arr,int l,int h){
		if(l==h)
			return 0;
		if(arr[l]==0)
			return Integer.MAX_VALUE;
		int jump=Integer.MAX_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=l+1;i<=h && i<=(l+arr[l]); i++){
			jump=minimumJump(arr, i, h);
			if(jump!=Integer.MAX_VALUE && min > 1+jump){
				min=1+jump;
			}
		}
		return min;
	}
}
