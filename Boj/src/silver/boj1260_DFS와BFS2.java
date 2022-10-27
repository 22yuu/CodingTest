package silver;

import java.util.*;
import java.io.*;

public class boj1260_DFS와BFS2 {
	
	private static int N, M, V; // 정점의 개수, 간선의 개수, 시작할 정점 번호
	private static int[][] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		V = Integer.parseInt(inputs[2]);
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i <M; i++) {
			inputs = br.readLine().split(" ");
			int x = Integer.parseInt(inputs[0]);
			int y = Integer.parseInt(inputs[1]);
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false); // visited 초기화
		bfs(V);
		
	}
	
	public static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		for(int i = 1; i < N+1; i++) {
			if(graph[start][i] == 1 && !visited[i]) dfs(i);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			for(int i = 1; i < N+1; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
