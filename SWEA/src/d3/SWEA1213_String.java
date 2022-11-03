package d3;

import java.io.*;

public class SWEA1213_String {
	
	private static int T = 10;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int testCase = Integer.parseInt(br.readLine());
			String pattern = br.readLine();
			String str = br.readLine();
			int count = 0;
			str = str.replace(pattern, "_");
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '_') count++;
			}
			
			System.out.printf("#%d %d\n", test_case, count);
		}
		
	}
}
