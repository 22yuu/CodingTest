package gold;

import java.util.*;
import java.io.*;


/* https://settembre.tistory.com/373
 * 
 * 1. 한 정점에서 dfs를 활용해 가장 먼 노드를 구한다.
 * 
 * 2. 1에서 구한 노드를 시작으로 가장 긴 경로를 구한다. => 답
 * 
 * 해당 문제의 주의 사항중 하나는 인접 행렬 말고 인접 리슽를 이용해야 한다는 점이다.
 * 인접 행렬인 경우 메모리 초과가 발생한다.
 */
public class boj1967_트리의지름 {
	
	public static int N;
	public static boolean visited[];
	public static List<Node> list[];
	public static int max = Integer.MIN_VALUE;
	public static int max_idx = 0;
	
	public static class Node {
		 int node, weight;
		 
		 public Node(int node, int weight) {
			 this.node = node;
			 this.weight = weight;
		 }
	}
	
	public static void dfs(int idx, int value) {
		
		if(max < value) {
			max = value;
			max_idx = idx;
		}
		
		for(Node a : list[idx]) {
			if(!visited[a.node]) {
				visited[a.node] = true;
				dfs(a.node, value+a.weight);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for(int i = 0; i<= N; i++) list[i] = new ArrayList<>();
		
		
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[parent].add(new Node(child, weight));
			list[child].add(new Node(parent, weight));
		}
		
		// 루트에서 가장 먼 정점을 구함
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 0);
		
		
		System.out.println("max idx : " + max_idx);
		
		// 루트에서 가장 먼 정점에서 가장 긴 경로를 구한다.
		visited = new boolean[N+1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		
		System.out.println(max);
		
	}
}
