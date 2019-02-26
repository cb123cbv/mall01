package com.jk.service;

import com.jk.pojo.ImgInfo;
import com.jk.pojo.TitleInfo;
import com.jk.pojo.TitleMin;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface TitleService {
    SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo);

    void addInfo(TitleInfo titleInfo);

    TitleInfo getById(Integer id);

    void deletes(String ids);


    void importTitle(TitleInfo title);
    //poi导出升级版
    List<TitleInfo> queryTitleList(String ids);

//------------------------------------------增删改查-----轮播图----------------------
    SendPage queryImgInfo(ReceivePage receivePage, ImgInfo imgInfo);

    void addImgInfo(ImgInfo imgInfo);

    ImgInfo getImgById(Integer id);

    void deleteImg(String ids);

//------------------------------------------增删改查-----轮播标题----------------------
    SendPage queryTitleMin(ReceivePage receivePage, TitleMin titleMin);

    void addTitleMin(TitleMin titleMin);

    TitleMin getTitleMinById(Integer id);

    void deleteTitleMin(String ids);
}
