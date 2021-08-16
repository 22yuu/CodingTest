package bronze;

import java.util.*;
import java.io.*;


public class boj2839_������� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int total = Integer.parseInt(br.readLine());
		int cnt = 0; // ���������� ���� ����
		
		while(total > 0) {
			if(total % 5 == 0) {
				cnt++;
				total -= 5;
			}else {
				cnt++;
				total -= 3;
			}
			
			if(total < 0) {
				System.out.println("-1");
				return;
			}
		}

		System.out.println(cnt);
	}
}
