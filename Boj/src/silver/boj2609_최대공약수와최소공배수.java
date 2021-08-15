package silver;

import java.util.*;
import java.io.*;

public class boj2609_최대공약수와최소공배수 {
	
	public static int gcd(int a, int b) {
		if(a % b == 0) return b;
		return gcd(b, a%b);
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a,b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		System.out.println(gcd(n,m));
		System.out.println(lcm(n,m));
	}
}
