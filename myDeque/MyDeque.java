package myDeque;

public class MyDeque<E> {
	
	Node<E> head, tail;
	
	public void addFirst(E data) {
		Node<E> node = new Node<>(data);
		
		if(head == null) {
			head = tail = node;
			return;
		}
		
		head.prev = node;
		node.next = head;
		head = node;
		
	}
	
	public void addLast(E data) {
		Node<E> node = new Node<>(data);
		
		if(tail == null) {
			head = tail = node;
			return;
		}
		
		tail.next = node;
		node.prev = tail;
		tail = node;
		
	}
	
	public E removeFirst() {
		
		if(head == null) {
			return null;
		}
		
		Node<E> temp = head;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		return temp.data;
	}
	
	public E removeLast() {
		if(tail==null) {
			return null;
		}
		
		Node<E> temp = tail;
		
		tail = tail.prev;
		if(tail==null) {
			head = null;
		}
		return temp.data;
	}
	
	public E peekFirst() {
		if(head == null) {
			return null;
		}
		
		return head.data;
	}
	
	public E peekLast() {
		if(tail==null) {
			return null;
		}
		
		return tail.data;
	}
	
	
	
	
	static class Node<E> {
		E data;
		Node<E> next, prev;
		Node(E data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

}
