package d2;

import java.util.*;
import java.io.*;

public class swea1976 {
	public static void main(String args[]) throws Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String answer = "";
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			
			
			int hour = h1 + h2 >= 12 ? (h1+h2) % 12 : h1+h2;
			int min = m1 + m2;
			
			if(min >= 60) {
				hour += 1;
				min %= 60;
			}
			
			sb.append(hour).append(" ").append(min);
			
			answer = sb.toString();
			
			System.out.printf("#%d %s\n", test_case, answer);
			
		}
	}
}
