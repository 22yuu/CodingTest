package sort;

import java.util.*;
import java.io.*;

public class 성적이낮은순서로학생출력하기 {
	
	static class Student {
		String name = "";
		int score = 0;
		
		public Student(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		List<Student> list = new ArrayList<>();
		
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			list.add(new Student(name, score));
		}
		
		
		// 정렬 전
		System.out.println("정렬 전");
		for(Student student : list) System.out.print(student.name + " ");
		
		// 정렬 수행 - 오름차순
		System.out.println();
		Collections.sort(list, new StudentComparator());
		
		// 정렬 후
		System.out.println("정렬 후" );
		for(Student student : list) System.out.print(student.name + " ");
		
		
	}
	
	static class StudentComparator implements Comparator<Student> {
		
		@Override
		public int compare(Student a, Student b) {
			if(a.score > b.score) return 1;
			if(a.score < b.score) return -1;
			return 0;
		}
	}
}
