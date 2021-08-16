package sample;

import java.util.*;
import java.io.*;

public class sw1767_프로세서연결하기 {
	
	static int N;
	static int board[][];
	static boolean visited[][];
	static int dx[] = {1, -1, 0,  0};
	static int dy[] = {0,  0, 1, -1};
	static int dist[][][];
	
	public static void dfs(int x, int y) {
		
//		if(x == N-1 && y == N-1) {
//			// 여기 처리?
//			return;
//		}
		
		// 4방향 탐색
		for(int d = 0; d <4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if(visited[nx][ny] || board[nx][ny] == 1) continue;
			
			if(board[nx][ny] == 0 && !visited[nx][ny]) {
				dist[x][y][d%4] = conn(nx,ny,d,1);
				visited[nx][ny] = true;
			}
		}
	}
	
	public static int conn(int x, int y, int d, int count) {
		if(x == 0 || y == 0 || x == N-1 || y == N-1) {
			return count;
		} else if(visited[x][y] || board[x][y] == 1) {
			return N;
		}
		
		return conn(x+dx[d], y+dy[d], d, count+1);
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			visited = new boolean[N][N];
			dist = new int[N][N][4];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
					
					if(num == 1) visited[i][j] = true;
					
					if(i == 0 || j == 0 || i == N-1 || j == N-1) {
						Arrays.fill(dist[i][j], 0);
					}else {
						Arrays.fill(dist[i][j], 7);
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == 1) {
						dfs(i,j);
					}
				}
			}
			
			int sum = 0;
			
			for(int i =0 ; i < N; i++) {
				for(int j =0 ; j < N; j++) {
					int min = 0;
					if(board[i][j] == 1) {
						System.out.println(dist[i][j][0] + " "+ dist[i][j][1] + " " + " " + dist[i][j][2] +" "+ dist[i][j][3]);
						min = Math.min(dist[i][j][0], Math.min(dist[i][j][1], Math.min(dist[i][j][2], dist[i][j][3])));
						System.out.println(min);
						sum += min;
					}
				}
			}
			System.out.println("sum : " + sum);
		}
	}
}
