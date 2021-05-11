package AlgorithmPractice;

import java.util.ArrayList;
import java.util.List;

public class LongestSumContiguousSubSeq {

	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		
		int sum1=0;
		int sum2=0;
		List<Integer> list=new ArrayList<>();
		for(int i=0; i<a.length; i++){
			sum1+=a[i];
			if(sum2 < sum1){
				sum2=sum1;
				list.add(a[i]);
			}
			if(sum1 < 0)
				sum1=0;
		}
		System.out.println(" sum is : "+sum2);
		for(int i:list){
			System.out.println(" i is : "+i);
		}

	}

}
