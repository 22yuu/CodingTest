package gold;

import java.util.*;
import java.io.*;

public class boj14500_테트로미노 {
	
	public static int N, M;
	public static int map[][];
	public static boolean visited[][];
	
	public static int dx[] = {-1, 1,  0, 0};
	public static int dy[] = { 0, 0, -1, 1};
	
	public static int max = Integer.MIN_VALUE;
	public static List<Integer> list;
	
	
	public static void  dfs(int x, int y, int cnt, int sum) {

		if(x == N && y == M) {
			if(cnt == 4) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		if(cnt == 4) {
			if(sum > max) {
				max = sum;
			}
			cnt = 1;
			sum = map[x][y];
			
			dfs(x, y, cnt, sum);
			return;
		}
		
		//System.out.printf("{%d, %d}\n", x, y);
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, cnt+1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	
	
	// ㅜ ㅏ ㅓ ㅗ ㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ
	public static void fuck(int x, int y, int cnt, int sum) {
		
		boolean left = false;
		boolean right = false;
		boolean top = false;
		boolean bottom = false;
		
		// 현재 위치에서 좌우 탐색 먼저
		for(int d = 2; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			
			if(d == 2) {
				left = true;
			}else if(d == 3) {
				right = true;
			}
		}
		
		// 현재 위치에서 상하 탐색
		for(int d = 0; d < 3; d++) {
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			
			if(d == 0) {
				top = true;
			}else if(d == 2) {
				bottom = true;
			}
		}
		
		// 좌우 모두 true면 ㅗ, ㅜ 판단
		if(left && right) {
			if(top) {
				
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
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,1,map[0][0]);
		fuck(0,0,1,map[0][0]);
		System.out.println(max);
	}
}
