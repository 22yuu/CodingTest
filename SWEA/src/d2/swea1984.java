package d2;

import java.util.*;
import java.io.*;

public class swea1984 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nums[] = new int[10];
			double sum = 0;
			//int answer = 0;
			
			for(int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			
			for(int i = 1; i < 9; i++) {
				sum += nums[i];
			}
			
			System.out.printf("#%d %d\n", test_case, Math.round(sum / 8));
			
		}
	}
}
