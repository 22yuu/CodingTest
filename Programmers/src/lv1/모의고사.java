package lv1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
	static class Solution {
	    public int[] solution(int[] answers) {
	        
	        
	        int[] students = {1,2,3};
	        int temp = 0;
	        int temp2 = 0;
	        List<Integer> list = new ArrayList<>();
	        
	        int[] person1 = {1,2,3,4,5};
	        int[] person2 = {2,1,2,3,2,4,2,5};
	        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
	        
	        int[] result = {0, 0, 0};
	        

	        for(int i = 0; i < answers.length; i++) {
	            
	            if(person1[i%5] == answers[i]) {
	                result[0]++;
	            }
	            
	            if(person2[i%8] == answers[i]) {
	                result[1]++;
	            }
	            
	            if(person3[i%10] == answers[i]) {
	                result[2]++;
	            }
	        }
	        
	        
	        
	        for(int i = 0; i < result.length; i++) {
	            for(int j = 0; j < result.length - i -1; j++) {
	                if(result[j] < result[j+1]) {
	                    temp = result[j];
	                    result[j] = result[j+1];
	                    result[j+1] = temp;
	                    
	                    temp2 = students[j];
	                    students[j] = students[j+1];
	                    students[j+1] = students[j];
	                    
	                }
	            }
	        }
	        

	        list.add(students[0]);
	        for(int i = 1; i < result.length; i++) {
	            if(result[0] == result[i]) {
	                list.add(students[i]);
	            }
	        }
	        //System.out.println(list);
	        int[] answer = list.stream().mapToInt(i->i).toArray();
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] answer = {1,3,2,4,2};
		
		System.out.println(sol.solution(answer));
	}
}
