package com.jk.mapper;

import com.jk.pojo.ImgInfo;
import com.jk.pojo.TitleInfo;
import com.jk.pojo.TitleMin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {

    List<TitleInfo> queryTitleInfo(TitleInfo titleInfo);

    void addInfo(TitleInfo titleInfo);

    void updateInfo(TitleInfo titleInfo);

    TitleInfo getById(Integer id);

    void deletes(@Param("ids") String ids);

    void importTitle(TitleInfo title);
//poi导出升级版
    List<TitleInfo> queryTitleList(String ids);
//------------------------------------------增删改查-----轮播图----------------------
    List<ImgInfo> queryImgInfo(ImgInfo imgInfo);

    void addImgInfo(ImgInfo imgInfo);

    void updateImgInfo(ImgInfo imgInfo);

    ImgInfo getImgById(Integer id);

    void deleteImg(@Param("ids")String ids);

//------------------------------------------增删改查-----轮播标题----------------------
    List<TitleMin> queryTitleMin(TitleMin titleMin);

    void addTitleMin(TitleMin titleMin);

    void updateTitleMin(TitleMin titleMin);

    TitleMin getTitleMinById(Integer id);

    void deleteTitleMin(@Param("ids")String ids);
}
