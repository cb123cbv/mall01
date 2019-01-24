package com.jk.controller;

import com.jk.pojo.Product_comment;
import com.jk.service.CommentService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    //查询
    @RequestMapping("queryComment")
    @ResponseBody
    public SendPage queryComment(ReceivePage receivePage, Product_comment comment) {
        SendPage titleList = commentService.queryComment(receivePage,comment);
        return titleList;
    }

    //审核订单
    @RequestMapping("updateState")
    @ResponseBody
    public void updateState(Integer id,Integer flag){

       commentService.updateState(id,flag);
    }



}
