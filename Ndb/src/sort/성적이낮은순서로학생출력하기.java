package sort;

import java.util.*;
import java.io.*;

public class �����̳����������л�����ϱ� {
	
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
		
		
		// ���� ��
		System.out.println("���� ��");
		for(Student student : list) System.out.print(student.name + " ");
		
		// ���� ���� - ��������
		System.out.println();
		Collections.sort(list, new StudentComparator());
		
		// ���� ��
		System.out.println("���� ��" );
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
