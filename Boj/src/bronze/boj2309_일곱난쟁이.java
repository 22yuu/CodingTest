package bronze;

import java.io.*;
import java.util.*;

public class boj2309_일곱난쟁이 {
	
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] visited;
	
	public static int solution(int n1, int n2) {
		int ret = 0;
		for(int i = 0; i < list.size(); i++) {
			if(i == n1 || i == n2)
				continue;
			ret += list.get(i);
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++) list.add(sc.nextInt());
		
		// 9명 중 2명을 제외하는 모든 방법들을 탐색하며, 나머지 7명 키의 합이 합이 100이 되는 때를 찾는다.
		int n1 = 0, n2 = 0;
		
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if( 100 == solution(i, j)) {
					n1 = i;
					n2 = j;
				}
			}
		}
		
		list.remove(n2);
		list.remove(n1);
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}
