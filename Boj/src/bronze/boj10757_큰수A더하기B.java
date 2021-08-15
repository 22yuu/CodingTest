package bronze;

import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class boj10757_큰수A더하기B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		BigInteger n1 = sc.nextBigInteger();
		BigInteger n2 = sc.nextBigInteger();
		
		System.out.println(n1.add(n2));
	}
}
