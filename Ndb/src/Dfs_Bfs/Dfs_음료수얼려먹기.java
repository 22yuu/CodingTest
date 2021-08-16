package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Dfs_음료수얼려먹기 {
	
	static int N, M;
	static int[][] map;
	static boolean visited[][];
	static int count = 0;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
		
//	public static boolean dfs(int x, int y) {	
//		
//
//		if(map[x][y] == 0) {
//			visited[x][y] = true;
//			
//			for(int d = 0; d < 4; d++) {
//				int nx = x + dx[d];
//				int ny = y + dy[d];
//				
//				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
//				
//				if(visited[nx][ny]) continue;
//				
//				dfs(nx, ny);
//			}
//			return true;
//		}
//		return false;
//	}
	
//	 public static boolean dfs(int x, int y) {
//	        // 주어진 범위를 벗어나는 경우에는 즉시 종료
//	        if (x <= -1 || x >= N || y <= -1 || y >= M) {
//	            return false;
//	        }
//	        // 현재 노드를 아직 방문하지 않았다면
//	        if (map[x][y] == 0) {
//	            // 해당 노드 방문 처리
//	        	map[x][y] = 1;
//	            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
//	            dfs(x - 1, y);
//	            dfs(x, y - 1);
//	            dfs(x + 1, y);
//	            dfs(x, y + 1);
//	            return true;
//	        }
//	        return false;
//	    }
	 
	 public static boolean dfs(int x, int y) {
			
			// map의 범위 초과시 return
			if(x < 0 || y < 0 || x >= N || y >= M) return false;
			
			if(visited[x][y]) {
				return false;
			} else {
				visited[x][y] = true;
			}
			
			// map의 값이 0이 아닐 경우
			if(map[x][y] == 0) {
				
				visited[x][y] = true;
				
				// 주변 4방향 탐색 후
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					dfs(nx, ny);
				}
				return true;
			}
			
			return false;
		}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(dfs(i,j)) {
					System.out.println("true");
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
