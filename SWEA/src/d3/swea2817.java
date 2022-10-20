package d3;

import java.util.*;
import java.io.*;

public class swea2817 {
	
	private static int N, K;
	private static int cnt;
	private static int[] seq;
	
	public static void func(int cur, int tot) {
		
		if(cur == N) {
			if(tot == K) cnt++;
			return;
		}
		
		func(cur + 1, tot);
		func(cur + 1, tot + seq[cur]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String temp[] = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]);
			K = Integer.parseInt(temp[1]);
			cnt = 0;
			temp = br.readLine().split(" ");
			seq = new int[temp.length];
			
			for(int i = 0; i < temp.length; i++) {
				seq[i] = Integer.parseInt(temp[i]);
			}
			
			func(0, 0);
			
			System.out.printf("#%d %d\n", test_case, cnt);
			
		}
	}
}
