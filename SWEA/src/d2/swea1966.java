package d2;

import java.util.*;
import java.io.*;


public class swea1966 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list;
		StringTokenizer st;
		StringBuilder sb;
		String answer = "";
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int nums = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < nums; n++) {
				int num = Integer.parseInt(st.nextToken());
				
				list.add(num);
			}
			
			Collections.sort(list);
			
			for(int i = 0; i < list.size(); i++) sb.append(list.get(i)).append(" ");
			
			answer = sb.toString();
			
			
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
}
