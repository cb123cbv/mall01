package com.jk.service;

import com.jk.pojo.Product;
import com.jk.pojo.Product_image;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    List<Product_image> queryProduct(Integer id);
}
