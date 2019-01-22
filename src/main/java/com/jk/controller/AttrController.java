package com.jk.controller;

import com.jk.pojo.MallAttr;
import com.jk.pojo.QueryParam;
import com.jk.service.AttrService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("attr")
public class AttrController {

    @Resource
    private AttrService attrService;


//查询属性
    @ResponseBody
    @RequestMapping("queryAttr")
    public SendPage queryAttr(ReceivePage receivePage, MallAttr mallAttr) {

        SendPage attrList = attrService.queryAttr(receivePage,mallAttr);

        return attrList;
    }



 //带Id跳转
    @RequestMapping("tospsxgl_add")
    public String tospsxgl_add(String queryid, Model model) {
        model.addAttribute("queryid",queryid);

        return "spsxgl_add";
    }



//批量新增属性
    @RequestMapping("adds")
    public String adds(QueryParam queryParam) {
        attrService.adds(queryParam);
        return "spsxgl";
    }

//删除
    @ResponseBody
    @RequestMapping("deletes")
    public String deletes(String ids) {
        attrService.deletes(ids);
        return "1";
    }





}
