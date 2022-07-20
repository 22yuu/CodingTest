package silver;

import java.util.*;
import java.io.*;

public class boj11004_K¹øÂ°¼ö {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String[] arr = br.readLine().split(" ");
		
		int[] nums = new int[N];
		
		for(int i = 0 ; i < N; i++) nums[i] = Integer.parseInt(arr[i]);
		
		
		Arrays.sort(nums);
		
		sb.append(nums[K-1]);
		System.out.println(sb.toString());
		

	}

}
