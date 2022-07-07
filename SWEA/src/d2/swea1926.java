package d2;

import java.util.*;

public class swea1926 {
	// 1926. 간단한 369 게임
	
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String num = Integer.toString(test_case);
            
			if(num.contains("3") || num.contains("6") || num.contains("9") ) {
				num = num.replace("3", "-");
				num = num.replace("6", "-");
				num = num.replace("9", "-");
				
				num = num.replace("0", "");
				num = num.replace("1", "");
				num = num.replace("2", "");
				num = num.replace("4", "");
				num = num.replace("5", "");
				num = num.replace("7", "");
				num = num.replace("8", "");
			}
			
            if(test_case >= T) {
            	sb.append(num);
            } else {
            	sb.append(num + " ");
            }
		}
		
		System.out.println(sb.toString());
	}
}
