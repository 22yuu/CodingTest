package silver;

import java.util.*;
import java.io.*;

public class boj9012_°ýÈ£ {

	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				
				if(stack.isEmpty()) {
					stack.push(str.charAt(j));
				} else {
					char ch = stack.peek();
					
					if(ch == str.charAt(j)) {
						stack.push(str.charAt(j));
					} else {
						if(ch == '(') {
							if(str.charAt(j) == ')') {
								stack.pop();
							} else {
								stack.push(ch);
							}
						} else {
							stack.push(ch);
						}
					}
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
