package silver;

import java.util.*;
import java.io.*;

public class boj2606_바이러스 {

	public static int N, M; // 컴퓨터의 수, 네트워크 쌍의 수
	
	public static int[][] Graph;
	public static boolean[] visited;
	
	public static void bfs() {
		
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(1);
		visited[1] = true;
		int answer = 0;
		
		while(!que.isEmpty()) {
			
			int node = que.poll();
			
			
			for(int i = 1; i < Graph.length; i++) {
				
				if(Graph[node][i] == 1 && !visited[i]) {
					que.offer(i);
					visited[i] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		Graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Graph[A][B] = 1;
			Graph[B][A] = 1;
		}
		
		bfs();
			
	}
}
