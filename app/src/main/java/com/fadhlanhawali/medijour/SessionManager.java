package com.fadhlanhawali.medijour;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "MedijourPref";

    private static final String KEY_IDUSER = "idUser";

    private static final String KEY_USER = "username";

    private static final String IS_LOGIN = "IsLoggedIn";

    public SessionManager(Context context) {
        this._context = context;
        preferences = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void createLoginSession(String idUser, String user){
        editor.putBoolean(IS_LOGIN,true);

        editor.putString(KEY_IDUSER, idUser);

        editor.putString(KEY_USER,user);

        editor.commit();
    }

    public HashMap<String,String> getUserDetails(){

        HashMap<String,String> user = new HashMap<>();

        user.put(KEY_IDUSER,preferences.getString(KEY_IDUSER,null));

        user.put(KEY_USER,preferences.getString(KEY_USER,null));

        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        //TODOx 
        // After logout redirect user to Loing Activity
//        Intent i = new Intent(_context, LoginActivity.class);
//        // Closing all the Activities
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        // Add new Flag to start new Activity
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        // Staring Login Activity
//        _context.startActivity(i);
    }
}
