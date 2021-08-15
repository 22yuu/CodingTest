package bronze;

import java.util.Scanner;

public class boj2292_¹úÁı {
	static int n;
	static int block;
	public static void func(int block, int sum, int num) {
		
		sum += 6*block;
		if(sum < num) {
			func(block+1, sum, num);
		} else {
			System.out.println(block+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		block = 1;
		
		if(n <=1) {
			System.out.println(block);
		} else {
			func(block, block, n);	
		}
		
	}
}
