package DP;

import java.util.*;
import java.io.*;

public class DP_�ٴڰ��� {

	public static int d[] = new int[1001];
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		d[1] = 1;
		d[2] = 3;
		
		for(int i = 3; i <=n; i++) {
			d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
		}
		
		System.out.println(d[n]);
	}
}
