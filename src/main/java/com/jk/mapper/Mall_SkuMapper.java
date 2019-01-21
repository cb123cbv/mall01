package com.jk.mapper;

import com.jk.pojo.Mall_attr;
import com.jk.pojo.Mall_sku;
import com.jk.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * &lt;pre&gt;${enclosing_method}(这里用一句话描述这个方法的作用)
 *
 * @Author：陈斌 创建时间：${date} ${time}
 * ${tags}&lt;/pre&gt;
 */
public interface Mall_SkuMapper {
 List<Product> getSp(@Param("id")Integer id);
 List<Mall_attr> getSh(Integer id);

 void addSku(Mall_sku m);
}
