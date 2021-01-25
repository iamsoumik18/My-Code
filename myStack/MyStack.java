package myStack;

public class MyStack<E> {
	
	Node<E> head;
	
	public void push(E data) {
		Node<E> node = new Node<>(data);
		if(head == null) {
			head = node;
			return;
		}
		
		Node<E> temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = node;
		
	}
	
	public E pop() {
		if(head.next==null) {
			E x = head.data;
			head = null;
			return x;
		}
		Node<E> temp = head;
		while(temp.next.next!=null) {
			temp = temp.next;
		}
		E x = temp.next.data;
		temp.next = null;
		return x;
		
	}
	
	public E peek() {
		
		if(head.next==null) {
			return head.data;
		}
		Node<E> temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		return temp.data;
		
	}
	
	static class Node<E>{
		E data;
		Node<E> next;
		
		Node(E data){
			this.data=data;
			next = null;
		}
	}

}

