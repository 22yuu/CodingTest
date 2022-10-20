package gold;

import java.util.*;
import java.io.*;

public class boj2437_Àú¿ï {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int maxNum = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			maxNum += nums[i];
		}
		
		boolean[] weights = new boolean[maxNum+1];
		
		for(int i = 0; i < N; i++) {
			weights[nums[i]] = true;
			
			for(int j = i+1;)
		}
		
		
		

	}

}
