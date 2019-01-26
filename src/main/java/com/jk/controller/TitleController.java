package com.jk.controller;

import com.jk.pojo.TitleInfo;
import com.jk.service.TitleService;
import com.jk.utils.ExportExcel;
import com.jk.utils.ImportExcel;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("title")
public class TitleController {

    @Resource
    private TitleService titleService;

    //查询
    @RequestMapping("queryTitleInfo")
    @ResponseBody
    public SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo) {
        SendPage titleList = titleService.queryTitleInfo(receivePage,titleInfo);
        return titleList;
    }

    // 新增
    @RequestMapping("addInfo")
    @ResponseBody
    public String addInfo(TitleInfo titleInfo) {

        titleService.addInfo(titleInfo);
        return "";
    }

    //根据id  回显
    @RequestMapping("getById")
    @ResponseBody
    public TitleInfo getById(Integer id) {
        TitleInfo title = titleService.getById(id);
        return title;
    }

    //删除
    @ResponseBody
    @RequestMapping("deletes")
    public String deletes(String ids) {
        titleService.deletes(ids);
        return "1";
    }

    //poi导出
    @ResponseBody
    @RequestMapping("exportExcel")
    public String exportExcel(@RequestParam("id[]") String[] id) throws Exception{
        String sheetName="标题列表";
        String titleName="mall项目中的标题列表";
        String[] headers = { "标题ID", "商品名称", "标题跳转路径"};
        List<TitleInfo> dataSet = titleService.getTitleList(id);
        String resultUrl="E:\\poiTemp\\titleInfo.xls";
        String pattern="yyyy-MM-dd";

        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
        return "success";
    }

    //poi导入
    @ResponseBody
    @RequestMapping("importExcel")
    public String importExcel() throws Exception{
        String originUrl="E:\\poiTemp\\titleInfo.xls";
        int startRow=2;
        int endRow=0;
        List<TitleInfo> titleList = (List<TitleInfo>) ImportExcel.importExcel(originUrl, startRow, endRow, TitleInfo.class);
        for (TitleInfo title : titleList) {

            titleService.importTitle(title);
        }
        return "";
    }



}
