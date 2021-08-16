package math;

import java.util.*;

public class 최대공약수와최소공배수 {
	
	public static int gcd(int  a, int b) {
		if(a % b == 0) return b;
		return gcd(b, a%b);
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a,b);
	}
	
	public static void solution(int n, int m) {
		List<Integer> list = new ArrayList<>();
		
		list.add(gcd(n,m));
		list.add(lcm(n,m));
		
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		solution(2, 5);
	}
}
