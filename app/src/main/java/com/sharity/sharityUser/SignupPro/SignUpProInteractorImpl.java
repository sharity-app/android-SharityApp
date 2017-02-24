package com.sharity.sharityUser.SignupPro;

import android.os.Handler;
import android.text.TextUtils;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SignUpProInteractorImpl implements SignUpProInteractor {

    @Override
    public void login(final String username, final String password, String RC3number, String Businesname, String OwnerName, String Phone, String address, String RIB, String email, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;

                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                                listener.onSuccess();
                        } else {

                            // Signup failed. Look at the ParseException to see what happened.
                        }
                    }
                });

                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }
            }
        }, 800);
    }


}