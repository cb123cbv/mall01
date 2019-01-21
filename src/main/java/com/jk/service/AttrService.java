package com.jk.service;

import com.jk.pojo.MallAttr;
import com.jk.pojo.QueryParam;

import java.util.List;

public interface AttrService {

    List<MallAttr> queryAttr(MallAttr mallAttr);

    void adds(QueryParam queryParam);

    void deletes(String ids);
}
