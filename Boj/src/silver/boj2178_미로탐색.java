package silver;

import java.util.*;
import java.io.*;

public class boj2178_╧л╥не╫╩Ж {

	static int N, M;
	static int map[][];
	static boolean visited[][];
	
	static int dx[] = { -1, 1,  0, 0 };
	static int dy[] = {  0, 0 , -1, 1 }; // ╩С го аб ©Л
	static int answer = 0;
	
	public static class Point {
		int x, y, value;
		
		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	public static void bfs(int x, int y) {
		
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x,y,1));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Point np = que.poll();
			
			if(np.x == N-1 && np.y == M-1) answer = np.value;
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(visited[nx][ny] || map[nx][ny] == 0) continue;
				
				if(!visited[nx][ny]) {
					que.offer(new Point(nx, ny, np.value+1));
					map[nx][ny] = np.value+1;
					visited[nx][ny] = true;
				}
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
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(answer);
		

		
		br.close();
	}
	
	public static void print() {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
