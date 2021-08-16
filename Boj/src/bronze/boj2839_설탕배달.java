package bronze;

import java.util.*;
import java.io.*;


public class boj2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int total = Integer.parseInt(br.readLine());
		int cnt = 0; // 가져가야할 봉투 개수
		
		while(total > 0) {
			if(total % 5 == 0) {
				cnt++;
				total -= 5;
			}else {
				cnt++;
				total -= 3;
			}
			
			if(total < 0) {
				System.out.println("-1");
				return;
			}
		}

		System.out.println(cnt);
	}
}
