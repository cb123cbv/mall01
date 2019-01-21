package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.Mall_SkuMapper;
import com.jk.pojo.Mall_Sku;
import com.jk.service.Mall_SkuService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/21
 * @since 1.0.0
 */
@Service
public class Mall_SkuServcieImpl implements Mall_SkuService {

   @Autowired
    Mall_SkuMapper mapper;

    @Override
    public SendPage getMall_Sku(ReceivePage receivePage, Mall_Sku mall_sku) {

        List<Mall_Sku> count=mapper.getMall_Sku(mall_sku);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Mall_Sku> list=mapper.getMall_Sku(mall_sku);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public String delMall_Sku(String id) {

        mapper.delMall_Sku(id);
        return  null;

    }
}
