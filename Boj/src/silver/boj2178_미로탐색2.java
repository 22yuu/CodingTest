package silver;

import java.util.*;
import java.io.*;

public class boj2178_¹Ì·ÎÅ½»ö2 {
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0,  0, -1,1};
	private static int answer = 0;
	
	
	public static class Pointer {
		int x, y, count;
		
		public Pointer(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pointer> que = new LinkedList<>();
		que.offer(new Pointer(x, y, 1));
		visited[x][y] = true;
		
		while(!que.isEmpty() ) {
			Pointer np = que.poll();
			
			if(np.x == N-1 && np.y == M-1) answer = np.count; 
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(visited[nx][ny] || map[nx][ny] == 0) continue;
				
				que.offer(new Pointer(nx, ny, np.count+1));
				map[nx][ny] = np.count+1;
				visited[nx][ny] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			inputs = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
			}
		}
		
		bfs(0, 0);
		System.out.println(answer);
		br.close();
	}
}
