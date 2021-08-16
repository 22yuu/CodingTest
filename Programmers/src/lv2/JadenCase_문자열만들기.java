package lv2;

import java.util.*;

// 젤 처음에 풀었던법
//class Solution {
//    public String solution(String s) {
//		String answer = "";
//		String temp[] = temp = s.split(" ");
//		
//		for(int i = 0; i < temp.length; i++) {
//			temp[i] = temp[i].toLowerCase();
//			String tmpstr = temp[i].substring(0,1).toUpperCase();
//			
//			answer += tmpstr + temp[i].substring(1, temp[i].length());
//			if(i != (temp.length - 1)) {
//				answer += " ";
//			}
//		}
//		return answer;
//    }
//		public String solution(String s) {
//			String answer = "";
//			StringTokenizer st = new StringTokenizer(s, " ");
//			StringBuilder sb = new StringBuilder();
//			StringBuffer buffer = new StringBuffer();
//			
//			int cnt = 0;
//			while(st.hasMoreTokens()) {
//				String str = st.nextToken().toLowerCase();
//				String fchar = "";
//				
//				fchar = str.substring(0,1).toUpperCase();
//				
//				buffer.append(fchar + str.substring(1, str.length()) + " ");  
//				cnt++;
//			}
//			
//			return answer = buffer.deleteCharAt(buffer.length()-1).toString();
//		}
//}


class Solution {

	/*
	 다른사람 풀이
	  class Solution {
	  public String solution(String s) {
	        String answer = "";
	        String[] sp = s.toLowerCase().split("");
	        boolean flag = true;
	
	        for(String ss : sp) {
	            answer += flag ? ss.toUpperCase() : ss;
	            flag = ss.equals(" ") ? true : false;
	        }
	
	        return answer;
	  }
	}
	 */
   public String solution(String s) {
	   String answer = "";
	   String str = s.toLowerCase();
	   
	   for(int i = 0; i < str.length(); i++) {
		   
		   if(i == 0) {
			   answer += str.substring(i, 1).toUpperCase();
		   } else if (str.charAt(i-1) == ' ') {
			   answer += str.substring(i, i+1).toUpperCase();
			   //str = str.replace(str.charAt(i), Character.toLowerCase(str.charAt(i)));
		   } else {
			   answer += str.charAt(i);
		   }
		   
	   }
	   return answer;
   }
}

public class JadenCase_문자열만들기 {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution("3people unFollowed me"));
		System.out.println(sol.solution("for the last week"));
		System.out.println(sol.solution("Adgagd 3eagdag ")); // 계속 틀리는 이유... 뒤에 공백 ㅅㅂ
		
		
		
	}
}
