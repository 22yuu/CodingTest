package d2;

import java.util.*;
import java.io.*;

public class swea1959 {
	
	public static int FindMaxValue(int[] s_arr, int[] l_arr) {
		int max = Integer.MIN_VALUE;
		
		int s_size = s_arr.length;
		int l_size = l_arr.length;
		

		for(int i = 0; i <= l_size - s_size; i++) {
			int sum = 0;
			int index = 0;
			for(int j = 0; j < s_size; j++) {
				sum += s_arr[j] * l_arr[i + index];
				index++;
			}
			max = Math.max(max, sum);
		}
	
		
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arrayA = new int[N];
			int[] arrayB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arrayA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				arrayB[i] = Integer.parseInt(st.nextToken());
			}
			
			
			if(N > M) {
				System.out.printf("#%d %d\n",test_case, FindMaxValue(arrayB, arrayA));
			} else {
				System.out.printf("#%d %d\n",test_case, FindMaxValue(arrayA, arrayB));
			}
			
		} // end test case for loop
	} // end main
}
