package myLinkedList;

public class MyDoublyLinkedList<E> {
	
	Node<E> head;
	
	void push(E data) {
		Node<E> node = new Node<>(data);
		
		node.next = head;
		node.prev = null;
		
		if(head != null)
			head.prev = node;
		
		head = node;
	}
	
	void append(E data) {
		Node<E> node = new Node<>(data);
		node.next = null;
		
		Node<E> temp = head;
		
		if(isEmpty()) {
			node.prev = null;
			head = node;
			return;
		}
		
		while(temp.next != null)
			temp = temp.next;
		
		temp.next = node;
		node.prev = temp;
	}
	
	void insertAfter(Node<E> prev, E data) {
		if(prev==null) {
			System.out.println("The given previous node cannot be null!");
			return;
		}
		
		Node<E> node = new Node<>(data);
		
		node.next = prev.next;
		node.prev = prev;
		prev.next = node;
		
		if(node.next != null) 
			node.next.prev = node;
		
	}
	
	boolean isEmpty() {
		return head==null;	
	}
	
}

class Node<E>{
	
	E data;
	Node<E> next;
	Node<E> prev;
	
	Node(E data){
		this.data = data;
	}
}