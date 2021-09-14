package silver;

import java.util.*;
import java.io.*;


public class boj1303_¿¸¿Ô_¿¸≈ı {
	
	public static int N, M;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1,  0, 0};
	public static int[] dy = { 0, 0, -1 ,1};
	public static int[] result = new int[2];
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(int x, int y, char color) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x, y));
		visited[x][y] = true;
		int count = 1;
		
		while(!que.isEmpty()) {
			
			Point np = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != color) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				
				que.offer(new Point(nx, ny));
				count++;
			}
		}
		return count;
	}

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'W' && !visited[i][j]) {
					int cnt = bfs(i,j, 'W');
					result[0] += cnt * cnt;
					
				}
				else if(map[i][j] == 'B' && !visited[i][j]) {
					int cnt = bfs(i,j, 'B');
					result[1] += cnt * cnt;
					
				}
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
	}
}
