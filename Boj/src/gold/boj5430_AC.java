package gold;

import java.util.*;
import java.io.*;


public class boj5430_AC {
	
	private static int T, N;
	private static String P;
	private static ArrayDeque<Integer> deque;
	private static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		
		for(int t = 0; t < T; t++) {
			P = br.readLine();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			
			deque = new ArrayDeque<>();
			
			for(int i = 0; i < N; i++) deque.add(Integer.parseInt(st.nextToken()));
			
			AC(P);
			
		}
		
		System.out.println(sb);
	}
	
	public static void AC(String p) {
		
		boolean isRight = true; // 방향 플래그 변수
		
		for(char order : p.toCharArray()) {
				
			if(order == 'R') {
				isRight = !isRight;
				continue;
			}
			
			if(isRight) {
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		
		buildResultString(isRight);
	}
	
	private static void buildResultString(boolean isRight) {
		sb.append("[");
		
		if(deque.size() > 0) {
			
			if(isRight) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		} 
		
		sb.append("]\n");
	}
}
