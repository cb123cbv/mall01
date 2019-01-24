package com.jk.service;

import com.jk.pojo.TitleInfo;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

public interface TitleService {
    SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo);

    void addInfo(TitleInfo titleInfo);

    TitleInfo getById(Integer id);

    void deletes(String ids);
}
