package gold;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	
	int end, weight;
	
	Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}

public class boj1916_최소비용구하기 {
	private static int N, M, S, E; // 도시, 버스의 수, 출발 도시, 도착 도시 
	private static ArrayList<ArrayList<Node>> list;
	private static int[] dist;
	private static boolean[] visited;
	
	
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int current = curNode.end;
			
			if(!visited[current]) {
				visited[current] = true;
				
				for(Node node : list.get(current)) {
					
					if(!visited[node.end] && (dist[node.end] > dist[current] + node.weight)) {
						dist[node.end] = dist[current] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[end];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = {};
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList<>();

		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			inputs = br.readLine().split(" ");
			
			int s = Integer.parseInt(inputs[0]);
			int e = Integer.parseInt(inputs[1]);
			int cost = Integer.parseInt(inputs[2]);
			
			list.get(s).add(new Node(e, cost));
		}
		
		inputs = br.readLine().split(" ");
		S = Integer.parseInt(inputs[0]);
		E = Integer.parseInt(inputs[1]);
		
		System.out.println(dijkstra(S, E));
		br.close();
	}

}
