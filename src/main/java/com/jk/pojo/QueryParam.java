package com.jk.pojo;

import java.util.List;

import lombok.Data;

@Data
public class QueryParam {


    private List<Attr_value> attr_value;//用来储存批量增加的对象
    private String shxm;//用来储存批量增加的属性名
    private Integer pid;





}
