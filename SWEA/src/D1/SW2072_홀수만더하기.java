package D1;

import java.util.*;
import java.io.*;

public class SW2072_Ȧ�������ϱ� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			
			int sum  = 0;
			for(int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 != 0) sum += num;
			}
			
			System.out.println("#"+testcase+" "+sum);
		}
	}
}