package lv3;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12927
 * 
 * 정확성 O, 효율성 X...
 */

import java.util.*;

public class 야근지수 {

	public static class Solution {
	    
	    public long solution(int n, int[] works) {
	        long answer = 0;
	        int max = 0;
	        int len = works.length;
	        
	        while(n > 0) {
	            Arrays.sort(works);
	            works[len-1]--;
	            n--;
	            if(works[len-1] < 0) works[len-1] = 0;
	        }
	        
	        for(int work : works) {
	            answer += (work * work);
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] data = {4,3,3};
		int n = 4;
		
		System.out.println(sol.solution(4, data));
	}
}
