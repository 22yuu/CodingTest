package silver;

import java.util.*;
import java.io.*;

public class boj2776_¾Ï±â¿Õ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		boolean[] nums;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			nums = new boolean[1000010];
			sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				nums[idx] = true;
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				if(nums[idx]) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			System.out.println(sb.toString());
		}
	}

}
