package d3;

import java.util.*;
import java.io.*;

public class sw13547 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String answer = "NO";
			String str = br.readLine();
			int o_cnt = 0;
			int x_cnt = 0;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'x') {
					x_cnt++;
				} else {
					o_cnt++;
				}
			}
			
			if(o_cnt >= 8 || x_cnt < 8) answer = "YES";
			
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
}
