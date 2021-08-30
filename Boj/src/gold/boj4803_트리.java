package gold;

import java.util.*;
import java.io.*;

public class boj4803_Æ®¸® {

	public static int getParent(int parent[], int x) {
		if(parent[x] == x)
			return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	
	
	public static void makeUnion(int parent[], int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a == b) {
			parent[b] = a;
			parent[a] = 0;
		} else if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int parent[];
		int testcase = 1;
		HashSet<Integer> hs;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) break;
			
			parent = new int[n+1];
			
			for(int i = 1; i <= n; i++) parent[i] = i;
			
			hs = new HashSet<>();
			
			for(int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				makeUnion(parent, a, b);
				
			}
			
			
			for(int i = 1; i <= n; i++) {
				int temp = getParent(parent, i);
				if(temp > 0) {
					hs.add(temp);
				}
			}
			
			if(hs.isEmpty()) System.out.println("Case " + testcase + ": No trees.");
			else if(hs.size() == 1) System.out.println("Case " + testcase + ": There is one tree.");
			else System.out.println("Case "+ testcase + ": A forest of " + hs.size() + " trees.");
				
			testcase++;
			
			
			
		}
		
	}
}
 