package silver;

import java.util.*;
import java.io.*;

public class boj10828_스택 {

	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String command = br.readLine();
			
			String[] arr = command.split(" ");
			
			if(arr.length == 2) {
				// 명령어가 push
				stack.add(Integer.parseInt(arr[1]));
				continue;
			} else if(arr[0].matches("pop")) {
				// pop
				if(stack.isEmpty()) {
					sb.append("-1");
				} else {
					sb.append(stack.pop());
				}
			} else if(arr[0].matches("size")) {
				// size
				sb.append(stack.size());
			} else if(arr[0].matches("empty")) {
				// empty
				if(stack.isEmpty()) {
					// 스택이 비어있을 경우
					sb.append("1");
				} else {
					// 스택이 비어있지 않을 경우
					sb.append("0");
				}
			} else {
				// top
				if(stack.isEmpty()) {
					sb.append("-1");
				} else {
					sb.append(stack.peek());
				}
			}
			
			sb.append("\n");
		} // end for
		
		System.out.println(sb.toString());
		
	}
}
