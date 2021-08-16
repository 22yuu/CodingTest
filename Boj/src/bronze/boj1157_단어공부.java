package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1157_�ܾ���� {
	
	// 1. ���ĺ��� ��ҹ��� ������� ī������ �� �ֺ��� �빮�ڷ� ����ϴ� ���̹Ƿ� ���� �ҹ��� Ȥ�� �빮�ڷ� ��ȯ �� ó���ص� ��� ���� ���̴�.
	// 2. ���ĺ� �迭(26��)�� ī��Ʈ ���� ������ �迭 �����ؼ� �ִ´�.
	// 3. ���ĺ��� ��ġ�ϸ� �ε��� �迭 ī����!
	
	//char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s','t','u','v','w','x','y','z'};
	static int  idx[] = new int[26];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toLowerCase();
		
		for(int i = 0; i < str.length(); i++) {
			idx[str.charAt(i) - 'a']++;
		}
		
		int max = -1;
		int cnt = 0; // �ֺ� �ߺ� üũ�� ���� ����
		char ch = '?';
		
		// �ֺ� ã��
		for(int i = 0; i < idx.length; i++) {
			if(idx[i] == 0) continue;
			if(idx[i] > max) {
				max = idx[i];
				ch = (char) (i + 65);
			}
		}
		
		for(int i = 0; i < idx.length; i++) {
			if(idx[i] == max) cnt++;
		}
		
		if(cnt >= 2) System.out.println("?");
		else System.out.println(ch);
		
	}
}
