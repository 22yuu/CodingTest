package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2562_최댓값 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int[] nums = new int[9];
		int idx = 0; // 자리수
				
		for(int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < 9; i++) {
			if(max < nums[i]) {
				max = nums[i];
				idx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
		
		
	}
}
