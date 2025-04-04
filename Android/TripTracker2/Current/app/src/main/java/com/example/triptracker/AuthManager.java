package com.example.triptracker;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {

    private static final String TAG = "AuthManager";
    private FirebaseAuth auth;
    public AuthManager() {
        auth = FirebaseAuth.getInstance();
    }

    public interface AuthCallback {
        void onComplete(boolean success, String errorMessage);
    }

    public void signUpWithEmailAndPassword(String email, String password, final AuthCallback callback) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success
                            Log.d(TAG, "createUserWithEmail:success");
                            callback.onComplete(true, null);
                        } else {
                            // Sign up failed
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            callback.onComplete(false, task.getException().getMessage());
                        }
                    }
                });
    }


    public void signInWithEmailAndPassword(String email,String password, final AuthCallback callback){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(TAG,"signInWithEmail:success");
                    callback.onComplete(true,null);
                }else{
                    Log.w(TAG,"signInWithEmail:failure",task.getException());
                    callback.onComplete(false,task.getException().getMessage());
                }
            }
        });
    }

    public FirebaseUser getCurrentUser(){
        return auth.getCurrentUser();
    }

}