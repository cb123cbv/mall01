package com.jk.controller;

import com.jk.pojo.TitleInfo;
import com.jk.service.TitleService;
import com.jk.utils.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("title")
public class TitleController {

    @Resource
    private TitleService titleService;

    //查询
    @RequestMapping("queryTitleInfo")
    @ResponseBody
    public SendPage queryTitleInfo(ReceivePage receivePage, TitleInfo titleInfo) {
        SendPage titleList = titleService.queryTitleInfo(receivePage, titleInfo);
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



    //poi导出(升级版)
     @ResponseBody
     @RequestMapping("exportExcel")
     public ResponseEntity<byte[]> exportExcel(String ids) throws Exception {
         String sheetName = "标题列表";
         String titleName = "mall项目中的标题列表";
         String[] headers = {"标题ID", "商品名称", "标题跳转路径"};
         List<TitleInfo> dataSet = titleService.queryTitleList(ids);

         String replace = UUID.randomUUID().toString().replace("-", "");

         String fileDir = "E:\\poi\\";

         File file = new File(fileDir);
         if (!file.exists()) {
            file.mkdirs();
         }
         String randomPath = fileDir + replace+".xls";

         String pattern = "yyyy-MM-dd";

         ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, randomPath, pattern);

         return FileUtil.FileDownload(randomPath,"fileName.xls");

     }











    //poi导入
    @ResponseBody
    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file) throws Exception {

        String filePath = file.getOriginalFilename();
        System.out.println(filePath);
        String path = filePath.substring(filePath.lastIndexOf("."));
        if (path.equals(".xls")) {
            int startRow = 2;//从表格的哪一行开始读取
            int endRow = 0;
            List<TitleInfo> titleList = (List<TitleInfo>) ImportExcel.importExcel(file.getInputStream(), startRow, endRow, TitleInfo.class);
            for (TitleInfo title : titleList) {
                titleService.importTitle(title);
            }
            return "1";//成功
        } else {
            return "0";
        }
    }


}
