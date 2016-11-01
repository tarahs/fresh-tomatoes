package com.slalom.utils;

/**
 * Created by tara.
 */
public class Utils {

    private Utils(){

    }

    /**
     * Check if the String is null or Empty String
     * @param str
     * @return
     */
    public static boolean isNullOrNullString( String str )
    {
        return null == str || str.isEmpty() || "".equals(str.trim()) || "null".equals(str);
    }

    /**
     * Escape WildCards
     * @param str
     * @return
     */
    public static String escapeWildCards(String str){
        return str.replaceAll("%","\\\\%")
                .replaceAll("_","\\\\_")
                .replaceAll("\\\\","\\\\\\");
    }

}
