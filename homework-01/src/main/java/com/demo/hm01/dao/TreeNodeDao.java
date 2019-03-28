package com.demo.hm01.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.common.dao.BaseDao;
import com.demo.hm01.entity.TreeNode;
import com.demo.util.HibernateUtil;

public class TreeNodeDao extends BaseDao<TreeNode, Long> implements ITreeNodeDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void disengageCenterNode(TreeNode node) {
		// 获取父节点
		TreeNode fatherNode = node.getParentNode();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// 转移子节点关联关系到父节点
		for (TreeNode children : node.getTreeNodes()) {
			children.setParentNode(fatherNode);
			session.update(children);
		}

		// 解除父子节点关联
		node.setParentNode(null);
		node.setTreeNodes(null);

		// 更新节点
		session.update(node);

		session.getTransaction().commit();
	}

}
