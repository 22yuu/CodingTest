package silver;

import java.util.*;
import java.io.*;

public class boj10989_수정렬하기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
					
		}
		
		Arrays.sort(nums);
		
		for(int num : nums) {
			sb.append(num).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
