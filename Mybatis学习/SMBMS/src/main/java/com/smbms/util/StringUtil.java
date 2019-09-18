package com.smbms.util;

/**

 */
public class StringUtil {


    public static boolean isEmpty(String obj){
        if(obj == null)
            return true;
        obj = obj.trim();
        if(obj.length() == 0)
            return true;
        return false;
    }

}
