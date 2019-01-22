package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.ProductMapper;
import com.jk.pojo.Product;
import com.jk.pojo.Product_image;
import com.jk.service.ProductService;
import com.jk.utils.FileUtil;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 分页查询
     * @param product
     * @param receivePage
     * @return
     */
    @Override
    public SendPage getPageList(Product product, ReceivePage receivePage) {
        List<Product> count = productMapper.getPageList(product); //计算数据库符合条件的总条数   条数是固定的
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<Product> list = productMapper.getPageList(product); //当前页面数据 其大小取决于 每页多少条
        SendPage sendPage = new SendPage(count.size(),list);
        return sendPage;
    }

    @Override
    public void addProduct(Product product) {

        productMapper.addProduct(product);
        if(!StringUtils.isEmpty(product.getPicOne())){
            productMapper.addProduct_image(product.getId(),product.getPicOne());
        }
        if(!StringUtils.isEmpty(product.getPicTwo())){
            productMapper.addProduct_image(product.getId(),product.getPicTwo());
        }
        if(!StringUtils.isEmpty(product.getPicThree())){
            productMapper.addProduct_image(product.getId(),product.getPicThree());
        }

    }

    @Override
    public String upload(MultipartFile file, HttpServletRequest request) {

        return FileUtil.upload(file,request);
    }

     @Override
    public List<Product_image> queryProduct(Integer id) {
        return productMapper.queryProduct(id);
    }

}
