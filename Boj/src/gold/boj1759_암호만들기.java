package gold;

import java.util.*;
import java.io.*;

public class boj1759_암호만들기 {

	private static int L, C;
	private static char[] strs;
	private static char[] sel;
	private static boolean[] visited;
	
	public static void func(int start, int idx) {
		
		if(idx == L) {
			Arrays.sort(sel);
			String str = new String(sel);
			System.out.println(str);
			return;
		}
		
		
		for(int i = 0; i < C; i++) {
//			if(visited[i]) continue;
//			visited[i] = true;
//			sel[idx] = strs[i];
//			func(i, idx+1);
//			visited[i] = false;
			
			sel[idx] = strs[i];
			func(i, idx+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		strs = new char[C];
		sel  = new char[L];
		visited = new boolean[C];
		
		for(int i = 0; i < C; i++) strs[i] = st.nextToken().charAt(0);
		
		func(0, 0);
		
	}
}
