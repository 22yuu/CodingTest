package silver;

import java.util.*;
import java.io.*;

public class boj1182_부분수열의합 {
	
	private static int N, S, answer;
	private static int[] nums;
	
	public static void rec_func(int k, int value ) {
		
		if(k == N + 1) {
			
			if(value == S) answer++;
		} else {
			// K 번째 원소 포함
			rec_func(k+1, value + nums[k]);
			// k 번째 원소 미포함
			rec_func(k+1, value);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		rec_func(1, 0);
		if(S == 0) answer--;
		System.out.println(answer);
	}

}
