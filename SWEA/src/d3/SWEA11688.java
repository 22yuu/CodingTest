package d3;

import java.io.*;

public class SWEA11688 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int a = 1;
			int b = 1;
			
			String[] inputs = br.readLine().split("");
			
			for(String s: inputs) {
				if(s.equals("L")) b = a + b;
				else a = a + b;
			}
			
			System.out.printf("#%d %d %d\n", test_case, a, b);
			
		}
		
	}
}
