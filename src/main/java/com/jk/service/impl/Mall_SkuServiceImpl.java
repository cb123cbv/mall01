package com.jk.service.impl;/**
 * &lt;pre&gt;(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：
 * &lt;/pre&gt;
 */

import com.jk.mapper.Mall_SkuMapper;
import com.jk.pojo.Mall_attr;
import com.jk.pojo.Mall_sku;
import com.jk.pojo.Product;
import com.jk.service.Mall_SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** &lt;pre&gt;(这里用一句话描述这个方法的作用)
 * @Author：陈斌
 * 创建时间：     
 * &lt;/pre&gt;    
 */
@Service
public class Mall_SkuServiceImpl implements Mall_SkuService {
 @Resource
 Mall_SkuMapper mall_skuMapper;

 @Override
 public List<Product> getSp(Integer id) {
   return mall_skuMapper.getSp(id);
 }

 @Override
 public List<Mall_attr> getSh(Integer id) {
  return mall_skuMapper.getSh(id);
 }

 @Override
 public void addSku(Mall_sku m) {
  mall_skuMapper.addSku(m);
 }
}
