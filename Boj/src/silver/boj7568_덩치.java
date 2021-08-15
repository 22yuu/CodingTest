package silver;

import java.util.*;
import java.io.*;

public class boj7568_덩치 {

	/*
	 * 자신보다 몸무게, 키 모두 큰 사람이 덩치가 큰 사람
	 * 따라서 자신 보다 몸무게, 키 모두 큰 사람의 수 + 1이 자신의 등수가 된다.
	 * */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 사람 수
		
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
				
				if(persons[i].weight < persons[j].weight) { // 자신보다 몸무게가 큰가?
					
					if(persons[i].height < persons[j].height) {// 자신 보다 키가 큰가?
						// 크다면 자신보다 덩치가 큰 사람이다.
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
