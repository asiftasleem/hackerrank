/**
 * 
 */
package io.github.asiftasleem.levelOrderTraversal;

//Iterative Queue based Java program to do level order traversal
//of Binary Tree

/* importing the inbuilt java classes required for the program */
import java.util.Queue;
import java.util.LinkedList;

/**
 * @author mtasleem
 *
 */
public class Solution {

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the nodes
		 */
		BinaryTree tree_level = new BinaryTree();
		tree_level.root = new Node(1);

		tree_level.root.left = new Node(2);
		tree_level.root.right = new Node(3);

		tree_level.root.left.left = new Node(4);
		tree_level.root.left.right = new Node(5);

		tree_level.root.right.left = new Node(6);
		tree_level.root.right.right = new Node(7);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.connect();
		
		System.out.println("done");
	}

}

/* Class to represent Tree node */
class Node {
	int data;
	Node left, right, nextRight;

	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}
	
	public String toString() {
		return data + "";
	}
}

/* Class to print Level Order Traversal */
class BinaryTree {

	Node root;

	// Sets nextRight of all nodes of a tree
	void connect() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		// null marker to represent end of current level
		queue.add(null);

		// Do Level order of tree using NULL markers
		while (!queue.isEmpty()) {
			Node p = queue.poll();
			
			if (p != null) {

				// next element in queue represents next
				// node at current Level
				p.nextRight = queue.peek();

				// push left and right children of current
				// node
				if (p.left != null)
					queue.add(p.left);
				if (p.right != null)
					queue.add(p.right);
			}

			// if queue is not empty, push NULL to mark
			// nodes at this level are visited
			else if (!queue.isEmpty())
				queue.add(null);
		}
	}

	static int max_level = 0;

	// recursive function to print left view
	void leftViewUtil(Node node, int level) {
		// Base Case
		if (node == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + node.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}

	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}

	/*
	 * Given a binary tree. Print its nodes in level order using array for
	 * implementing queue
	 */
	int size() {
		return size(root);
	}

	/* computes number of nodes in tree */
	int size(Node node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}

	int findMax(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.data;
		int lres = findMax(node.left);
		int rres = findMax(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

}
