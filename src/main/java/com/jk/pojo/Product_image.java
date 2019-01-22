package com.jk.pojo;

import lombok.Data;

@Data
public class Product_image {

    private Integer id;//(编号)        PKInteger
    private String  zy;//((作用)        String(100)
    private Integer shp_id;//((商品id)  Integer
    private String url;//((图片地址)   String(100)

}
