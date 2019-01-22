package com.jk.mapper;

import com.jk.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mall_SkuMapper {
    List<Mall_Sku> getMall_Sku(Mall_Sku mall_sku);

    void delMall_Sku(String id);

    List<Product> getSp(@Param("id")Integer id);

    List<Mall_attr> getSh(Integer id);

    void addSku(MySbx m);

  List<Attr_value> getShu(Integer shxm_id);

    void addMallSkuAttrValue(Mall_sku_attr_value m);
}
