package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	
	public static List<Edge> edgeList = new ArrayList<>();
	public static int answer = 0;
	
	// 부모 노드를 찾는 함수
	public static int getParent(int parent[], int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = getParent(parent, parent[x]);
	}

	// 두 부모 노드를 합치는 함수
	public static void unionParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a < b)
			parent[b] = a; // 부모를 합칠 때는 더 작은 값으로 합친다.
		else
			parent[a] = b;
	}

	// 같은 부모를 가지는지 확인
	public static boolean findParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a == b)
			return true;
		return false;
	}
	
	// 간선 클래스 선언
	public static class Edge implements Comparable<Edge>{
		int node, parent, distance;
		
		public Edge(int node, int parent, int distance) {
			this.node = node;
			this.parent = parent;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Edge o) {
			
			return distance - o.distance;
		}
	}

	public static void main(String[] args) {
		int n = 7;
		int m = 11;
	
		int[] parent = new int[n+1];
		
		for(int i = 1; i <= n; i++) parent[i] = i;
		
		edgeList.add(new Edge(1, 7, 12));
		edgeList.add(new Edge(1, 4, 28));
		edgeList.add(new Edge(1, 2, 67));
		edgeList.add(new Edge(1, 5, 17));
		edgeList.add(new Edge(2, 4, 24));
		edgeList.add(new Edge(2, 5, 62));
		edgeList.add(new Edge(3, 5, 20));
		edgeList.add(new Edge(3, 6, 37));
		edgeList.add(new Edge(4, 7, 13));
		edgeList.add(new Edge(5, 6, 45));
		edgeList.add(new Edge(5, 7, 73));
		
		// 간선의 비용을 기준으로 오름차순 정렬
		Collections.sort(edgeList);
		
		// 각 정점이 포함된 그래프가 어디인지 저장
		int sum  = 0;
		for(int i = 0; i < edgeList.size(); i++) {
			// 사이클이 발생하지 않는 경우 그래프에 포함
			if(!findParent(parent, edgeList.get(i).node, edgeList.get(i).parent)) {
				answer += edgeList.get(i).distance;
				unionParent(parent, edgeList.get(i).node, edgeList.get(i).parent);
			}
		}
		
		System.out.println(answer);
		
	}
}
