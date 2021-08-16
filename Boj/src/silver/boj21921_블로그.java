package silver;

import java.util.*;
import java.io.*;

public class boj21921_ºí·Î±× {

	public static int N, X;
	public static int nums[];
	public static long maxArr[];
	
//	public static int visitors(int idx) {
//		int sum = 0;
//		
//		if(idx + X > N) return 0;
//		
//		for(int i = idx; i < idx + X; i++) {
//			sum += nums[i];
//		}
//		
//		return sum;
//	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		maxArr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		long cnt = 0, max = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = (X-1); i < N; i++) {
			for(int j = i - (X-1); j <= i; j++) {
				maxArr[i] += nums[j];
			}
			
			if(maxArr[i] > max) {
				max = maxArr[i];
				cnt = 1;
			}else if(max == maxArr[i]) {
				cnt++;
			}
			
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
