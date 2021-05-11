package AlgorithmPractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//it will give you total number of substrings present in the given string from which you can calculate the maximum length substring
public class LongestPalidromicString {

	public static void main(String[] args) {
		
		String seq = "MoMGEEKSMMADAMMGEEKSFORMADAM"; 
        int n = seq.length(); 
        
        Map<String,Integer> map=new HashMap<>();
        int[][] arr=new int[n+1][n+1];
        
        for(int i=0;i<seq.length();i++){
        	arr[i][i]=1;
        	map.put(seq.substring(i,i+1), 1);
        }
        
        for(int i=0;i<seq.length()-1;i++){
        	if(seq.charAt(i)==seq.charAt(i+1)){
	        	arr[i][i+1]=1;
	        	map.put(seq.substring(i,i+2), 2);
        	}
        	else{
        		arr[i][i+1]=0;
        	}
        }
        
        for(int len=3;len<=seq.length();len++){
        	for(int st=0;st<=(seq.length()-len);st++){
        		int end=st+len-1;
        		if(seq.charAt(st)==seq.charAt(end) && arr[st+1][end-1]==1){
        			arr[st][end]=1;
        			map.put(seq.substring(st,end+1), seq.substring(st,end+1).length());
        		}
        	}
        }
      for(Map.Entry<String, Integer> entry:map.entrySet()){
    	  System.out.println("key : "+entry.getKey()+" value : "+entry.getValue());
      }
      
      TreeSet<Map.Entry<String, Integer>> set=new TreeSet<>(new Comparator<Object>(){

		@Override
		public int compare(Object o1, Object o2) {
			Map.Entry<String, Integer> e1=(Map.Entry<String, Integer>)o1;
			Map.Entry<String, Integer> e2=(Map.Entry<String, Integer>)o2;
			return e2.getValue().compareTo(e1.getValue());
		}
	});
      set.addAll(map.entrySet());
      for(Map.Entry<String, Integer> entry:set){
    	  System.out.println("Highest length key : "+entry.getKey()+" Highest length value : "+entry.getValue());
    	  break;
      }
      
      
	}
	

}
