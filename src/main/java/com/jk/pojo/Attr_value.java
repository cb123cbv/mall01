package com.jk.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Attr_value {


    private Integer Id;//(编号)  PKInteger
    private String shxzh;//(属性值) String(100)
    private String shfqy;//(是否启用)  String(1)
    private Integer shxm_id;//(属性id)  Integer
    private String shxzh_mch;//(单位) String(100)
    private Date chjshj;//(创建时间) Date

    //-----------------
    private String shxm;//(属性名) String(100)
}
