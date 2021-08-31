package gold;

import java.util.*;
import java.io.*;


/* https://settembre.tistory.com/373
 * 
 * 1. �� �������� dfs�� Ȱ���� ���� �� ��带 ���Ѵ�.
 * 
 * 2. 1���� ���� ��带 �������� ���� �� ��θ� ���Ѵ�. => ��
 * 
 * �ش� ������ ���� ������ �ϳ��� ���� ��� ���� ���� ������ �̿��ؾ� �Ѵٴ� ���̴�.
 * ���� ����� ��� �޸� �ʰ��� �߻��Ѵ�.
 */
public class boj1967_Ʈ�������� {
	
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
		
		// ��Ʈ���� ���� �� ������ ����
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 0);
		
		
		System.out.println("max idx : " + max_idx);
		
		// ��Ʈ���� ���� �� �������� ���� �� ��θ� ���Ѵ�.
		visited = new boolean[N+1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		
		System.out.println(max);
		
	}
}
