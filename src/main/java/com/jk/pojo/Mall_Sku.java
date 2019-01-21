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
public class Mall_Sku {

    private  Integer id;      //(编号)          PKInteger
    private  Integer shp_id;  //(商品id)      Integer
    private  Integer kc;      //(库存)          Integer
    private  Double  jg;      //(价格)          decimal
    private  String chjshj;   //(创建时间)  Date
    private  String sku_mch; //(sku名称)  String(100)
    private  Integer sku_xl;  //(sku销量)   Integer
    private  String kcdz;     //(库存地址)    String(500)

    private  String  shp_mchName;    //商品名称
}
