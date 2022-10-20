package d3;

import java.util.*;
import java.io.*;

public class swea1206 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];
			int idx = 0;
			
			for(String num : br.readLine().split(" "))  buildings[idx++] = Integer.parseInt(num);
			
			for(int i = 2; i < N-2; i++) {
				int max = Integer.MIN_VALUE;
				
				max = Math.max(max, buildings[i-2]);
				max = Math.max(max, buildings[i-1]);
				max = Math.max(max, buildings[i+1]);
				max = Math.max(max, buildings[i+2]);
				
				answer = max > buildings[i] ? answer :  answer + (buildings[i] - max);
			}
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
