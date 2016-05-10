package org.xgx.basic.patterns.structural.composite;

public class Tree {
	public static void main(final String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");

		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished!");
	}

	TreeNode root = null;

	public Tree(final String name) {
		root = new TreeNode(name);
	}
}
