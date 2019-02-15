package com.jk.controller;


import com.jk.pojo.Log;
import com.jk.pojo.MimeMessageHelper;
import com.jk.utils.ReceivePage;
import com.jk.utils.SendPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Query;
import java.util.List;


@Controller
@RequestMapping("mail")
public class MailController {

    //日志业务
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private JavaMailSender sender;

    /*@RequestMapping("send")
    public String send(){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();

        message.setFrom("8888888@qq.com"); // 必须要和上文配置的spring.mail.username内容相同
        //发送者
        mainMessage.setFrom("2439146769@qq.com");
        //接收者
        mainMessage.setTo("1009603379@qq.com");
        //发送的标题
        mainMessage.setSubject("嗨喽");
        //发送的内容
        mainMessage.setText("hello world");
        mailSender.send(mainMessage);
        return "1";
    }*/



    @RequestMapping("sendSimpleMail")
    @ResponseBody
    public String sendSimpleMail(MimeMessageHelper mime){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("zhang1009603379@163.com"); // 必须要和上文配置的spring.mail.username内容相同
        message.setTo(mime.getTo());
        message.setSubject(mime.getSubject());
        message.setText(mime.getText());
        sender.send(message);
        return "1";
    }



    @RequestMapping("getMongo")
    @ResponseBody
    public List<Log> getMongo(ReceivePage rp) {

        List<Log> logs = mongoTemplate.find(null,Log.class);
        return logs;
    }



    /*发送邮件的方法*//*
    @RequestMapping("sendSimple")
    @ResponseBody
    public String sendSimple(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("zhang1009603379@163.com"); //发送者
        message.setTo("1009603379@qq.com"); //接受者
        message.setSubject("ceshi"); //发送标题
        message.setText("111"); //发送内容
        sender.send(message);

        System.out.println("邮件发送成功");
            return "index";
    }
*/



}






