package bronze;

import java.util.*;
import java.io.*;

public class boj9093_�ܾ������ {

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
			
			// ���⸦ �����ڷ� �ܾ�� �����ؼ� �迭�� ���� 
			String[] strArray = str.split(" ");
			
			// ������ �̿��� �ܾ �������� 
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
