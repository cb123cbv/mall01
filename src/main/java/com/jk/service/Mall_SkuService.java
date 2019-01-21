package com.jk.service;

import com.jk.pojo.Mall_attr;

import com.jk.pojo.Mall_sku;
import com.jk.pojo.Product;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface Mall_SkuService {
 List<Product> getSp(Integer id);

 List<Mall_attr> getSh(Integer id);

 void addSku(Mall_sku m);
}
