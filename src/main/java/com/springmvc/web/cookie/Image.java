package com.springmvc.web.cookie;

import java.util.Map;

/**
 * Created by guanghaoshao on 15/12/20.
 */
public class Image {
    public static Map<String,String> img_map;

    public static Map<String, String> getImg_map() {
        return img_map;
    }

    public static void setImg_map(Map<String, String> img_map) {
        Image.img_map = img_map;
    }
}
