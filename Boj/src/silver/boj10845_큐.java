package silver;

import java.util.*;
import java.io.*;

public class boj10845_큐 {
	
	
	private static int N;
	
	public static class MyQueue {
		private List<Integer> list;
		
		public MyQueue() {
			this.list = new ArrayList<>();
		}
		
		public void push(int data) {
			list.add(data);
		}
		
		public int front() {
			if(list.size() == 0) return -1;
			return list.get(0);
		}
		
		public int back() {
			if(list.size() == 0) return -1;
			return list.get(list.size() - 1);
		}
		
		public int empty() {
			return list.size() > 0 ? 0 : 1;
		}
		
		public int pop() {
			if(list.size() == 0) return -1;
			return list.remove(0);
		}
		
		public int size() {
			return list.size();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MyQueue que = new MyQueue();
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");
			
			if(cmd.length > 1) {
				// push 일경우 명령어 2 음절로 이루어짐
				que.push(Integer.parseInt(cmd[1]));
			} else {
				if(cmd[0].equals("front")) {
					sb.append(que.front());
				} else if(cmd[0].equals("pop")) {
					sb.append(que.pop());
				} else if(cmd[0].equals("size")) {
					sb.append(que.size());
				} else if(cmd[0].equals("empty")) {
					sb.append(que.empty());
				} else if(cmd[0].equals("back")) {
					sb.append(que.back());
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}
}
