package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.pojo.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Controller
public class TreeController {
 @Autowired
 TreeService treeService;

 @Resource
 private RedisTemplate<String, List<Tree>> redisTemplate;

 @RequestMapping("toView")
 public String toView(String url){
  return url;
 }
 @ResponseBody
 @RequestMapping("getTree")
 public List<Tree> getTree(){
  boolean tree_demo = redisTemplate.hasKey("tree_demo");
  if (tree_demo) {
   List<Tree> tree_demo1 = redisTemplate.opsForValue().get("tree_demo");
   return tree_demo1;
  }
  List<Tree> tree = treeService.getTree();
  redisTemplate.opsForValue().set("tree_demo", tree, 30, TimeUnit.SECONDS);
  return tree;


 }
}
