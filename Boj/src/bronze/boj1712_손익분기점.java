package bronze;

import java.util.Scanner;

public class boj1712_���ͺб��� {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int A, B, C, break_point;
		
		A = sc.nextInt(); // �������
		B = sc.nextInt(); // ���� ���
		C = sc.nextInt(); // ��Ʈ�� ����
		
		if ((C-B) <= 0) {
			System.out.println("-1");
		} else {
			break_point = A / (C -B);
			System.out.println(break_point+1);
		}
	}
}
