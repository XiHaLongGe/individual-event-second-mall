package com.nf.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: LJP
 * @Classname RandomCodeUtil
 * @Date: 2020-01-16 14:00
 * @Description: 生成随机帐号的工具类
 */
public final class RandomCodeUtil {
    private RandomCodeUtil() {
    }
    private static final char[] CHARS = new char[]{
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };

    /**
     * 调用这个函数，生成的账号长度默认为11
     * @return
     */
    public static String randomGenerate(){
        return RandomCodeUtil.randomGenerate(11);
    }
    public static String randomGenerate(int length) {
        List<String> list = new ArrayList<String>(CHARS.length);
        for (int i = 0; i < CHARS.length; i++) {
            list.add(String.valueOf(CHARS[i]));
        }
        Collections.shuffle(list);
        int count = 0;
        StringBuffer sb = new StringBuffer();
        Random random = new Random(System.nanoTime());
        while (count < length) {
            int i = random.nextInt(list.size());
            if(count == 0 && "0".equals(list.get(i))){
                sb.append("1");
            }else{
                sb.append(list.get(i));
            }
            count++;
        }
        return sb.toString();
    }
}
