package silver;

import java.util.*;
import java.io.*;

public class boj2564_���� {
	
	public static int W, H;	
	public static int stores;
	public static int positions[][];
	public static int pos, val;
	public static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		stores = Integer.parseInt(br.readLine());
		
		positions = new int[stores][2];
		
		// ������ ��ġ �Է� 
		for(int  i = 0; i < stores; i++) {
			st = new StringTokenizer(br.readLine());
			
			positions[i][0] = Integer.parseInt(st.nextToken()); // ����
			positions[i][1] = Integer.parseInt(st.nextToken()); // ��ġ
		}
		
		// ������ ��ġ �Է�
		st = new StringTokenizer(br.readLine());
		pos = Integer.parseInt(st.nextToken());
		val = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < stores; i++) {
			if(pos == positions[i][0]) { // ������ ����� ������ ������ ���ٸ�
				answer += Math.abs(val - positions[i][1]);
			} else {
				if(pos == 1) { // �������� ��ġ�� �����̰�
					if(positions[i][0] == 2) { // ������ ��ġ�� ����
						
						if((W/2) >= positions[i][1]) { // ������ ��ġ�� ������ ũ�⸦ �� ������ �� ���� �۰ų� ���ٸ� �ð����
							answer += positions[i][1];
							answer += H; // ���� ���� ����
							answer += val;
						} else {
							answer += W - positions[i][1]; // �ݽð����
							answer += H;
							answer += W - val;
						}
						
					
					} else if(positions[i][0] == 3) { // 
						
					} else if(positions[i][0] == 4){
						
					}
				}
			}
		}
		
		
	}
}
