package weeklyChallenge;

import java.util.*;


// https://programmers.co.kr/learn/courses/30/lessons/83201?language=java

public class week2 {

	static class Solution {

	    public String solution(int[][] scores) {
	        StringBuilder sb = new StringBuilder();
	        String answer = "";
	        
	        
	        for(int i = 0; i < scores.length; i++) {
	            
	            int max = Integer.MIN_VALUE;
	            int min = Integer.MAX_VALUE;
	            int maxIdx = 0;
	            int minIdx = 0;
	            int minCount = 1;
	            int maxCount = 1;
	            
	            for(int j = 0; j < scores[0].length; j++) {
	                
	                if(min == scores[j][i]) {
	                    minCount++;
	                }
	                
	                if( max == scores[j][i]) {
	                    maxCount++;
	                }
	                
	                // max 
	                if(max < scores[j][i] ) {
	                    max = scores[j][i];
	                    maxIdx = j;
	                }
	                
	                // min
	                if( min > scores[j][i]) {
	                    min = scores[j][i];
	                    minIdx = j;
	                }
	                
	            }

	            if(maxIdx == i && maxCount == 1) {
	                scores[i][i] = 0;
	            }
	            
	            if(minIdx == i && minCount == 1) {
	                scores[i][i] = 0;
	            }
	        } // for end

	        
	        for(int i = 0; i < scores.length; i++) {
	            double avg = 0;
	            double sum = 0;
	            int sumCount = 0;
	            
	            for(int j = 0; j < scores[0].length; j++) {
	                
	                if(scores[j][i] > 0) {
	                    sum += scores[j][i];
	                    sumCount++;
	                }
	                
	            }
	            avg = sum / sumCount;
	            answer += hakjum(avg);
	        } // end for
	        
	        return answer;
	    }
	    
	    public String hakjum(double avg) {
	        String str = "";
	        
	        if(avg >= 90) {
	            str = "A";
	        } else if(avg >= 80) {
	            str = "B";
	        } else if(avg >= 70) {
	            str = "C";
	        } else if(avg >= 50) {
	            str = "D";
	        } else {
	            str = "F";
	        }
	        
	        return str;
	    }
	}
	
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65}, {24,90,94,75,65}};
		System.out.println(sol.solution(scores));
	}
}
