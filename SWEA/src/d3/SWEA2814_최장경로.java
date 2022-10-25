package d3;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class SWEA2814_������ {
	
	public static List<List<Integer>> list;
	public static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			
			int N = Integer.parseInt(inputs[0]); // ������ ����
			int M = Integer.parseInt(inputs[1]); // ������ ����
			
			answer = 0;
			
			list = new ArrayList<>();
			// �ε����� 1���� �ϱ� ���� ���Ƿ� �� ���� �־��
			list.add(new<Integer>ArrayList());
			
			for(int i = 0; i < N; i++) {
				// ������ ���� ��ŭ list�� add
				list.add(new<Integer>ArrayList());
			}
			
			while(M-- > 0) {
				inputs = br.readLine().split(" ");
				int u = Integer.parseInt(inputs[0]);
				int v = Integer.parseInt(inputs[1]);
				// ������ �׷����̹Ƿ� �� ������ ���� ���� ����
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
		// ����[current]�� ����� ���� ����Ʈ
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
