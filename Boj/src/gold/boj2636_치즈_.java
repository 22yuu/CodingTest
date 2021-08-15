package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2636_치즈_ {
	
	static int map[][];
	static boolean visited[][];
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int N, M;
	static int sum;
	
	static class Point{
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
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
	
	public static void bfs(int x, int y) {
		
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(0, 0));
		
		if(x == 0 || y == 0 || x == N - 1 || y == M - 1) { // 가장자리에 치즈가 있을 경우의 처리를 위한 if문
			if(map[x][y] == 0) { // 가장자리 값이 0이면 방문처리
				visited[x][y] = true;
				
			} else { // 아니면 방문처리하고 0
				map[x][y] = 0;
				visited[x][y] = true;
			}
		}
		
		while(!que.isEmpty()) {
			Point np = que.poll();
			if(np.x == N - 1 && np.y == M - 1) {
				print();
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = np.x + dx[d];
				int ny = np.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				
				if(visited[nx][ny]) continue;
				
				
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;
					visited[nx][ny] = true;
					continue;
				}
				
				visited[nx][ny] = true;
				que.offer(new Point(nx,ny));
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
		
		
		
		int hours = 0;
		while(true) {
			
			visited = new boolean[N][M];
			
			print();
			
			if(sum == 0) {
				System.out.println(hours);
				if(stack.isEmpty()) {
					System.out.println(sum);
				} else {
					System.out.println(stack.pop());
				}
				break;
			} else {
				stack.push(sum);
			}
			
			bfs(0,0);
			hours++;
			System.out.println();
			if(hours > 3) break;
		}
	}
}
