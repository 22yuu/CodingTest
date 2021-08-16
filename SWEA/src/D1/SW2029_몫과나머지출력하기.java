package D1;

import java.util.*;
import java.io.*;

public class SW2029_몫과나머지출력하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println("#" + testcase + " " + (a/b) + " " + (a%b));
		}
	}
}
