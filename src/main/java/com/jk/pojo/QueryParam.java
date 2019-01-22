package com.jk.pojo;

import lombok.Data;

import java.util.List;

@Data
public class QueryParam {


    private Integer id;//两表新增,MallAttr自增的id
    private List<Attr_value> attr_value;//用来储存批量增加的对象
    private String shxm;//用来储存批量增加的属性名
    private Integer pid;






}
