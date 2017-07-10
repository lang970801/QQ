package chap.lang.com.qq.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/6/25.
 */
public class SPUtils {
    public static void put(Context context,String FileName,String key,Object object){
        SharedPreferences sp = context.getSharedPreferences(FileName, context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        if (object instanceof String){
            editor.putString(key,(String)object);
        }
        editor.commit();
    }
    public static  Object get(Context context,String FileName,String key){
        SharedPreferences sp= context.getSharedPreferences(FileName,context.MODE_PRIVATE);

            return sp.getString(key,"");

//        String s=sp1.getString(key,"");
//        String s1=sp1.getString("pword","");
    }
}
