package silver;

import java.io.*;
import java.util.*;

public class boj15657_N과M8 {

	private static int N, M;
	private static int[] sel;
	private static int[] nums;
	private static StringBuilder sb = new StringBuilder();
	
	public static void combination(int start, int idx) {
		
		if(idx == M) {
			for(int i : sel) sb.append(i + " ");
			sb.append("\n");
			
			return;
		}
		
		for(int i = start; i < N; i++) {
			sel[idx] = nums[i];
			combination(i, idx+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combination(0, 0);
		
		System.out.print(sb.toString());
		
		

	}

}
