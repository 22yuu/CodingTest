package gold;

import java.util.*;
import java.io.*;

public class boj1781_ÄÅ¶ó¸é {

	public static int N;
	public static int inputs[][];
	public static int answer = 0;
	
	public static class Question {
		int deadLine, noodles;
		
		public Question(int a, int b) {
			this.deadLine = a;
			this.noodles = b;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		N = Integer.parseInt(br.readLine());
		inputs = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			inputs[i][0] = Integer.parseInt(st.nextToken());
			inputs[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputs, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			};
		});
		
		for(int i = 0; i < N; i++) {
			int a = inputs[i][0];
			int b = inputs[i][1];
			pq.offer(b);
			
			if(a < pq.size()) {
				pq.poll();
			}
		}
		
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
	}
}
