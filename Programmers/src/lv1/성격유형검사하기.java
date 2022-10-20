package lv1;

import java.util.*;

public class 성격유형검사하기 {
	private static HashMap<String, Integer> hm = new HashMap<>();
	
	public static String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int n = survey.length;
        
        // 성격유형 설정
        hm.put("R", 0);
        hm.put("T", 0);
        hm.put("C", 0);
        hm.put("F", 0);
        hm.put("J", 0);
        hm.put("M", 0);
        hm.put("A", 0);
        hm.put("N", 0);
        
        for(int i = 0; i < n; i++) {
            String[] types = survey[i].split("");
            int score = choices[i] > 4 ? choices[i] - 4 : 4 - choices[i];
            
            if(choices[i] < 4) {
                hm.put(types[0], (hm.get(types[0]) + score));
            } else if(choices[i] > 4) {
                hm.put(types[1], (hm.get(types[1]) + score));
            }
         }
        
        // R T
        answer += compare("R", "T");
        // C F
        answer += compare("C", "F");
        // J M
        answer += compare("J", "M");
        // A N
        answer += compare("A", "N");
        
        return answer;
    }
    
    public static String compare(String s1, String s2) {
        int score1 = hm.get(s1);
        int score2 = hm.get(s2);
        
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        
        String value = "";
        
        if(score1 > score2) {
            return s1;
        } else if(score1 < score2) {
            return s2;
        }
        
        
        return c1 > c2 ? s2 : s1; // 같을 경우
    }
    
    public static void main(String args[]) {
    	String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
    	int[] choices = {5, 3, 2, 7, 5};
    	
    	System.out.println(solution(survey, choices));
    }
    
}
