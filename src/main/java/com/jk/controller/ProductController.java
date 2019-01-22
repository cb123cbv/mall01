package com.jk.controller;

import com.jk.pojo.Product;
import com.jk.service.ProductService;
import com.jk.utils.FileUtil;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("pro")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 分页查询
     */
    @RequestMapping("getPageList")
    @ResponseBody
    public SendPage getPageList(Product product, ReceivePage receivePage) {
        SendPage  sp = productService.getPageList(product, receivePage);
        return sp;
    }

    @ResponseBody
    @RequestMapping("addProduct")
    public String addProduct(Product product){
        productService.addProduct(product);
        return null;
    }
    @ResponseBody
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpServletRequest request){

        return FileUtil.upload(file,request);
    }
    @RequestMapping("toaddpro")
    public String toaddpro(){
        return "addpro";
    }

}
