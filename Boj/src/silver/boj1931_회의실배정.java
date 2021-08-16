package silver;

import java.util.*;
import java.io.*;

public class boj1931_회의실배정 {
	
	public static int N;
	public static int max;
	
	public static class Meeting{
		long start, end;
		
		public Meeting(long start, long end) {
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		
		Meeting[] mt = new Meeting[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long start = Integer.parseInt(st.nextToken());
			long end = Integer.parseInt(st.nextToken());
			mt[i] = new Meeting(start, end);
		}
		
		Arrays.sort(mt, new Comparator<Meeting>() {
			
			@Override
			public int compare(Meeting o1, Meeting o2) {
				if(o1.end == o2.end) {
					return Long.compare(o1.start, o2.start);
				}
				return Long.compare(o1.end, o2.end);
			}
		});

		int currentIndex = 0;
		int count = 1;
		for(int i = 1 ; i < N; i++) {
			if(mt[currentIndex].end <= mt[i].start) {
				currentIndex = i;
				count++;
			}
			if(count > max) max = count;
		}
		System.out.println(max);
	}
}
