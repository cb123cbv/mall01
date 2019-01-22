package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.Mall_SkuMapper;
import com.jk.pojo.*;
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
    @Override
    public List<Product> getSp(Integer id) {
        return mapper.getSp(id);
    }

    @Override
    public List<Mall_attr> getSh(Integer id) {
        return mapper.getSh(id);
    }

    @Override
    public void addSku(MySbx m) {
     mapper.addSku(m);
     m.setId(m.getId());
     List<Mall_sku_attr_value> list = m.getMallSkuAttrValue();
     for (Mall_sku_attr_value value : list) {
      value.setSku_id(m.getId());
      value.setShp_id(m.getShp_id());
      mapper.addMallSkuAttrValue(value);
     }
    }

 @Override
 public List<Attr_value> getShu(Attr_value a) {
  return mapper.getShu(a.getShxm_id());
 }
}
