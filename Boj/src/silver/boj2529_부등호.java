package silver;

import java.util.*;
import java.io.*;

public class boj2529_�ε�ȣ {

	private static int N, K; // �ε�ȣ�� ������ ���� ����
	private static String[] orders; // �ε�ȣ ��ɾ���� ������ ����
	private static int sel[];
	private static boolean[] visited;
	private static List<String> list;
	
	public static void recu(int idx) {
		StringBuilder sb = new StringBuilder();
		
		if(idx == K) {
			int index = 0;
			
			for(int i = 0; i < N; i++) {
				
				if(orders[i].matches(">")) {
					if(sel[index] > sel[index+1]) {
						index++;
						continue;
					}
					else return;
				} else {
					// <
					if(sel[index] < sel[index+1]) {
						index++;
						continue;
					}
					else return;
				}
			} // end for
			
			// for���� ������ �����ߴ� -> �ε�ȣ�� �˸��� ������
			
			for(int i : sel) sb.append(i);
			
			list.add(sb.toString());
			
			
			
			return;
		} // end if
		
		for(int i = 0; i < 10; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sel[idx] = i;
				recu(idx+1);
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = N + 1;
		orders = br.readLine().split(" ");
		
		sel = new int[K];
		visited = new boolean[10];
		list = new ArrayList<>();
		
		recu(0);
		
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}
}
