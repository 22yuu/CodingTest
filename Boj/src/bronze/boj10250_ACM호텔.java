package bronze;

import java.util.*;
import java.io.*;

public class boj10250_ACMȣ�� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // testcase
		
		for(int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int roomNum = (N % H == 0)? N/H : (N/H) + 1; // ���ȣ 1�� ��� 1���̱� ������ N/H
			int floorNum = (N % H == 0)? H : N % H; // ���� 0:�����
			
			System.out.println(floorNum*100+roomNum);
		}
		br.close();
		bw.close();
	}
}
