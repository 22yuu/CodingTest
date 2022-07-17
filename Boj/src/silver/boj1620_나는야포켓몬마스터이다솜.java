package silver;

import java.util.*;
import java.io.*;

public class boj1620_나는야포켓몬마스터이다솜 {

	private static HashMap<String, String> hm = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			String PoketMonName = br.readLine();
			hm.put(PoketMonName, Integer.toString(i));
			hm.put(Integer.toString(i), PoketMonName);
		}
		
		for(int i = 0; i < M; i++) {
			System.out.println(hm.get(br.readLine()));
		}
	}
}
