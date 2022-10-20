package silver;

import java.util.*;
import java.io.*;

public class boj1057_��ʸ�Ʈ {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int left = Integer.parseInt(inputs[1]); // �Ѽ�
		int right = Integer.parseInt(inputs[2]); // ����

		int round = 1;
		
//		if(left == 1 && right == 2) {
//			System.out.println(round);
//			return;
//		}
		
		while(true) {
			
			if(left % 2 == 0) {
				// left ¦���� ��
				left /= 2;
			} else {
				left = (left / 2) + 1; 
			}
			
			if(right % 2 == 0) {
				// left ¦���� ��
				right /= 2;
			} else {
				right = (right / 2) + 1; 
			}
			System.out.println("left : " + left + " / right : " + right);
			
			if(left == right) break;
			round++;
		}
		
		System.out.println(round);

		
	}

}
