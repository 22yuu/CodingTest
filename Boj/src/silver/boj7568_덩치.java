package silver;

import java.util.*;
import java.io.*;

public class boj7568_��ġ {

	/*
	 * �ڽź��� ������, Ű ��� ū ����� ��ġ�� ū ���
	 * ���� �ڽ� ���� ������, Ű ��� ū ����� �� + 1�� �ڽ��� ����� �ȴ�.
	 * */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // ��� ��
		
		Person[] persons = new Person[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			persons[i] = new Person(height, weight);
		}
		
		
		for(int i = 0; i <N; i++) {
			int cnt = 0;
			for(int j = 0; j< N; j++) {
				if(j == i) continue;
				
				if(persons[i].weight < persons[j].weight) { // �ڽź��� �����԰� ū��?
					
					if(persons[i].height < persons[j].height) {// �ڽ� ���� Ű�� ū��?
						// ũ�ٸ� �ڽź��� ��ġ�� ū ����̴�.
						cnt++;
					}
				}
			}
			persons[i].rank = cnt+1;
		}
		
		for(Person person: persons) {
			System.out.print(person.rank + " ");
		}
	}
	
	public static class Person {
		int height, weight, rank;
		
		public Person(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
	}
}
