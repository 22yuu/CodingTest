package lv1;

import java.util.*;

public class 소수만들기 {

	static class Solution {
	    
	    public boolean prime(int num) {
	        
	        for( int i = 2; i < num; i++) {
	            
	            if( num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public int solution(int[] nums) {
	        int answer = 0;
	        
	        Arrays.sort(nums);
	       
	        for(int i = 0; i < nums.length; i++) {
	            int num = 0;
	            for(int j = i+1; j < nums.length; j++) {
	                for(int k = j+1; k < nums.length; k++) {
	                    num = nums[i] + nums[j] + nums[k];
	                    
	                    if(prime(num)) answer++; 
	                }
	            }
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] nums = {1,2,7,6,4};
		
		System.out.println(sol.solution(nums));
	}
	
}
