package com.demo.hm01.dao;

import java.util.List;

import com.demo.common.dao.IBaseDao;
import com.demo.hm01.entity.TreeNode;

public interface ITreeNodeDao extends IBaseDao<TreeNode, Long> {
	public void disengageCenterNode(TreeNode node);
}
