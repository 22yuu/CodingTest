package silver;


import java.util.*;
import java.io.*;

/*
 * - DFS 이용
 * - 부모노드에 해당하는 노드 값을 출력하기 위해 배열을 추가로 선언
 */

public class boj11725_트리의부모찾기 {

	static int N;
	static ArrayList<Integer> list[];
	static int parents[];
	static boolean[] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		parents = new int[N+1];
		check = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
			
		}
		
		for(int i = 1; i <= N; i++) {
			if(!check[i]) {
				dfs(i);
			}
		}
		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
	}
	
	private static void dfs(int idx) {
		if(check[idx]) {
			return;
		}
		check[idx] = true;
		for(int num : list[idx]) {
			if(!check[num]) {
				parents[num] = idx;
				dfs(num);
			}
		}
	}
}
