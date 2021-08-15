package bronze;


/*
 * �������κ��� �ȴ� �Ÿ��� ���� ª���� ���� ����
 * w���� �� H��
 * ���������ʹ� ���� ����
 * H x W ���� ȣ��
 * ȣ�� ������ ���� ���������� �ٷ� ��
 * �������� ���������ͱ����� �Ÿ��� ����
 * ��� ������ �� �� ������ �Ÿ��� 1
 * 
 * �� ��° �մ�(N)�� ��(H)���� ������
 * ��+1 �� ��ȣ�� �ǰ�, �������� ������ �ȴ�.
 * �� ��, �������� 0�� ��� ��������� �ش��Ѵ�.
 * 
 * ������� ������ �¾Ҵµ� 
 * N�� H�� ������ ��츦 ���� ���ؼ� Ʋ��...
 * ���� N = 6, H = 6, W = 12
 * �� ��� ��+1((N/H)+1)�� �ع����� 2�� �Ǿ� 602�� �ȴ�.
 * 601�� ���;� �ϹǷ� ���� 1�� ���� ��쿡�� 1�� �����Ѵ�.
 * 
 * */
import java.util.*;
import java.io.*;

public class boi10250_ACMȣ�� {
	
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
			
			int roomNum = (N / H == 1)? N/H : (N/H) + 1; // ���ȣ
			int floorNum = (N % H == 0)? H : N % H; // ����
			
			System.out.println(floorNum*100+roomNum);
		}
		
		br.close();
		bw.close();
	}
}