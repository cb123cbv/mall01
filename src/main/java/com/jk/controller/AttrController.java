package com.jk.controller;

import com.jk.pojo.MallAttr;
import com.jk.pojo.QueryParam;
import com.jk.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("attr")
public class AttrController {

    @Resource
    private AttrService attrService;



    @ResponseBody
    @RequestMapping("queryAttr")
    public List<MallAttr> queryAttr(MallAttr mallAttr) {

        List<MallAttr> attrList = attrService.queryAttr(mallAttr);

        return attrList;
    }



    //测试注解
    @RequestMapping("tospsxgl_add")
    public String tospsxgl_add(String queryid, Model model) {
        model.addAttribute("queryid",queryid);
        System.out.println("aaaa");//测试
        System.out.println("aaaa111");//测试
        return "spsxgl_add";
    }




    @RequestMapping("adds")
    public String adds(QueryParam queryParam) {
        attrService.adds(queryParam);
        return "spsxgl";
    }


    @ResponseBody
    @RequestMapping("deletes")
    public String deletes(String ids) {
        attrService.deletes(ids);
        return "1";
    }





}
