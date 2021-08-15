package silver;

import java.util.*;
import java.io.*;

public class boj14501_Επ»η_dfs {
	static int N;
	static int T[];
	static int P[];
	static int answer = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N+10]; // ³―Β₯
		P = new int[N+10]; // ±έΎΧ
		int[] dp = new int[N+10];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int index, int value) {
		if(index >= N) {
			answer = Math.max(answer, value);
			return;
		}
		
		if(index + T[index] <= N) dfs(index+T[index], value + P[index]);
		else dfs(index+T[index], value);
		
		dfs(index + 1, value);
	}
}
