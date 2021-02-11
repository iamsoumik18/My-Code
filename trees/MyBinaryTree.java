package trees;

import java.util.*;

public class MyBinaryTree {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Node root = createTree();
		System.out.print("In-order : ");
		inOrder(root);
		System.out.println();
		System.out.print("Pre-order : ");
		preOrder(root);
		System.out.println();
		System.out.print("Post-order : ");
		postOrder(root);
		System.out.println();
	}
	

	public static Node createTree() {
		Node root = null;
		System.out.print("Enter data: ");
		int data = sc.nextInt();
		if(data==-1) {
			return null;
		}
		root = new Node(data);
		System.out.println("Enter for left "+data);
		root.left = createTree();
		System.out.println("Enter for right "+data);
		root.right = createTree();
		return root;
	}
	
	static void inOrder(Node root) {
		//LNR
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	static void preOrder(Node root) {
		//NLR
		if(root == null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	static void postOrder(Node root) {
		//LRN
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	
}

class Node {
	
	Node left, right;
	int data;
	Node(int data){
		this.data = data;
	}
}
