package D1;

import java.util.*;
import java.io.*;

public class SW2043_�����Ǻ�й�ȣ {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int answer = Math.abs(num1 - num2) + 1;
		
		System.out.println(answer);
	}
}
