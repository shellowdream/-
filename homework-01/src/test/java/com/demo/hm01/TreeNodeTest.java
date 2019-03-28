package com.demo.hm01;

import org.hibernate.Session;
import org.junit.Test;

import com.demo.hm01.dao.ITreeNodeDao;
import com.demo.hm01.dao.TreeNodeDao;
import com.demo.hm01.entity.TreeNode;

import junit.framework.TestCase;

public class TreeNodeTest extends TestCase {

	//运行test01前先在hibernate.cfg.xml文件中修改  <property name="hbm2ddl.auto">create</property>
	@Test
	public void test01() {
		ITreeNodeDao treeNodeDao = new TreeNodeDao();
		TreeNode treeNodeGrandpa = new TreeNode();
		treeNodeGrandpa.setNameString("中国");
		TreeNode treeNodeFather1 = new TreeNode();
		treeNodeFather1.setNameString("广东省");
		TreeNode treeNodeFather2 = new TreeNode();
		treeNodeFather2.setNameString("山东省");
		TreeNode treeNodeSon1 = new TreeNode();
		treeNodeSon1.setNameString("东莞市");
		TreeNode treeNodeSon2 = new TreeNode();
		treeNodeSon2.setNameString("广州市");

		treeNodeGrandpa.getTreeNodes().add(treeNodeFather1);
		treeNodeGrandpa.getTreeNodes().add(treeNodeFather2);
		treeNodeFather1.getTreeNodes().add(treeNodeSon1);
		treeNodeFather1.getTreeNodes().add(treeNodeSon2);
		treeNodeFather1.setParentNode(treeNodeGrandpa);
		treeNodeFather2.setParentNode(treeNodeGrandpa);
		treeNodeSon1.setParentNode(treeNodeFather1);
		treeNodeSon2.setParentNode(treeNodeFather1);

		treeNodeDao.save(treeNodeGrandpa);
	}

	//运行testRead前先在hibernate.cfg.xml文件中修改  <property name="hbm2ddl.auto">validate</property>
	@Test
	public void testRead() {
		ITreeNodeDao treeNodeDao = new TreeNodeDao();
		TreeNode rootNode = (TreeNode) treeNodeDao.findOne(1L);
		System.out.println("数据库中TreeNodes结构如下:");
		printNode(rootNode, 0); // 调用printNode函数进行输出
	}

	//运行testDeleteCenterNode前先在hibernate.cfg.xml文件中修改  <property name="hbm2ddl.auto">validate</property>
	@Test
	public void testDeleteCenterNode() {
		ITreeNodeDao treeNodeDao = new TreeNodeDao();
		
		TreeNode rootNodeOld = (TreeNode) treeNodeDao.findOne(1L);
		System.out.println("原数据库中TreeNodes结构如下:");
		printNode(rootNodeOld, 0); // 调用printNode函数进行输出
		
		TreeNode deleteNode = (TreeNode) treeNodeDao.findOne(2L);
		
		treeNodeDao.disengageCenterNode(deleteNode);
		treeNodeDao.delete(deleteNode);
		
		TreeNode rootNodeNew = (TreeNode) treeNodeDao.findOne(1L);
		System.out.println("修改后数据库中TreeNodes结构如下:");
		printNode(rootNodeNew, 0); // 调用printNode函数进行输出
	}
	
	//自定义方法，用于输出树形结构
	private void printNode(TreeNode node, int level) {
		String preStr = "";
		for (int i = 0; i < level; i++) {
			preStr += "|-->";
		}
		System.out.println(preStr + node.getNameString());
		for (TreeNode children : node.getTreeNodes()) {
			printNode(children, level + 1);
		}
	}

}
