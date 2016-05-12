package com.springmvc.web.cookie;

import sun.security.provider.MD5;

import java.util.Random;

/**
 * Created by guanghaoshao on 15/11/30.
 */
public class MD5cookie {

    public static String md5_shao()  {
        String md5s="";
        int c[]=new int[5];
        for(int i=0;i<5;i++){
            c[i]= new Random().nextInt(100);
        }
        System.out.println(c[0]+" "+c[1]+" "+c[2]+" "+c[3]+" "+c[4]);
        int radom=new Random().nextInt(5);

        System.out.println(radom);
        for(int j=0;j<5;j++){
            if(j<=radom && (c[j]>64 && c[j]<92)){
                char c1=(char)c[j];
                String temp=String.valueOf(c1);
                md5s=md5s+temp;
            }else{
                String temp=String.valueOf(c[j]);
                md5s=md5s+temp;
            }
        }
        return md5s;
    };

    public static void main(String args[]){

            System.out.println(MD5cookie.md5_shao());

    }
}
