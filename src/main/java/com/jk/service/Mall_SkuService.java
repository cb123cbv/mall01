package com.jk.service;

import com.jk.pojo.*;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface Mall_SkuService {
    SendPage getMall_Sku(ReceivePage receivePage, Mall_Sku mall_sku);

    String delMall_Sku(String id);

    List<Product> getSp(Integer id);

    List<Mall_attr> getSh(Integer id);

    void addSku(MySbx m);

 List<Attr_value> getShu(Attr_value a);
}
