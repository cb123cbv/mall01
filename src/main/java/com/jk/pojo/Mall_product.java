package com.jk.pojo;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 王杰
 * @create 2019/1/21
 * @since 1.0.0
 */
@Data
public class Mall_product {
    private Integer id;//编号

    private String shp_mch;//商品名称

    private String shp_tp;//商品图片

    private String flbh1;//分类编号1

    private String flbh2;//分类编号2

    private String pp_id;//品牌id

    private String chjshj;//创建时间

    private String shp_msh;//商品描述
}
