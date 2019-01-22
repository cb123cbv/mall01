package com.jk.controller;


import com.jk.pojo.*;
import com.jk.service.Mall_SkuService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/21
 * @since 1.0.0
 */
@Controller
public class Mall_SkuController {

    @Autowired
    Mall_SkuService mall_skuService;

    @ResponseBody
    @RequestMapping("getMall_Sku")
    public SendPage getMall_Sku(ReceivePage receivePage,Mall_Sku mall_sku){

        SendPage list= mall_skuService.getMall_Sku(receivePage,mall_sku);
           return  list;
    }

    @ResponseBody
    @RequestMapping("delMall_Sku")
    public String delMall_Sku(String id){

        mall_skuService.delMall_Sku(id);
        return  null;
    }
    @ResponseBody
    @RequestMapping("getSp")
    public List<Product> getSp(Integer id){
        List<Product> list=mall_skuService.getSp(id);
        return list;
    }
    @ResponseBody
    @RequestMapping("getSh")
    public List<Mall_attr> getSh(Integer id){
        return mall_skuService.getSh(id);
    }
    @ResponseBody
    @RequestMapping("addSku")
    public String addSku(MySbx my){
        mall_skuService.addSku(my);
        return null;
    }
    @ResponseBody
    @RequestMapping("getShu")
    public List<Attr_value> getShu(Attr_value a){
        List<Attr_value> list=  mall_skuService.getShu(a);
        return list;
    }

}
