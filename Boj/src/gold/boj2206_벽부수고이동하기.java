package gold;

import java.util.*;
import java.io.*;

public class boj2206_벽부수고이동하기 {

	public static int[][] map;
	public static boolean[][] visited;
	public static int N, M;
	public static int[] dx = {-1, 1,  0, 0};
	public static int[] dy = { 0, 0, -1, 1};
	public static boolean isWallDistoryed = false;
	public static int answer = 0;
	
	public static class Point {
		int x, y, value;
		
		Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while(true) {
			
			Point np = que.poll();
			System.out.println(np.x +", " + np.y + ", " + np.value);
			
//			if(np.x == N - 1 && np.y == M -1) {
//				answer = np.value;
//				break;
//			} else if(np == null) {
//				answer = -1;
//				return;
//			}
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
			
//				if(map[nx][ny] == 1 && !isWallDistoryed) {
//					if(isAvailable(np)) {
//						que.offer(new Point(nx, ny, np.value + 1));
//						isWallDistoryed = true;
//						map[nx][ny] = 0;
//					}
//				} else if(map[nx][ny] == 0){
//					que.offer(new Point(nx,ny, np.value + 1));
//				}
				
				
				que.offer(new Point(nx,ny, np.value + 1));
			}
		}
	}
	
	public static boolean isAvailable(Point point) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(point.x, point.y, point.value));
		
		while(true) {
			Point np2 = que.poll();
			
			if(np2.x == N-1 && np2.y == M-1) {
				return true;
			} else if(que.isEmpty()) {
				return false;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = np2.x + dx[d];
				int ny = np2.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				que.offer(new Point(nx, ny, np2.value + 1));
				visited[nx][ny] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		bfs(0,0);
		System.out.println(answer);
	}
}
