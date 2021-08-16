package gold;
import java.util.*;
import java.io.*;

public class boj1197_최소스패닝트리 {

	public static List<Edge> list = new ArrayList<>();
	public static int answer = 0; 
	
	// 부모노드 값 가져오기
	public static int getParent(int parent[], int x) {
		if(parent[x] == x) return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	// 합치기
	public static void union(int parent[], int a, int b) {
		a = parent[a];
		b = parent[b];
		
		if( a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	
	// 같은 부모인지?
	public static boolean isSameParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		
		return a==b;
	}
	
	public static class Edge implements Comparable<Edge>{
		int node, parent, weight;
		
		public Edge(int node, int parent, int weight) {
			this.node = node;
			this.parent = parent;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(boj1197_최소스패닝트리.Edge o) {
			return weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int parent[] = new int[V + 1];
		for(int i = 1; i <= V; i++) parent[i] = i;
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			
			int node = Integer.parseInt(st.nextToken());
			int pnode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(node, pnode, weight));
		}
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++ ) {
			Edge edge = list.get(i);
			if(!isSameParent(parent, edge.node, edge.parent)) {
				answer += edge.weight;
				union(parent, edge.node, edge.parent);
			}
		}
		
		System.out.println(answer);
	}
}
