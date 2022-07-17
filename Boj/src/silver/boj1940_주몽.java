package silver;

import java.util.*;
import java.io.*;

public class boj1940_аж╦Ы {

	private static HashMap<Integer, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hm.containsKey(num)) answer++; 
			hm.put(M - num, i);
		}
		
		System.out.println(answer);
		
	}

}
