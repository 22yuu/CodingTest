package silver;

import java.io.*;
import java.util.*;

public class boj7576_토마토_bfs {

	static int N, M;
	static int map[][];
	static int dx[] = {1, -1, 0,  0};
	static int dy[] = {0,  0, 1, -1};
	static int total_tomato = 0;
	static int tomato = 0;
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		Queue<Point> que = new LinkedList<>();

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) que.offer(new Point(i,j));
			}
		}
		
		while(!que.isEmpty()) {
			Point np = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
				
				if(map[nx][ny] != 0) continue;
				
				map[nx][ny] = map[np.x][np.y] + 1;
				
				que.offer(new Point(nx, ny));
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					// 토마토가 익지 못한 경우
					System.out.println(-1);
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max-1);
	}
}
