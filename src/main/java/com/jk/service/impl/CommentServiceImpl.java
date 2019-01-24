package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.CommentMapper;
import com.jk.pojo.Product_comment;
import com.jk.service.CommentService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public SendPage queryComment(ReceivePage receivePage, Product_comment comment) {
        List<Product_comment> count = commentMapper.queryComment(comment);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Product_comment> list = commentMapper.queryComment(comment);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public void  updateState(Integer id,Integer flag) {

        commentMapper.updateState(id,flag);

    }


}
