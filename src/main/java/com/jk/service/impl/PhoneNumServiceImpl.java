package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.mapper.PhoneNumMapper;
import com.jk.pojo.PhoneNum;
import com.jk.service.PhoneNumService;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PhoneNumServiceImpl implements PhoneNumService {
    @Resource
    PhoneNumMapper phoneNumMapper;

    @Override
    public SendPage queryPhoneNumInfoCpp(ReceivePage receivePage, PhoneNum phoneNum) {
        List<PhoneNum> count = phoneNumMapper.queryPhoneNumInfoCpp(phoneNum);
        PageHelper.startPage(receivePage.getPage(),receivePage.getRows());
        List<PhoneNum> list = phoneNumMapper.queryPhoneNumInfoCpp(phoneNum);
        SendPage sp= new SendPage(count.size(),list);
        return sp;
    }

    @Override
    public void addInfoCpp(PhoneNum phoneNum) {
        if(phoneNum.getId()==null){
            phoneNumMapper.addInfoCpp(phoneNum);
        }else{
            phoneNumMapper.updateInfoCpp(phoneNum);
        }


    }

    @Override
    public PhoneNum getByIdCpp(Integer id) {
        return phoneNumMapper.getByIdCpp(id);
    }

    @Override
    public void deletesCpp(String ids) {
        phoneNumMapper.deletesCpp(ids);
    }

    @Override
    public List<PhoneNum> getPhoneNumListCpp(String[] id) {
        return phoneNumMapper.getPhoneNumListCpp(id);
    }

    @Override
    public void importPhoneNumCpp(PhoneNum phoneNum) {
        phoneNumMapper.importPhoneNumCpp(phoneNum);
    }
}
