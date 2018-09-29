package com.easy.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {


    /**
     * base64 编码
     *
     * @param str
     * @return
     */
    public static String encoder(String str){
        final Base64.Encoder encoder = Base64.getEncoder();
        String strEncoder = null;
        try {
            strEncoder = encoder.encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strEncoder;
    }


    /**
     * base64 解码
     *
     * @param str
     * @return
     */
    public static String decoder(String str){
        final Base64.Decoder decoder = Base64.getDecoder();
        String strDecoder = null;
        try {
            strDecoder = new String(decoder.decode(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return strDecoder;
    }

    public static void main(String[] args) {

        String v="11hdhddkdkl:1:?kiav=33";
        System.out.println(encoder(v));

        System.out.println(decoder(encoder(v)));

    }
}
