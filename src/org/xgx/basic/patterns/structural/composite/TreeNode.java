package org.xgx.basic.patterns.structural.composite;

import java.util.Enumeration;
import java.util.Vector;

public class TreeNode {

	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();

	public TreeNode(final String name) {
		this.name = name;
	}

	// 添加孩子节点
	public void add(final TreeNode node) {
		children.add(node);
	}

	// 取得孩子节点
	public Enumeration<TreeNode> getChildren() {
		return children.elements();
	}

	public String getName() {
		return name;
	}

	public TreeNode getParent() {
		return parent;
	}

	// 删除孩子节点
	public void remove(final TreeNode node) {
		children.remove(node);
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setParent(final TreeNode parent) {
		this.parent = parent;
	}
}