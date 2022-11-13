package bronze;

import java.util.*;
import java.io.*;

public class boj13458_시험감독 {
	
	private static int N, B, C;
	private static int[] people;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		people = new int[N];
		
		long mainCount = 0;
		long subCount = 0;
		
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			
			int n = people[i];
			
			n = people[i] - B;
			mainCount += 1;
			
			if(n > 0 ) {
				int value = n / C;
				int rest = n % C;
				
				if(value == 0) subCount += 1;
				else {
					subCount += rest == 0 ? value : value + 1;
				}
			}
			
		}
		
		long answer = mainCount + subCount;
		
		System.out.println(answer);
		

	}

}
