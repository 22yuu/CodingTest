package bronze;

import java.util.*;
import java.io.*;

public class boj2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int apt[][];
		for(int testcase = 1; testcase <= T; testcase++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			apt = new int[k+1][n];
			
			for(int i = 0; i <= k; i++) { // 층
				int people = 1;
				apt[i][0] = people;
				for(int j = 1; j < n; j++) { // 호
					
					if( i == 0) {
						apt[i][j] = ++people;
					} else {
						apt[i][j] = apt[i-1][j] + people;
						people = apt[i][j];
					}
				}
			}
//			for(int i = 0 ; i <= k; i++) {
//				for(int j = 0; j <n;j++) {
//					System.out.print(apt[i][j]+" ");
//				}
//				System.out.println();
//			}
			bw.write(apt[k][n-1]+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
}
