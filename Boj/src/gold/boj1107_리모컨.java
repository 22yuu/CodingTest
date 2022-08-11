package gold;

import java.io.*;
import java.util.*;

public class boj1107_¸®¸ðÄÁ {
	
	private static int M;
	private static int Min = Integer.MAX_VALUE;
	private static boolean buttons[] = new boolean[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int targetNumber = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			System.out.println((int)Math.log10(targetNumber) + 1);
			return;
		}
		
		String brokens[] = br.readLine().split(" ");
		
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(brokens[i]);
			buttons[num] = true;
		}
		
		int result = Math.abs(targetNumber - 100);
		for(int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean flag = false;
			for(int j = 0; j < len; j++) {
				if(buttons[str.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int value = Math.abs(targetNumber - i) + len;				
				Min = Math.min(value, Min);
			}
			
		}
		
		System.out.println(Min);
	}

}
