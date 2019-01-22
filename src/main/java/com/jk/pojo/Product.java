package com.jk.pojo;

import lombok.Data;


@Data
public class Product {

    private Integer id;//编号

    private String shp_mch;//商品名称

    private String shp_tp;//商品图片

    private Integer flbh1;//分类编号1

    private Integer flbh2;//分类编号2

    private Integer pp_id;//品牌id

    private String chjshj;//创建时间

    private String shp_msh;//商品描述

    private String flmch1;

    private String flmch2;

    private String ppmch;

}
