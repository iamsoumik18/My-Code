package myLinkedList;

public class MyLinkedList<E> {
	
	Node<E> head;
	
	public void add(E data) {
		Node<E> node = new Node<>(data);
		
		if(isEmpty()){
			head = node;
			return;
		}
		
		Node<E> temp = head;
		
		while(temp.next != null) {
			temp = temp .next;
		}
		temp.next = node;
		
	}
	
	public void removeAt(int pos) {
		
		if(head==null) {
			return;
		}
		
		Node<E> temp = head;
		
		if(pos==0) {
			head=temp.next;
			return;
		}
		
		for(int i=0; temp.next!=null && i<pos-1; i++) {
			temp = temp.next;
		}
		
		if(temp==null || temp.next == null) {
			return;
		}
		
		Node<E> next = temp.next.next;
		temp.next = next;
		
	}
	
	public void print() {
		Node<E> temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public void reverse() {
		Node<E> current = head;
		Node<E> prev = null;
		Node<E> next = null;
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public E get(int n) {
		
		Node<E> temp = head;
		int i = 1;
		while(i<=n) {
			temp = temp.next;
			i++;
		}
		return temp.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
//	Node<E> mergeList(Node<E> h1, Node<E> h2){
//		if(h1==null)return h2;
//		
//		if(h2==null)return h1;
//		
//		if(h1.data < h2.data) {
//			h1.next = mergeList(h1.next, h2);
//			return h1;
//		}else {
//			h2.next = mergeList(h1, h2.next);
//			return h2;
//		}
//	}

	static class Node<E> {
		E data;
		Node<E> next;
		
		Node(E data){
			this.data = data;
			next = null;
		}
	}
	
}
