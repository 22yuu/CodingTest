package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class boj2588_���� {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		int units = A * (B % 10); 				// ���� �ڸ�
		int tens = A * ((B % 100) / 10);		// ���� �ڸ�
		int hundreds = A * ((B % 1000) / 100);  // ���� �ڸ�
		System.out.println(units);
		System.out.println(tens);
		System.out.println(hundreds);
		System.out.println(units + (tens * 10) + (hundreds * 100));
	}
}
