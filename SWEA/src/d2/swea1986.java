package d2;

import java.util.*;
import java.io.*;


public class swea1986 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int result = 0;
			for(int i = 1; i <= n; i++) {
				
				if(i%2 == 0 ) {
					result -= i;
				} else {
					result += i;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}
