package gold;

import java.util.*;
import java.io.*;

public class boj2665_미로만들기 {

	private static int N;
	private static int[][] map;
	private static int[][] dist;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	
	private static class Pointer {
		int x, y;
		
		Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static int bfs(int x, int y) {
		Queue<Pointer> que = new LinkedList<>();
		que.offer(new Pointer(x, y));
		dist[x][y] = 0;
		
		while(!que.isEmpty()) {
			Pointer np = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && (dist[nx][ny] > dist[np.x][np.y])) {
					
					if(map[nx][ny] == 1) {
						dist[nx][ny] = dist[np.x][np.y];
						que.offer(new Pointer(nx, ny));
					} else {
						dist[nx][ny] = dist[np.x][np.y] + 1;
						que.offer(new Pointer(nx, ny));
					}
				}
			}
		}
		
		
		return dist[N-1][N-1];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dist = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(bfs(0,0));
		
		
		
	}
}
