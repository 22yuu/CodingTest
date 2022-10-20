package d3;

import java.util.*;
import java.io.*;

public class swea14361 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String N = br.readLine();
			int num = Integer.parseInt(N);
			String[] str = N.split("");
			String answer = "possible";
			int length = str.length;
			int nums[] = new int[10];
			int mul = 2;
			
			if(length == 1) {
				answer = "impossible";
				System.out.printf("#%d %s\n", test_case, answer);
				continue;
			}
			
			
			for(int i = 0; i < str.length; i++) {
				nums[Integer.parseInt(str[i])]++;
			}
			
			while(true) {
				int temp = mul * num;
				int count = 0;
				int tempLength = (int)(Math.log10(temp)+1);
				
				if(tempLength > length) {
					answer = "impossible";
					break;
				}
				
				while(true) {
					int idx = temp % 10;
					temp /= 10;
					
					if(nums[idx] == 1) count++;
					
					if(temp == 0) break;
				}
				
				if(count == tempLength) break;
				
				mul++;
			}
			
		
			
			System.out.printf("#%d %s\n", test_case, answer);
		}
	}
}
