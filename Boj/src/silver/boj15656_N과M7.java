package silver;

import java.util.*;
import java.io.*;

public class boj15656_N과M7 {

	private static int N, M;
	private static int[] nums;
	private static int[] sel;
	private static StringBuilder sb = new StringBuilder();
	
	public static void combination(int idx) {
		
		if(idx == M) {
			for(int i : sel) sb.append(i + " ");
			sb.append("\n");
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			sel[idx] = nums[i];
			combination(idx+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		sel = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combination(0);
		
		System.out.println(sb.toString());

	}

}
