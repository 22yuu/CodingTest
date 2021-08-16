package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class BFS_�̷�Ż�� {
	// ��� 4���� Ž��
	// 1�� ������ �̵�
	// �̵� �� 4 ���� Ž��
	// 1�� ������ �̵�, �̵� �� 4���� Ž���ϰ�, �� ���� ������ �ٽ� �ڷ�
	static int N, M;
	static int[][] map;
	static boolean visited[][];
	static int dx[] = {1, -1, 0, 0 };
	static int dy[] = {0, 0, 1, -1 };
	
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(int x, int y) {
		
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x,y));
		
		while(!que.isEmpty()) {
			Point np = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				//if(visited[nx][ny]) continue;
				
				if(map[nx][ny] == 0) continue;
				
				if(map[nx][ny] == 1) {
					visited[nx][ny] = true;
					map[nx][ny] = map[np.x][np.y] + 1;
					que.offer(new Point(nx, ny));
				}
			}
			
		}
		return map[N-1][M-1];
	}
	    
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i =0; i < N; i++) {
			String str = br.readLine();
			for(int j =0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		visited[0][0] = true;
		System.out.println(bfs(0,0));
		
		for(int i =0; i < N; i++) {
			for(int j =0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
