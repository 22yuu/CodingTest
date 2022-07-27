package bronze;

import java.util.*;
import java.io.*;

public class boj1037_약수 {

	private static int N; // 약수의 수 저장할 변수
	private static int answer;
	private static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		
		if(N == 1) {
			nums[0] = Integer.parseInt(st.nextToken());
			answer = nums[0] * nums[0];
			System.out.println(answer);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		
		answer = nums[0] * nums[N-1];
		
		System.out.println(answer);
		return;
	}

}
