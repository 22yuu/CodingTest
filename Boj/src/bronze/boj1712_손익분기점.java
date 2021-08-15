package bronze;

import java.util.Scanner;

public class boj1712_손익분기점 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int A, B, C, break_point;
		
		A = sc.nextInt(); // 고정비용
		B = sc.nextInt(); // 가변 비용
		C = sc.nextInt(); // 노트북 가격
		
		if ((C-B) <= 0) {
			System.out.println("-1");
		} else {
			break_point = A / (C -B);
			System.out.println(break_point+1);
		}
	}
}
