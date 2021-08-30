package silver;

import java.util.*;
import java.io.*;

public class boj5639_이진검색트리 {

	
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int data) {
			this.value  = data;
			this.left 	= null;
			this.right  = null;
		}
	}
	
	public static class Tree {
		Node head;
		
		public void insertNode(int data) {
			// Node가 하나도 없을 때
			if(this.head == null) {
				this.head = new Node(data);
			} else {
				// Node가 하나 이상 있을 경우
				Node findNode = this.head;
				
				while(true) {
					if(data < findNode.value) {
						if(findNode.left != null) {
							findNode = findNode.left;
						} else {
							findNode.left = new Node(data);
							break;
						}
					} else {
						if(findNode.right != null ) {
							findNode = findNode.right;
						} else {
							findNode.right = new Node(data);
							break;
						}
					}
				} // while end
			}
			return;
		} // insert func end
		
		
		public void postOrder(Node node) {
			if(node != null) {
				if(node.left != null) postOrder(node.left);
				if(node.right != null) postOrder(node.right);
				System.out.println(node.value);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {

		Tree myTree = new Tree();
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> list = new ArrayList<>();
		
//		while(sc.hasNext()) {
//			int num = sc.nextInt();
//			list.add(num);
//			System.out.println(num);
//		}
		
		while(true) {
			String input = br.readLine();
			
			if(input == null || input.equals("")) break;
			
			myTree.insertNode(Integer.parseInt(input));
		}
		//System.out.println("input and insert node done...");

		myTree.postOrder(myTree.head);
	}
}
