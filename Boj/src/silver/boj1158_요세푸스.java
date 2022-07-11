package silver;

import java.util.*;
import java.io.*;

public class boj1158_¿ä¼¼Çª½º {

	private static int N, K;
	private static List<Integer> que;
	private static List<Integer> answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		que = new ArrayList<>();
		answer = new ArrayList<>();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) que.add(i);
		
		int idx = K - 1;
		while(!que.isEmpty()) {
			if(que.size() < K) {
				answer.add(que.remove(0));
			}

			if(idx >= que.size()) {
				if(K == que.size()) idx = K - 1;
			} else {
				idx += K - 1;
			}
			
			answer.add(que.remove(idx));
			
		}
		
		
		
	}

}
