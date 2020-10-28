package com.example.vmall;

import android.content.Context;

import java.util.Map;

public class SPUtil {
    /**
     * 保存 账号和密码
     */
    public static boolean saveAccount(Context context, String account, String password){
        context.getSharedPreferences("data",Context.MODE_PRIVATE).edit().putString("account",account)
                .putString("password",password).apply();
        return true;
    }
    /**
     * 获取存储的账号和密码
     */
    public static Map<String,String> getAll(Context context){
        return (Map<String, String>)context.getSharedPreferences("data",Context.MODE_PRIVATE).getAll();
    }
    /**
     * 清楚用户信息
     * @param context 上下文
     */
    public static void clear(Context context){
        context.getSharedPreferences("data",Context.MODE_PRIVATE).edit().clear().apply();
    }
}
