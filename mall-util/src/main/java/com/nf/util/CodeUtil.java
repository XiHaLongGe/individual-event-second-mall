package com.nf.util;

import java.util.UUID;

/**
 * @Author: LJP
 * @Classname CodeUtil
 * @Date: 2020-01-16 13:58
 * @Description: 为帐号生成激活码的工具类
 */
public final class CodeUtil {
    /**
     * 生成唯一的激活码
     * @return 激活码
     */
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
