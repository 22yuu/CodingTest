package graph;

import java.util.*;
import java.io.*;

public class Dijkstra {
	
	public static class Graph {
		private int n;
		private int map[][];
		
		public Graph(int n) {
			this.n = n;
			map = new int[n+1][n+1];
		}
		
		public void input(int i, int j, int w) {
			map[i][j] = w;
			map[j][i] = w;
		}
		
		public void dijkstra(int v) {
			int distance[] = new int[n+1]; // �ִ� �Ÿ��� ������ ����
			boolean[] visited = new boolean[n+1];
			
			// distance�� �ʱ�ȭ
			for(int i  = 1; i < n+1; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			
			// ���۳�尪 �ʱ�ȭ
			distance[v] = 0;
			visited[v] = true;
			
			// ������ distance����
			for(int i = 1; i <n+1; i++) {
				if(!visited[i] && map[v][i] != 0) {
					distance[i] = map[v][i];
				}
			}
			
			
			for(int a = 0; a < n-1; a++) {
				// ������ ��� ��尡 true�� �ɶ����� �ε�
				// ��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ����� n-1���̸� �ȴ�.
				// ������ ������ ������ ��尡 ��� true���� Ȯ���ϴ� ������ �����ص� �ȴ�.
				int min = Integer.MAX_VALUE;
				int min_index = -1;
				
				// �ּҰ� ã��
				for(int i = 1; i < n+1; i++) {
					if(!visited[i] && distance[i] != Integer.MAX_VALUE) {
						if(distance[i] < min) {
							min = distance[i];
							min_index = i;
						}
					}
				}
				
				visited[min_index] = true;
				for(int i = 1; i < n+1; i++) {
					if(!visited[i] && map[min_index][i] != 0) {
						if(distance[i] > distance[min_index] + map[min_index][i]) {
							distance[i] = distance[min_index] + map[min_index][i];
						}
					}
				}
				
			}
			
			// ����� ���
			for(int i = 1; i < n+1; i++) {
				System.out.print(distance[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(8);
        g.input(1, 2, 3);
        g.input(1, 5, 4);
        g.input(1, 4, 4);
        g.input(2, 3, 2);
        g.input(3, 4, 1);
        g.input(4, 5, 2);
        g.input(5, 6, 4);
        g.input(4, 7, 6);
        g.input(7, 6, 3);
        g.input(3, 8, 3);
        g.input(6, 8, 2);
        g.dijkstra(1);
	}
}
 