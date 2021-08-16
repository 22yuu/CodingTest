package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	
	public static List<Edge> edgeList = new ArrayList<>();
	public static int answer = 0;
	
	// �θ� ��带 ã�� �Լ�
	public static int getParent(int parent[], int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = getParent(parent, parent[x]);
	}

	// �� �θ� ��带 ��ġ�� �Լ�
	public static void unionParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a < b)
			parent[b] = a; // �θ� ��ĥ ���� �� ���� ������ ��ģ��.
		else
			parent[a] = b;
	}

	// ���� �θ� �������� Ȯ��
	public static boolean findParent(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a == b)
			return true;
		return false;
	}
	
	// ���� Ŭ���� ����
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
		
		// ������ ����� �������� �������� ����
		Collections.sort(edgeList);
		
		// �� ������ ���Ե� �׷����� ������� ����
		int sum  = 0;
		for(int i = 0; i < edgeList.size(); i++) {
			// ����Ŭ�� �߻����� �ʴ� ��� �׷����� ����
			if(!findParent(parent, edgeList.get(i).node, edgeList.get(i).parent)) {
				answer += edgeList.get(i).distance;
				unionParent(parent, edgeList.get(i).node, edgeList.get(i).parent);
			}
		}
		
		System.out.println(answer);
		
	}
}
