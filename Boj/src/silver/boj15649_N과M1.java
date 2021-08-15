package silver;

import java.util.*;
import java.io.*;

public class boj15649_N°úM1 {

	public static int N, M;
	public static boolean[] visit;
	public static int[] arr;
	
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0; i <N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr  = new int[M];
		visit = new boolean[N];
		dfs(0);
	}
}
