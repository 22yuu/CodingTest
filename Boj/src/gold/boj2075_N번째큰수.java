package gold;

import java.util.*;
import java.io.*;

public class boj2075_N번째큰수 {
	
	public static int N;
	public static int map[][];
	public static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st;
		int idx = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.offer(num);
			}
		}
		
		while(!pq.isEmpty()) {
			answer = pq.poll();
			idx++;
			
			if(idx == N) {
				break;
			}
		}
		
		System.out.println(answer);
	}
}
