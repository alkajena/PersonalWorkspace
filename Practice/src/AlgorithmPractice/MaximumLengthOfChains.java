package AlgorithmPractice;

import java.util.Arrays;

public class MaximumLengthOfChains {

	
		int a;
		int b;
		
		MaximumLengthOfChains(int a,int b){
			this.a=a;
			this.b=b;
		}
	public static void main(String[] args) {

		
		MaximumLengthOfChains arr[] = new MaximumLengthOfChains[]{ 
				  new MaximumLengthOfChains(5,24),  
		          new MaximumLengthOfChains(15, 25),                       
		          new MaximumLengthOfChains (27, 40),  
		          new MaximumLengthOfChains(50, 60) };  
		
		System.out.print("the length is : "+maximumLength(arr, arr.length));

	}
	
	public static int maximumLength(MaximumLengthOfChains[] pArr,int n){
		
		int[] lis=new int[n+1];
		int[] p=new int[n+1];
		
		Arrays.fill(lis,1);
		Arrays.fill(p, -1);
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(pArr[i].a>pArr[j].b && 1+lis[j] > lis[i]){
					lis[i]=1+lis[j];
					p[i]=j;
				}
			}
		}
		
		int max=0;
		int maxIndex=0;
		for(int i=0;i<=n;i++){
			if(max < lis[i]){
				max=lis[i];
				maxIndex=i;
			}
		}
		
		while(maxIndex >= 0){
			System.out.println(pArr[maxIndex].a+" "+pArr[maxIndex].b);
			maxIndex=p[maxIndex];
		}
		return max;
	}
}
