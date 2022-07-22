package silver;

import java.util.*;
import java.io.*;

public class boj10974_모든순열 {

	private static int N;
	private static int[] sel;
	private static boolean[] visited;
	
	public static void permutation(int idx) {
		
		if(idx == N) {
			for(int num : sel) System.out.print(num + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {				
				visited[i] = true;
				sel[idx] = i + 1;
				permutation(idx+1);
				visited[i] = false;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sel = new int[N];
		visited = new boolean[N];
		
		permutation(0);
	}

}
