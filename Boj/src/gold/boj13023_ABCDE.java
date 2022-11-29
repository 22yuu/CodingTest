package gold;

import java.util.*;
import java.io.*;

public class boj13023_ABCDE {
	
	private static int N, M;
	private static int[][] graph;
	private static int[] visited;
	private static int answer = 0;
	
	public static void dfs(int x, int depth) {
		if(depth >= 4) {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		graph = new int[N][N];
		visited = new int[N];
		
		
		for(int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		
	}
}
