package d3;

import java.util.*;
import java.io.*;

public class SW1230_암호문3 {

	public static int T = 10;
	public static List<String> password = new ArrayList<>(); 
	public static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			String orgPassword = br.readLine();
			int nOrders = Integer.parseInt(br.readLine()); // 명령어의 개수
			String orders = br.readLine();
			String answer = "";
			
			st = new StringTokenizer(orgPassword);
			
			while(st.hasMoreTokens()) {
				password.add(st.nextToken());
			}
			
			st = new StringTokenizer(orders);
			
			while(st.hasMoreTokens()) {
				String order = st.nextToken();
				
				if(order.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					String[] s = new String[y];
					
					for(int i = 0; i < y; i++) {
						s[i] = st.nextToken();
					}
					
					insert(x, s);
					
				} else if(order.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					delete(x, y);
					
				} else if(order.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					String[] s = new String[y];
					
					for(int i = 0; i < y; i++) {
						s[i] = st.nextToken();
					}
					
					add(s);
					
				}
					
			}
			
			
			for(int i = 0; i < 10; i++) {
				answer += password.get(i) + " ";
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
	public static void insert(int x, String[] s ) {
		// 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.
		
		int idx = x;
		
		for(int i = 0; i < s.length; i++) {
			password.add(idx++, s[i]);
		}
		
	}
	
	public static void delete(int x, int y) {
		// x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
		
		for(int i = x; i <= x+y; i++) {
			password.remove(i);
		}
		
	}
	
	public static void add(String[] s) {
		// 암호문 맨 뒤에 y개의 숫자를 덧붙인다.
		for(int i = 0; i < s.length; i++) {
			password.add(s[i]);
		}
	}
}
