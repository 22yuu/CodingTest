package silver;

import java.io.*;
import java.util.*;

public class boj15655_N°úM6 {

	private static int N, M;
	private static int[] nums;
	private static int[] sel;
	private static boolean[] visited;

	public static void combination(int start, int idx) {
		
		if(idx == M) {
			for(int i : sel) System.out.print(i + " ");
			System.out.println();
			
			return;
		}
		
		
		for(int i = start; i < N; i++) {
			
			if(visited[i]) continue;
			
			visited[i] = true;
			sel[idx] = nums[i];
			combination(i, idx+1);
			visited[i] = false;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combination(0,0);
		
	}

}
