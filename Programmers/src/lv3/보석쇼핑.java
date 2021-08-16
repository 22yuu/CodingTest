package lv3;

import java.util.*;

public class 보석쇼핑 {

	static class Solution {
	    public int[] solution(String[] gems) {
	    
	        Queue<String> q = new LinkedList<String>();
	        HashSet<String> hs = new HashSet<String>();
	        HashMap<String, Integer> hm = new HashMap<String, Integer>();
	        
	        int startIdx = 0;
	        int endIdx = gems.length;
	        
	        // 배열 내의 보석 종류 체크
	        for(String gem : gems) {
	            hs.add(gem);
	        }
	        
	        // 구간 체크
	        
	        int count = 0;
	        for(int i = 0; i < gems.length; i++) {
	            
	           if(!hm.containsKey(gems[i])) hm.put(gems[i], 1);
	           else hm.put(gems[i], hm.get(gems[i]) + 1);
	            
	            q.offer(gems[i]);
	            
	           while(true) {
	               String temp = q.peek();
	               if(hm.get(temp) > 1) {
	                   hm.put(temp, hm.get(temp) - 1);
	                   q.poll();
	                   count++;
	               } else {
	                   break;
	               }
	           }
	            
	           if(hm.size() == hs.size() && endIdx > q.size()) {
	               endIdx = q.size();
	               startIdx = count;
	           }
	        }

	        int[] answer = {startIdx+1, startIdx + endIdx};

	        return answer;
	    }
	}
	
	
	public static void main(String[] args) {
		
		String gems[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		Solution sol = new Solution();
		int[] answer = sol.solution(gems);
		
		for(int ans : answer) System.out.print(ans + ", ");
	}
}
