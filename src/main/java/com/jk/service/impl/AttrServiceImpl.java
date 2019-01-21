package com.jk.service.impl;

import com.jk.mapper.AttrMapper;
import com.jk.pojo.Attr_value;
import com.jk.pojo.MallAttr;
import com.jk.pojo.QueryParam;
import com.jk.service.AttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {
    @Resource
    private AttrMapper attrMapper;

    @Override
    public List<MallAttr> queryAttr(MallAttr mallAttr) {
        List<MallAttr> mallAttrs = attrMapper.queryAttr(mallAttr);
        for (MallAttr Attr : mallAttrs) {
            List<Attr_value> nameList = attrMapper.AttrByIdgetAttrValueName(Attr.getId());
            String flag="";
            for (Attr_value attr_value : nameList) {
                flag+=attr_value.getShxzh()+attr_value.getShxzh_mch()+"   ";

            }
            Attr.setShxz(flag);
        }

        return mallAttrs;
    }

    @Override
    public void adds(QueryParam queryParam) {
        attrMapper.addMallAttr(queryParam);
        int querymax = attrMapper.querymax();
        for (Attr_value attr_value : queryParam.getAttr_value()) {
            if(attr_value.getShxzh()!=null){
                attrMapper.addAttr_value(attr_value,querymax);
            }
        }

    }

    @Override
    public void deletes(String ids) {
        attrMapper.deletes(ids);
    }
}
