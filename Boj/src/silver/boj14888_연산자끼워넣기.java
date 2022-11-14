package silver;

import java.util.*;
import java.io.*;

public class boj14888_¿¬»êÀÚ³¢¿ö³Ö±â {
	
	private static int N;
	private static int[] nums;
	private static int[] operator = new int[4]; // µ¡¼À, »¬¼À, °ö¼À, ³ª´°¼À
	private static int Max = Integer.MIN_VALUE;
	private static int Min = Integer.MAX_VALUE;
	
	
	public static void dfs(int result, int depth) {
		
		if(depth == N) {
			Max = Math.max(Max, result);
			Min = Math.min(Min, result);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			
			if(operator[i] > 0) {
				operator[i]--;
				
				switch(i) {
					case 0: dfs(result + nums[depth], depth+1); break;
					case 1: dfs(result - nums[depth], depth+1); break;
					case 2: dfs(result * nums[depth], depth+1); break;
					case 3: dfs(result / nums[depth], depth+1); break;
				}
				
				operator[i]++;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine()); 
		
		for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());
		
		dfs(nums[0], 1);
		
		System.out.println(Max);
		System.out.println(Min);
		
		
		
		
		
	}
}
