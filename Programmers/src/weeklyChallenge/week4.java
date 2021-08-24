package weeklyChallenge;

import java.util.*;

/*
 * ���α׷��ӽ� weekly challenge 4����
 * ���� 2 ������ ��õ�ϱ�
 * https://programmers.co.kr/learn/courses/30/lessons/84325
 * 
 */
public class week4 {
	
	static class Solution {
	    // 1. lanaguages�� �� üũ�ϸ� �ȴ�.
	    // 2. ��� ���̺� �迭���� languages�� �������� ������ ���
	    // 3. max���� ã�´�.
	    
	    public String solution(String[] table, String[] languages, int[] preference) {
	        StringTokenizer st;
	        Arrays.sort(table); // ���� max���� ���� ��� ī�װ��� ���������� ���� ���� ������ �ȴ�.
	        String[] categories = new String[5];
	        String[][]  newTable = new String[5][5];
	        int[] scores = new int[5];
	        int max = Integer.MIN_VALUE;
	        int maxIdx = 0;
	        
	        String answer = "";
	        
	        
	        
	        // �迭�� �Է�
	        for(int i = 0; i < 5; i++) {
	            st = new StringTokenizer(table[i]);
	            categories[i] = st.nextToken(); // ī�װ� SI CONTENTS HARDWARE PORTAL GAME
	            for(int j = 0; j < 5; j++) {
	                newTable[i][j] = st.nextToken();
	            }
	        }
	        
	        for(int i = 0; i < 5; i++) {
	            for(int j = 0; j < languages.length; j++) {
	                String lang = languages[j];
	                for(int k = 0; k < 5; k++) {
	                    if(lang.equals(newTable[i][k])) {
	                        scores[i] += preference[j] * (5 - k);
	                    }
	                }
	                
	                if(scores[i] > max) {
	                    max = scores[i];
	                    maxIdx = i;
	                }
	            }
	        } // for end
	        
	        
	        answer = categories[maxIdx];
	        
	        return answer;
	    }
	}

	
	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[]	 preference = {7,5,5};
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(table, languages, preference));
		
		
	}
}
