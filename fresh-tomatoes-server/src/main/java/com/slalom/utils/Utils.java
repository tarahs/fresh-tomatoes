package com.slalom.utils;

/**
 * Created by tara on 10/27/16.
 */
public class Utils {

    private Utils(){

    }

    public static boolean isNullOrNullString( String str )
    {
        return null == str || str.isEmpty() || "".equals(str.trim()) || "null".equals(str);
    }

    public static String escapeWildCards(String str){
        return str.replaceAll("%","\\\\%")
                .replaceAll("_","\\\\_")
                .replaceAll("\\\\","\\\\\\");
    }

}
