package com.jk.service;

import com.jk.pojo.Product_comment;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface CommentService {
    SendPage queryComment(ReceivePage receivePage, Product_comment comment);

    void updateState(Integer id,Integer flag);


}
