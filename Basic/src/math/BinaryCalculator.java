
package math;

import java.util.*;

public class BinaryCalculator {

	private int number;
	private StringBuilder sb;

	public BinaryCalculator(int number) {
		this.number = number;
	}

	// ��������
	public String Convert() {
		sb = new StringBuilder();
		
		while(number >= 1) {
			if(number % 2 == 0) {
				sb.append("0");
			} else {
				sb.append("1");
			}
			number = number/2;
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		// ���� �������� ��ȯ
		BinaryCalculator bc = new BinaryCalculator(8);
		System.out.println("������ : " + bc.Convert());
		
		// �����Լ� ����ؼ� ��ȯ
		String binaryNumber = Integer.toBinaryString(8);
		System.out.println("������ : " + binaryNumber);
		
		int num = Integer.parseInt(binaryNumber, 2);
		System.out.println("2���� -> 10���� : " + num);
	}
}
