package com.jk.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MallAttr {


    private Integer Id;//(编号)            PKInteger
    private String shxm_mch;//(属性名称)  String(100)
    private String shfqy;//(是否启用)     String(1)
    private Integer flbh2;//(分类编号2)    Integer

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chjshj;//(创建时间)    Date

    //-----------------临时字段
    private String shxz;//返回的属性值名称
    private Integer queryid;//用来条查

}
