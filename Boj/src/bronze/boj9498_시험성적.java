package bronze;

import java.util.*;
import java.io.*;

public class boj9498_시험성적 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		if(num >= 90) {
			System.out.println("A");
		} else if(num >= 80){
			System.out.println("B");
		} else if(num >= 70) {
			System.out.println("C");
		} else if(num >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}
