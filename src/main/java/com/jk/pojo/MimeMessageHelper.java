package com.jk.pojo;

import lombok.Data;

@Data
public class MimeMessageHelper {

    private String to;//接收人的地址
    private String subject;//主题
    private String text;//内容
}
