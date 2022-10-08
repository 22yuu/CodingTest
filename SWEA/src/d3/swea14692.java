package d3;

import java.io.*;

public class swea14692 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String winner = "Bob";
			int N = Integer.parseInt(br.readLine());
			
			if(N % 2 == 0) winner = "Alice";
			
			System.out.printf("#%d %s\n", test_case, winner);
		}
	}
}
