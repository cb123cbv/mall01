package com.jk.mapper;

import com.jk.pojo.Attr_value;
import com.jk.pojo.MallAttr;
import com.jk.pojo.QueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttrMapper {

    List<MallAttr> queryAttr(MallAttr mallAttr);

    List<Attr_value>  AttrByIdgetAttrValueName(Integer id);

    void addMallAttr(QueryParam queryParam);

    int querymax();

    void addAttr_value(@Param("attr_value")Attr_value attr_value, @Param("querymax") int querymax);


    @Delete("delete from t_mall_attr where id in(${ids})")
    void deletes(@Param("ids") String ids);
}
