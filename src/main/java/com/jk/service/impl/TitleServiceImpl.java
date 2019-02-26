package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.TitleMapper;
import com.jk.pojo.ImgInfo;
import com.jk.pojo.TitleInfo;
import com.jk.pojo.TitleMin;
import com.jk.service.TitleService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {

    @Resource
    TitleMapper titleMapper;

    @Override
    public SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo) {

        List<TitleInfo> count = titleMapper.queryTitleInfo(titleInfo);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<TitleInfo> list = titleMapper.queryTitleInfo(titleInfo);
        SendPage sp= new SendPage(count.size(),list);
        return sp;

    }

    @Override
    public void addInfo(TitleInfo titleInfo) {
        if(titleInfo.getId() == null){
            titleMapper.addInfo(titleInfo);
        }else{
            titleMapper.updateInfo(titleInfo);
        }
    }

    @Override
    public TitleInfo getById(Integer id) {
        return titleMapper.getById(id);
    }

    @Override
    public void deletes(String ids) {
        titleMapper.deletes(ids);
    }


    @Override
    public void importTitle(TitleInfo title) {
        titleMapper.importTitle(title);
    }

    //poi导出升级版
    @Override
    public List<TitleInfo> queryTitleList(String ids) {
        return titleMapper.queryTitleList(ids);
    }


//------------------------------------------增删改查-----轮播图----------------------
    @Override
    public SendPage queryImgInfo(ReceivePage receivePage, ImgInfo imgInfo) {
        List<ImgInfo> count = titleMapper.queryImgInfo(imgInfo);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<ImgInfo> list = titleMapper.queryImgInfo(imgInfo);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public void addImgInfo(ImgInfo imgInfo) {
        if(imgInfo.getId() == null){
            titleMapper.addImgInfo(imgInfo);
        }else{
            titleMapper.updateImgInfo(imgInfo);
        }
    }

    @Override
    public ImgInfo getImgById(Integer id) {
        return titleMapper.getImgById(id);
    }

    @Override
    public void deleteImg(String ids) {
        titleMapper.deleteImg(ids);
    }



//------------------------------------------增删改查-----轮播标题----------------------
    @Override
    public SendPage queryTitleMin(ReceivePage receivePage, TitleMin titleMin) {
        List<TitleMin> count = titleMapper.queryTitleMin(titleMin);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<TitleMin> list = titleMapper.queryTitleMin(titleMin);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public void addTitleMin(TitleMin titleMin) {
        if(titleMin.getId() == null){
            titleMapper.addTitleMin(titleMin);
        }else{
            titleMapper.updateTitleMin(titleMin);
        }
    }

    @Override
    public TitleMin getTitleMinById(Integer id) {
        return titleMapper.getTitleMinById(id);
    }

    @Override
    public void deleteTitleMin(String ids) {
        titleMapper.deleteTitleMin(ids);
    }


}
