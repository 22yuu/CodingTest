package DP;

import java.util.*;
import java.io.*;

public class DP_ȿ������ȭ�󱸼� {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// n���� ȭ�� ���� ���� �Է�
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// �ռ� ���� ����� �����ϱ� ���� DP ���̺� �ʱ�ȭ
		int[] d = new int[m+1];
		Arrays.fill(d, 10001);
		
		// DP ����
		d[0] = 0;
		for(int i =0; i< n; i++) {
			for(int j = arr[i]; j <= m; j++) {
				if(d[j - arr[i]] != 10001) {
					d[j] = Math.min(d[j], d[j - arr[i]] + 1);
				}
			}
		}
		
		// ���� ��� ���
        if (d[m] == 10001) { // ���������� M���� ����� ����� ���� ���
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
        
	}
}
