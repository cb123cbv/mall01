package com.jk.mapper;

import com.jk.pojo.PhoneNum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhoneNumMapper {
    List<PhoneNum> queryPhoneNumInfoCpp(PhoneNum phoneNum);

    void addInfoCpp(PhoneNum phoneNum);

    PhoneNum getByIdCpp(Integer id);

    void updateInfoCpp(PhoneNum phoneNum);

    void deletesCpp(@Param("ids") String ids);

    List<PhoneNum> getPhoneNumListCpp(String[] id);

    void importPhoneNumCpp(PhoneNum phoneNum);
}
