package silver;

import java.util.*;
import java.io.*;

public class boj15651_N°úM3 {
	
	static int N, M;
	static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int depth) {
		
		if(depth == M) {
			for(int num : arr) sb.append(num + " ");
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[depth] = i+1;
			dfs(depth + 1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(0);
		System.out.println(sb);
	}
}
