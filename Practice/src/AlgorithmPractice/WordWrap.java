package AlgorithmPractice;

public class WordWrap {

	public static void main(String[] args) {
		int wordLenArr[] = {3, 2, 2, 5};
		   int n = 4;
		   int maxWidth = 6;
		   wordWrap (wordLenArr, n, maxWidth);

	}

	public static void wordWrap(int[] arr,int size,int width){
		
		int[][] extraSpace=new int[size+1][size+1];
		int[][] lineCost=new int[size+1][size+1];
		int[] totalCost = new int[size+1];
		int[] solution = new int[size+1];
		
		for(int i=1;i<=size;i++){
			extraSpace[i][i]=width-arr[i-1];
			for(int j=i+1;j<=size;j++){
				extraSpace[i][j]=extraSpace[i][j-1]-arr[j-1]-1;
			}
		}
		
		for(int i=1;i<=size;i++){
			for(int j=i;j<=size;j++){
				if(extraSpace[i][j] < 0){
					lineCost[i][j]=Integer.MAX_VALUE;
				}
				else if(j==size && extraSpace[i][j] >= 0){
					lineCost[i][j]=0;
				}
				else{
					lineCost[i][j]=extraSpace[i][j]*extraSpace[i][j];
				}
			}
		}
		
		
		totalCost[0]=0;
		for(int j=1;j<=size;j++){
			 totalCost[j] = Integer.MAX_VALUE;
			for(int i=1;i<=j;i++){
				if(lineCost[i][j]!=Integer.MAX_VALUE && totalCost[i-1]!=Integer.MAX_VALUE
						&& (lineCost[i][j]+totalCost[i-1]) < totalCost[j]){
					totalCost[j]=lineCost[i][j]+totalCost[i-1];
					solution[j] =i;
				}
			}
		}
		
		printWordWrap(solution,size);
	}
	
	public static int printWordWrap(int[] solution,int size){
		int k;
		if(solution[size]==1)
			k=1;
		else
			k=printWordWrap(solution,solution[size]-1)+1;
		System.out.println("Line number : "+k+" word number : "+solution[size]+" to "+size);
		return k;
	}
}
