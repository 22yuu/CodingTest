package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2908_»ó¼ö {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<String> list = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			
			String str = st.nextToken();
			
			StringBuilder sb = new StringBuilder(str);
			String reverse = sb.reverse().toString();
			list.add(reverse);
		}
		
		String[] strArray = list.toArray(new String[list.size()]);
		
		for(int i = 0; i < strArray[0].length(); i++) {
			if(strArray[0].charAt(i) > strArray[1].charAt(i)) {
				System.out.println(strArray[0]);
				return;
			} else if(strArray[0].charAt(i) == strArray[1].charAt(i)) {
				continue;
			} else {
				System.out.println(strArray[1]);
				return;
			}
		}
	}
}
