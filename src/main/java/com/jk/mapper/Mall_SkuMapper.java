package com.jk.mapper;

import com.jk.pojo.Mall_Sku;

import java.util.List;

public interface Mall_SkuMapper {
    List<Mall_Sku> getMall_Sku(Mall_Sku mall_sku);

    void delMall_Sku(String id);
}
