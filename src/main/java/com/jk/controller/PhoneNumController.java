package com.jk.controller;

import com.jk.pojo.PhoneNum;
import com.jk.service.PhoneNumService;
import com.jk.utils.ExportExcel;
import com.jk.utils.ImportExcel;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("phone")
public class PhoneNumController {

    @Resource
    PhoneNumService phoneNumService;

    @RequestMapping("queryPhoneNumInfoCpp")
    @ResponseBody
    public SendPage queryPhoneNumInfoCpp(ReceivePage receivePage, PhoneNum phoneNum) {
        SendPage phoneList = phoneNumService.queryPhoneNumInfoCpp(receivePage,phoneNum);
        return phoneList;
    }

    @RequestMapping("addInfoCpp")
    @ResponseBody
    public String addInfo(PhoneNum phoneNum) {
        phoneNumService.addInfoCpp(phoneNum);
        return "";
    }

    //根据id  回显
    @RequestMapping("getByIdCpp")
    @ResponseBody
    public PhoneNum getByIdCpp(Integer id) {
        PhoneNum phone = phoneNumService.getByIdCpp(id);
        return phone;
    }

    //删除
    @ResponseBody
    @RequestMapping("deletesCpp")
    public String deletesCpp(String ids) {
        phoneNumService.deletesCpp(ids);
        return "1";
    }


    //poi导出
    String format = "";

    @ResponseBody
    @RequestMapping("exportExcelCpp")
    public String exportExcel(@RequestParam("id[]") String[] id) throws Exception {
        String sheetName = "黑名单";
        String titleName = "手机号黑名单信息列表";
        String[] headers = {"ID", "用户名", "手机号", "创建时间"};
        List<PhoneNum> dataSet = phoneNumService.getPhoneNumListCpp(id);
        /*生成桌面路径*/
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();
        /*时间戳*/
        SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-ddHHmmss");
        format = sb.format(new Date());
        String resultUrl = com + "\\" + format + ".xls";
        String pattern = "yyyy-MM-dd";

        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
        return "success";
    }

    //poi导入
    @ResponseBody
    @RequestMapping("importExcelCpp")
    public String importExcel(MultipartFile file) throws Exception {
      /*  FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();
        System.out.println(com);*/
        //String originUrl=com+"\\"+format+".xls";

        String filePath = file.getOriginalFilename();
       // System.out.println(filePath);
        String path = filePath.substring(filePath.lastIndexOf("."));
        if (path.equals(".xls")) {
            int startRow = 2;//从表格的哪一行开始读取
            int endRow = 0;
            List<PhoneNum> phoneList = (List<PhoneNum>) ImportExcel.importExcel(file.getInputStream(), startRow, endRow, PhoneNum.class);
            for (PhoneNum phoneNum : phoneList) {
                phoneNumService.importPhoneNumCpp(phoneNum);
            }
            return "1";//成功
        } else {
            return "0";
        }
    }


}
