package com.gl.Sayan_Das.stacksqueue.LAB3;

import java.util.HashSet;
import java.util.Set;

class Node{
	int data;
	Node left, right;
	public Node(int data) {
		this.data = data;
		left=right=null;
	}
}
public class BSTFindPair {
	
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTFindPair bst = new BSTFindPair();
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 70);
		bst.inOrderTraverse(bst.root);
		int targetSum = 70;
		bst.findPairWithGivenSum(bst.root, targetSum);
	}

	private void findPairWithGivenSum(Node root, int targetSum) {
		Set<Integer> set = new HashSet<>();
		if(!findPairUtil(root, targetSum, set))
			System.out.println("Pairs does not exist.......");
		
	}

	private boolean findPairUtil(Node root, int targetSum, Set<Integer> set) {
		
		if(root==null)
			return false;
		if(findPairUtil(root.left, targetSum, set))
			return true;
		int diff = targetSum - root.data;
		if(set.contains(diff)) {
			System.err.printf("Pair is found (" +diff+ ", " +root.data+ ")");
			return true;
		}
		else
			set.add(root.data);
		
		return findPairUtil(root.right, targetSum, set);
	}

	private void inOrderTraverse(Node root) {
		if (root == null)
			return;
		inOrderTraverse(root.left);
		System.out.print(root.data+" ");
		inOrderTraverse(root.right);
		
	}

	private Node insert(Node node, int key) {
		if(node==null) {
			node = new Node(key);
			return node;
		}
		if (key<node.data)
			node.left = insert(node.left, key);
		else if (key>node.data)
			node.right = insert(node.right, key);
		return node;
	}

}
