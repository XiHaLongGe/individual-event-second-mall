package com.nf.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LJP
 * @Classname Main
 * @Date: 2020-03-09 08:06
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        B b = new B();
    }
    static class B extends C{
        private static int a = 1 ;
        private int av = 2;
        {
            System.out.println("{}");
        }
        static{
            System.out.println("static{B}");
        }
        public B(){
            System.out.println("B");
        }
    }
    static class C extends D{
        static {
            System.out.println("static{C}");
        }
        public C(){
            System.out.println("C");
        }
    }
    static class D{
        static {
            System.out.println("static{D}");
        }
        {
            System.out.println("{D}");
        }
        public D(){
            System.out.println("D");
        }
    }
}
