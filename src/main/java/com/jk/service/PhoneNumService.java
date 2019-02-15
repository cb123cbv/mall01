package com.jk.service;

import com.jk.pojo.PhoneNum;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;

import java.util.List;

public interface PhoneNumService {
    SendPage queryPhoneNumInfoCpp(ReceivePage receivePage, PhoneNum phoneNum);

    void addInfoCpp(PhoneNum phoneNum);

    PhoneNum getByIdCpp(Integer id);

    void deletesCpp(String ids);

    List<PhoneNum> getPhoneNumListCpp(String[] id);

    void importPhoneNumCpp(PhoneNum phoneNum);
}
