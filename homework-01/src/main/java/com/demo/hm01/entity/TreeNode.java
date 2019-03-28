package com.demo.hm01.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TreeNode")
public class TreeNode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30, unique = true)
	private String nameString;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parentNode_id", nullable = true)
	private TreeNode parentNode;

	@OneToMany(mappedBy = "parentNode", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TreeNode> treeNodes = new ArrayList<TreeNode>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public TreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}

	public List<TreeNode> getTreeNodes() {
		return treeNodes;
	}

	public void setTreeNodes(List<TreeNode> treeNodes) {
		this.treeNodes = treeNodes;
	}

	@Override
	public String toString() {
		return "TreeNode [id=" + id + ", nameString=" + nameString + ", parentNode=" + parentNode + ", treeNodes="
				+ treeNodes + "]";
	}

}
