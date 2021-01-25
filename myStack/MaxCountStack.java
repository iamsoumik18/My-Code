package myStack;

import myStack.MyStack.Node;

public class MaxCountStack {
	Node head;
	int max = Integer.MIN_VALUE;
	
	public void push(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			if(head.data>max) {
				max = head.data;
			}
			return;
		}
		
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = node;
		if(node.data>max) {
			max = node.data;
		}
		
	}
	
	public int pop() {
		if(head.next==null) {
			int x = head.data;
			head = null;
			max = Integer.MIN_VALUE;
			return x;
		}
		Node temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		int x = temp.next.data;
		temp.next = null;
		if(x==max) {
			max = Integer.MIN_VALUE;
			Node temp1 = head;
			while(temp1!=null) {
				if(temp1.data>max) {
					max = temp1.data;
				}
				temp1=temp1.next;
			}
		}
		return x;
		
	}
	
	public int peek() {
		
		if(head.next==null) {
			return head.data;
		}
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		return temp.data;
		
	}
	
	public int curMax() {
		return max;
	}
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			next = null;
		}
	}


}
