package lv3;

import java.util.*;

public class Á¤¼ö»ï°¢Çü {
	  public static int solution(int[][] triangle) {
	        int answer = 0;
	        int dp[][] = triangle;
	        
	        for(int i = 1; i < triangle.length; i++) {
	            for(int j = 0; j < triangle[i].length; j++) {
	                if(j == 0) {
	                	dp[i][j] = dp[i-1][j] + dp[i][j];
	                } else if(j==i) {
	                	dp[i][j] = dp[i-1][j-1] + dp[i][j];
	                } else {
	                	dp[i][j] = Math.max(dp[i][j] + dp[i-1][j-1], dp[i][j] + dp[i-1][j]);
	                }
	            }
	        }
	        
//	        for(int i = 0; i < triangle.length; i++) {
//	            for(int j = 0; j < triangle[i].length; j++) {
//	            	System.out.print(dp[i][j] + " ");
//	            } 
//	            System.out.println();
//	        }
	        
	        Arrays.sort(dp[dp.length - 1]);
	        
	        int lastIdx = dp[dp.length - 1].length;
	        
	        answer = dp[dp.length - 1][lastIdx - 1];
	        
	        return answer;
	    }
	  
	  public static void main(String[] args) {
		
		  int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
		  System.out.println(solution(triangle));
	}
}
