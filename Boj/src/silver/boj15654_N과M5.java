package silver;

import java.io.*;
import java.util.*;

public class boj15654_N°úM5 {
	private static int N, M;
	private static int[] sel;
	private static int[] nums;
	private static boolean[] visited;
	
	public static void combination(int idx) {
		
		
		if(idx == M) {
			for(int i : sel) System.out.print(i + " ");
			System.out.println();
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[idx] = nums[i];
				combination(idx+1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		nums = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		combination(0);
		
	}

}
