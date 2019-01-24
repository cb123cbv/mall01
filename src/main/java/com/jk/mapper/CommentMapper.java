package com.jk.mapper;

import com.jk.pojo.Product_comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    List<Product_comment> queryComment(Product_comment comment);

    void updateState(@Param("id") Integer id, @Param("flag") Integer flag);



}
