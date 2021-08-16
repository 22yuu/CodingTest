package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2636_치즈_백업 {
	
	static int map[][];
	static boolean visited[][];
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int N, M;
	static int sum;
		
	static void print() {
		sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				System.out.print(map[i][j]);
				sum += map[i][j];
			}
			System.out.println();
		}
	}
	
	public static void dfs(int x, int y) {
		
      if (x == N - 1 && y == N - 1) {
          print();
          return;
       }
      
      if(x == 0 || y == 0 || x == N - 1 || y == M - 1) {
    	  map[x][y] = 0;
    	  visited[x][y] = true;
    	  return;
      }
      for(int d = 0; d < 4; d++) {
    	  
    	  int nx = x + dx[d];
    	  int ny = x + dy[d];
    	  
    	  if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
    	  
    	  if(visited[nx][ny]) continue;
    	  
    	  if(map[nx][ny] == 1) {
    		  
    		  
    	  }
    	  
      }
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		Stack<Integer> stack = new Stack<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
	}
}
