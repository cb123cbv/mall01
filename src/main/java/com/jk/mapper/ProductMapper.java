package com.jk.mapper;

import com.jk.pojo.Product;

import java.util.List;

public interface ProductMapper {
    /**
     * 分页查询
     * @param product
     * @return
     */
    List<Product> getPageList(Product product);

    void addProduct(Product product);
}
