package gold;

import java.util.*;
import java.io.*;

public class boj2206_벽부수고이동하기 {

	public static int[][] map;
	public static boolean[][][] visited;
	public static int N, M;
	public static int[] dx = {-1, 1,  0, 0};
	public static int[] dy = { 0, 0, -1, 1};
	public static int answer = 0;
	
	public static class Point {
		int x, y, value, breakWall;
		
		Point(int x, int y, int value, int breakWall) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.breakWall = breakWall;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, 1, 0));
		
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		
		while(!que.isEmpty()) {
			
			Point np = que.poll();
			//System.out.println(np.x +", " + np.y + ", " + np.value);
			
			if(np.x == N - 1 && np.y == M -1) {
				answer = np.value;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				int breakWall = np.breakWall;
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(map[nx][ny] == 1) {
					if(breakWall == 0 && !visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						que.offer(new Point(nx, ny, np.value + 1, 1));
					}
				} else {
					if(!visited[nx][ny][breakWall]) {
						que.offer(new Point(nx,ny, np.value + 1, breakWall));
						visited[nx][ny][breakWall] = true;
					}
				}
			}
		}
		answer = -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		bfs(0,0);
		System.out.println(answer);
	}
}
