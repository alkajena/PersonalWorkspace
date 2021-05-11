package AlgorithmPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Print Longest Increasing Subsequence
public class PrintLIC {

	public static void main(String[] args) {
		int arr[] ={1, 101, 2, 3, 100, 4, 5};
		int l=arr.length;
		System.out.print("the alternative approach length is : "+LIS(arr,l));
	}
	
	public static int LIS(int[] arr,int n){
		
		int[] l=new int[n];
		int[] p=new int[n];
		
		Arrays.fill(l,1);
		Arrays.fill(p,-1);
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] && (1+l[j]) > l[i]){
					l[i] = 1+l[j];
					p[i] = j;
				}
			}
		}
		int max=l[0];
		int maxIndex=0;
		for(int i=0;i<arr.length;i++){
			if(max < l[i]){
				max=l[i];
				maxIndex=i;
			}
		}
		List<Integer> list=new ArrayList<>();
		while(maxIndex >= 0){
			list.add(arr[maxIndex]);
			maxIndex=p[maxIndex];
		}
		Collections.reverse(list);
		System.out.println(list);
		return max;
	}

}
