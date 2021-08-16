package silver;

import java.util.*;
import java.io.*;

public class boj11650_좌표정렬하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Coord> list = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Coord(x,y));
		}
		
		Collections.sort(list, new Comparator<Coord>() {
			
			public int compare(Coord a, Coord b) {
				if(a.x < b.x) return 1;
				if(a.x > b.x) return -1;
				return 0;
			}
		});
		
//		Collections.sort(list, new Comparator<Coord>() {
//			
//			public int compare(Coord a, Coord b) {
//				if(a.y > b.y) return 1;
//				if(a.y < b.y) return -1;
//				return 0;
//			}
//		});
		for(Coord coord : list) System.out.println(coord.x + " " + coord.y);
//		for(int i = (list.size()-1); i >= 0; i--) {
//			sb.append(list.get(i).x + " " + list.get(i).y).append("\n");
//		}
//		System.out.println(sb);
	}
	
	public static class Coord {
		int x, y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
