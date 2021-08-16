package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1157_단어공부 {
	
	// 1. 알파벳을 대소문자 상관없이 카운팅한 후 최빈값을 대문자로 출력하는 것이므로 전부 소문자 혹은 대문자로 변환 후 처리해도 상관 없을 것이다.
	// 2. 알파벳 배열(26자)과 카운트 값을 저장할 배열 생성해서 넣는다.
	// 3. 알파벳과 일치하면 인덱스 배열 카운팅!
	
	//char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s','t','u','v','w','x','y','z'};
	static int  idx[] = new int[26];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toLowerCase();
		
		for(int i = 0; i < str.length(); i++) {
			idx[str.charAt(i) - 'a']++;
		}
		
		int max = -1;
		int cnt = 0; // 최빈값 중복 체크를 위한 변수
		char ch = '?';
		
		// 최빈값 찾기
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
