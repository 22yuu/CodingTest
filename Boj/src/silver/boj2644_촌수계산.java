package silver;

import java.io.*;

public class boj2644_촌수계산 {
	
	private static int N, M, answer;
	private static int map[][];
	private static boolean visited[][];
	
	private static void dfs(int start, int end, int depth) {
		
		if(start == end) {
//			System.out.println(depth);
			answer = depth;
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			
			if(map[start][i] == 1 && !visited[start][i]) {
				visited[start][i] = true;
				visited[i][start] = true;
//				System.out.println(start + " " + i);
				dfs(i, end, depth + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		String[] inputs = br.readLine().split(" ");
		
		M = Integer.parseInt(br.readLine());

		// 서로 다른 두 사람 A, B
		int A = Integer.parseInt(inputs[0]);
		int B = Integer.parseInt(inputs[1]);
		
		for(int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			
			int a = Integer.parseInt(inputs[0]);
			int b = Integer.parseInt(inputs[1]);
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(A, B, 0);
		
		System.out.println(answer > 0 ? answer : -1);
		
	}
}
