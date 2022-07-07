
package math;

import java.util.*;

public class BinaryCalculator {

	private int number;
	private StringBuilder sb;

	public BinaryCalculator(int number) {
		this.number = number;
	}

	// 직접구현
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
		// 직접 구현으로 변환
		BinaryCalculator bc = new BinaryCalculator(8);
		System.out.println("이진값 : " + bc.Convert());
		
		// 내장함수 사용해서 변환
		String binaryNumber = Integer.toBinaryString(8);
		System.out.println("이진값 : " + binaryNumber);
		
		int num = Integer.parseInt(binaryNumber, 2);
		System.out.println("2진수 -> 10진수 : " + num);
	}
}
