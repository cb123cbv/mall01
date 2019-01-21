package com.jk.service;

import com.jk.pojo.Mall_Sku;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface Mall_SkuService {
    SendPage getMall_Sku(ReceivePage receivePage, Mall_Sku mall_sku);

    String delMall_Sku(String id);
}
