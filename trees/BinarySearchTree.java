package trees;

import java.util.*;

public class BinarySearchTree {

    class Node {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
 
    Node root;
 
    BinarySearchTree() { 
    	root = null; 
    }
 
    void deleteKey(int key) { 
    	root = deleteRec(root, key); 
    }
 
    Node deleteRec(Node root, int key)
    {
       
        if (root == null)
            return root;
 
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            root.key = minValue(root.right);
 
            root.right = deleteRec(root.right, root.key);
        }
 
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null) 
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
 
    void insert(int key) { 
    	root = insertRec(root, key); 
    }
 
    Node insertRec(Node root, int key)
    {
 
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        return root;
    }
 
    void inorder() { 
    	inorderRec(root); 
    }
 
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
 
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        
        System.out.print("Enter number of elements to input: ");
        int n = sc.nextInt();
        int num;
        for(int i=0; i<n; i++) {
        	System.out.print("Enter element no "+(i+1)+": ");
        	num = sc.nextInt();
        	tree.insert(num);
        }
        
        System.out.print("Inorder traversal: ");
        tree.inorder();
        System.out.println();
        
        System.out.print("Enter number to delete: ");
        int del = sc.nextInt();
        tree.deleteKey(del);
        
        System.out.print("Inorder traversal after delete: ");
        tree.inorder();
       
    }
}
