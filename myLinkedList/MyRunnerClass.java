package myLinkedList;

import myDeque.MyDeque;
import myStack.MyStack;

public class MyRunnerClass {

	public static void main(String[] args) {
		
		MyStack<Integer> s = new MyStack<>();
		MyLinkedList<Integer> ll = new MyLinkedList<>();
		
		MyDeque<Integer> d = new MyDeque<>();
		
		d.addFirst(4);
		d.addLast(5);
		d.addFirst(3);
		d.addLast(6);
		System.out.println(d.removeFirst());
		System.out.println(d.removeLast());
		System.out.println(d.removeLast());
		System.out.println(d.removeFirst());
		
		
		
		
		
		
		
		

	}

}
