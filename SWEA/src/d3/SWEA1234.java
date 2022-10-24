package d3;

import java.io.*;

public class SWEA1234 {
public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String inputs = br.readLine().split(" ")[1];
			
			char prev = '\0';
//			System.out.println(prev == '\0');
			int idx = 0;
			while(true) {
				
				if(inputs.length() == idx) break;
				
				if(prev == '\0') {
					prev = inputs.charAt(idx++);
					continue;
				}
				
				if(prev == inputs.charAt(idx)) {
					inputs = inputs.substring(0, idx-1) + inputs.substring(idx+1);
					idx = 0;
					prev = '\0';
				} else {
					prev = inputs.charAt(idx++);
				}
				
//				System.out.println(inputs + " " + idx);
			}
			
			System.out.printf("#%d %s\n",test_case, inputs);
		}
	}
}
