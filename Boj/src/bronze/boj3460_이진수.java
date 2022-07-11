package bronze;

import java.util.*;
import java.io.*;

public class boj3460_ÀÌÁø¼ö {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			String binaryNum = Integer.toBinaryString(num);
			int n = binaryNum.length();
			sb = new StringBuilder();
			String reverse = sb.append(binaryNum).reverse().toString();
			sb.setLength(0);
			
//			System.out.println(reverse);
			
			for(int i = 0; i < n; i++) {
				if(reverse.charAt(i) == '1') {
					sb.append((i)+" ");
				}
			}
			
			System.out.println(sb.toString());
		}

	}

}
