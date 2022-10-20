package silver;

import java.util.*;
import java.io.*;

public class boj1931_회의실배정2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];

		// 배열 입력
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
//		for(int[] n : arr) System.out.println(n[0] + " " + n[1]);
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			int count = 1;
			int end = arr[i][1];
			for(int j = i + 1; j < N; j++) {
				if(end < arr[j][0]) {
					end = arr[j][1];
					count++; 
				}
				
			}
			
			max = Math.max(max, count);
		}
		
		System.out.println(max);
		
	}

}
