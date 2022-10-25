package d3;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class SWEA2814_최장경로 {
	
	public static List<List<Integer>> list;
	public static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			
			int N = Integer.parseInt(inputs[0]); // 정점의 개수
			int M = Integer.parseInt(inputs[1]); // 간선의 개수
			
			answer = 0;
			
			list = new ArrayList<>();
			// 인덱스를 1부터 하기 위해 임의로 한 개를 넣어둠
			list.add(new<Integer>ArrayList());
			
			for(int i = 0; i < N; i++) {
				// 정점의 개수 만큼 list에 add
				list.add(new<Integer>ArrayList());
			}
			
			while(M-- > 0) {
				inputs = br.readLine().split(" ");
				int u = Integer.parseInt(inputs[0]);
				int v = Integer.parseInt(inputs[1]);
				// 무방향 그래프이므로 양 정점에 간선 정보 저장
				list.get(u).add(v);
				list.get(v).add(u);
			}
			
			for(int start = 1; start <= N; start++) {
				dfs(start, 1, new boolean[N+1]);
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
			
		}
	}
	
	private static void dfs(int current, int cost, boolean[] visited) {
		visited[current] = true;
		// 정점[current]와 연결된 정점 리스트
		List<Integer> to = list.get(current);
		for(int i = 0; i < to.size(); i++) {
			int next = to.get(i);
			if(!visited[next]) {
				dfs(next, cost + 1, visited);
				visited[next] = false;
			}
		}
		
		visited[current] = false;
		answer = Math.max(answer, cost);
	}
}
