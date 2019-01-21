package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */


import com.jk.mapper.TreeMapper;
import com.jk.pojo.Tree;
import com.jk.service.TreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class TreeServiceImpl implements TreeService {
 @Resource
 TreeMapper treeMapper;
 @Override
 public List<Tree> getTree() {
  List<Tree> tree = treeMapper.getTree(0);
  queryTreeByPid(tree);
  return tree;
 }

 private void queryTreeByPid(List<Tree> tree) {
  for (Tree tree2 : tree) {
   List<Tree> tree3 = treeMapper.getTree(tree2.getId());
   queryTreeByPid(tree3);
   tree2.setChildren(tree3);
  }
 }
}
