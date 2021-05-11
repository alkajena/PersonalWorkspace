package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumIncreasingSubsequnece {

	public static void main(String[] args) {
		
		//int[] arr={1, 101, 2, 3, 100, 4, 5};
		int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		int n=arr.length;
		
		int[] lis=new int[n];
		int[] p=new int[n];
		
		Arrays.fill(p,-1);
		for(int i=0;i<n;i++){
			lis[i]=arr[i];
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] &&(arr[i]+lis[j]) > lis[i]){
					lis[i] =arr[i]+lis[j];
					p[i] =j;
				}
			}
		}
		
		int max=0;int maxNum=0;
		for(int i=0;i<n;i++){
			if(max < lis[i]){
				max=lis[i];
				maxNum=i;
			}
		}
		
		while(maxNum >=0){
			System.out.println(arr[maxNum]);
			maxNum=p[maxNum];
		}
		
		System.out.print("The sum is : "+max);
	}

}
