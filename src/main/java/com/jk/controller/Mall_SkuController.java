package com.jk.controller;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.pojo.Mall_attr;
import com.jk.pojo.Mall_sku;
import com.jk.pojo.Product;
import com.jk.service.Mall_SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@RestController
public class Mall_SkuController {
 @Autowired
 Mall_SkuService mall_skuService;
 @RequestMapping("getSp")
 public List<Product> getSp(Integer id){
  List<Product> list=mall_skuService.getSp(id);
  return list;
 }
 @RequestMapping("getSh")
 public List<Mall_attr> getSh(Integer id){
  return mall_skuService.getSh(id);
 }
 @RequestMapping("addSku")
 public String addSku(Mall_sku m){
  mall_skuService.addSku(m);
  return null;
 }

}
