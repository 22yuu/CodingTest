package lv2;
import java.util.*;

public class ¶¥µû¸Ô±â {
	  public static int[] findMax(int[] arr1, int[] arr2) {
	        
	        int newArr[] = new int[arr1.length];
	        
	        for(int i = 0; i < arr1.length; i++) {
	            int max = 0;
	            for(int j = 0; j < arr2.length; j++) {
	                if(i == j ) continue;
	                max = Math.max(max, arr1[j] + arr2[i]);
	            }
	            newArr[i] = max;
	            // System.out.print(newArr[i] +" ");
	        }
	        
	        return newArr;
	    }
	    
	  static int solution(int[][] land) {
	        int answer = 0;
	        
	        // land[1] = findMax(land[0], land[1]);
	        // System.out.println(land.length);
	        
	        for(int i = 0 ; i < land.length - 1; i++) {
	            land[i+1] = findMax(land[i], land[i+1]);
//	            System.out.println();
	        }
	        
	        int idx = land.length - 1;
	        
	        for(int i = 0; i < land[0].length; i++) answer = Math.max(answer, land[idx][i]);
	        
	        return answer;
	    }
	    
	    public static void main(String[] args) {
	    	int[][] array = new int[][] {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
	    	System.out.println(solution(array));
	    }
}
