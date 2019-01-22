package com.jk.mapper;

import com.jk.pojo.Product;
import com.jk.pojo.Product_image;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductMapper {
    /**
     * 分页查询
     * @param product
     * @return
     */
    List<Product> getPageList(Product product);

    void addProduct(Product product);

    void addProduct_image(@Param("id") Integer id, @Param("url") String url);

    @Select("select * from t_mall_product_image where shp_id=#{id}")
    List<Product_image> queryProduct(Integer id);
}
