package com.jk.service;

import com.jk.pojo.MallAttr;
import com.jk.pojo.QueryParam;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface AttrService {

    SendPage queryAttr(ReceivePage receivePage, MallAttr mallAttr);

    void adds(QueryParam queryParam);

    void deletes(String ids);
}
