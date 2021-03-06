package com.nf.util;

import java.util.Properties;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @Author: LJP
 * @Classname MailUtil
 * @Date: 2020-01-16 13:55
 * @Description: 向邮箱发送邮件的工具类
 */
public final class MailUtil implements Runnable {
    /**
     * email : 收件人邮箱
     */
    private String email;
    /**
     * code : 激活码
     */
    private String code;

    public MailUtil(String email, String code) {
        this.email = email;
        this.code = code;
    }

    @Override
    public void run() {
        // 1.创建连接对象javax.mail.Session
        // 2.创建邮件对象 javax.mail.Message
        // 3.发送一封激活邮件
        /**
         * 1530937232@qq.com : 发件人电子邮箱
         */
        String from = "1530937232@qq.com";
        /**
         * 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)
         */
        String host = "smtp.qq.com";

        /**
         * System.getProperties() ： 获取系统属性
         * setProperty("mail.smtp.host", host) ： 设置邮件服务器
         * setProperty("mail.smtp.auth", "true") ： 打开认证
         */
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");

        try {
            //QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1530937232@qq.com", "abccokarctalgdji"); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            // 2.3设置邮件主题
            message.setSubject("账号激活");
            // 2.4设置邮件内容
            String content =
                    "<html>" +
                            "<head></head>" +
                            "<body>" +
                            "<h1>这是一封激活邮件,请点击下面激活按钮来激活你的帐号</h1>" +
                            "<h3>" +
                            "<a href='http://localhost:8080/mall/activate?activateCode=" + code + "'>" +
                            "<button>激活</button>" +
                            "</a>" +
                            "</h3>" +
                            "<p>如出现按钮点击无效的情况，请到浏览器输入<a>" + "http://localhost:8080/mall/activate?activateCode=" + code  + "</a>来激活你的帐号</p>" +
                            "</body>" +
                            "</html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发送邮件时发生异常" + e);
        }
    }
}
