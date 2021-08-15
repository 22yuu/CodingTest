package lv2;

import java.util.Stack;

public class ¿Ã¹Ù¸¥°ýÈ£ {

	static class solution {
		boolean solution(String s) {
			boolean answer = false;
			String str = s;
			Stack<Character> stack = new Stack<>();
			
			if(s.charAt(0) == ')') return false;
			
			for(int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				
				switch(ch) {
					case '(':
						stack.push(ch);
						break;
					case ')':
						stack.pop();
						break;
				}
			}
			
			if(stack.isEmpty()) {
				answer = true;
			}
			return answer;
		}
	}
	
	public static void main(String[] args) {
		String str[] = { "()()","(())()", ")()(", "(()("};
		
		solution sol = new solution();
		
		for(String s : str) {
			System.out.println(sol.solution(s));
		}
	}
}
