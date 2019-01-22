package com.jk.service;

import com.jk.pojo.Product;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface ProductService {
    /**
     * 分页查询
     * @param product
     * @param receivePage
     * @return
     */
    SendPage getPageList(Product product, ReceivePage receivePage);

    void addProduct(Product product);

    String upload(MultipartFile file, HttpServletRequest request);

}
