package d2;

import java.io.*;
import java.util.*;

public class swea1970 {
	  public static int[] K_MONEY = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	    
		public static void main(String args[]) throws Exception
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb;
			
			
//			System.out.println(30000 / 10000);
			int T = Integer.parseInt(br.readLine());
			
			
			
			for(int test_case = 1; test_case <= T; test_case++) {
				String answer = "";
				sb = new StringBuilder();
				
				int money = Integer.parseInt(br.readLine());
				
				for(int i = 0; i < K_MONEY.length; i++) {
					if(money < 0) break;
					
					int changes = money / K_MONEY[i];
		
					sb.append(changes).append(" ");
					if(changes != 0) money -= changes * K_MONEY[i];
					
				}
				
				answer = sb.toString();
				
				System.out.printf("#%d\n%s\n", test_case, answer);
			}
	}
}
