package silver;

import java.util.*;
import java.io.*;

public class boj1991_Ʈ����ȸ {

	static int N;

	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
		}
	}
	
	
	static class Tree {
		public Node root;
		
		public void createNode(char data, char left, char right) {
			if(root == null) {
				root = new Node(data);
				root.left = left != '.'? new Node(left) : null;
				root.right = right != '.'? new Node(right) : null;
			} else {
				searchNode(root, data, left, right);
			}
		}
		
		public void searchNode(Node node, char data, char left, char right) {
			if(node == null) {
				return;
			} else if(node.data == data) {
				 node.left = left != '.'? new Node(left) : null;
				 node.right = right != '.' ? new Node(right) : null;
			} else {
				searchNode(node.left, data, left, right);	// ������ ��� Ž��
				searchNode(node.right, data, left, right);	// ���� ��� Ž��
			}
		}
		
		// ������ȸ Pre-order : Root -> Left -> Right
		public void preOrder(Node node) {
			if(node != null) {
				System.out.print(node.data);
				if(node.left != null) preOrder(node.left);
				if(node.right != null) preOrder(node.right);
			}
		}
		
		// ������ȸ In-order : :Left -> Root -> Right
		public void inOrder(Node node) {
			if(node != null) {
				if(node.left != null) inOrder(node.left);
				System.out.print(node.data);
				if(node.right != null) inOrder(node.right);
			}
		}
		
		
		// ������ȸ Post-order : Left -> Right -> Root
		public void postOrder(Node node) {
			if(node != null) {
				if(node.left != null) postOrder(node.left);
				if(node.right != null) postOrder(node.right);
				System.out.print(node.data);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			System.out.println(data + " " + left + " " + right);
			tree.createNode(data, left, right);
		}
		
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		
		br.close();
	}
}
