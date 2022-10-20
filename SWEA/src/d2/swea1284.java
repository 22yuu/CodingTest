package d2;

import java.util.*;
import java.io.*;

public class swea1284 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			int P = Integer.parseInt(inputs[0]); // A�� 1L�� ���
			int Q = Integer.parseInt(inputs[1]); // B�� R���� ���� �⺻���
			int R = Integer.parseInt(inputs[2]); // B�� R���� �Ѱ輱
			int S = Integer.parseInt(inputs[3]); // B�� R���� �ʰ� �� 1L ���
			int W = Integer.parseInt(inputs[4]); // �����̰� �Ѵް� ����� ������ ��
			
			int A_value = P*W; // A�� ���
			int B_value = W <= R ? Q : Q + ((W-R)*S); // B�� ��� W < R �̸� R���� �����̹Ƿ� �⺻��� Q : �ʰ��ϸ� �⺻��� Q���� 1L�� S ����� ����
			
			if(A_value > B_value) {
				System.out.printf("#%d %d\n", test_case, B_value);
			} else {
				System.out.printf("#%d %d\n", test_case, A_value);
			}
		}
		
	}
}
