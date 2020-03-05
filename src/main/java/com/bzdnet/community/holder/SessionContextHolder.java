package com.bzdnet.community.holder;


import com.bzdnet.community.model.UserModel;

public class SessionContextHolder {

    private static ThreadLocal<UserModel> holder = new ThreadLocal<>();

    public static UserModel get() {
        UserModel user = holder.get();
        if (user != null) {
            return user;
        }
        return new UserModel();
    }

    public static void set(UserModel user) {
        holder.set(user);
    }

}
