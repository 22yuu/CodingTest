package bronze;

import java.util.*;
import java.io.*;

public class boj9093_단어뒤집기 {

	public static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		T = Integer.parseInt(br.readLine());
		
		Stack<String> stack = new Stack<>();
		
		for(int testcase = 0; testcase < T; testcase++) {
			
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			
//			for(int i = 0; i < str.length(); i++) {
//				stack.push(str.charAt(i) + "");
//			}
//			
//			while(!stack.isEmpty()) {
//				sb.append(stack.pop());
//			}
//			System.out.println(sb.reverse().toString());
			
			// 띄어쓰기를 구분자로 단어별로 구분해서 배열에 저장 
			String[] strArray = str.split(" ");
			
			// 스택을 이용해 단어를 역순으로 
			for(int i = 0; i < strArray.length; i++) {
				
				for(int j = 0; j < strArray[i].length(); j++) {
					stack.push(strArray[i].charAt(j)+"");
				}
				
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			
			System.out.println(sb.toString());
		} // test case 
		
	}
}
