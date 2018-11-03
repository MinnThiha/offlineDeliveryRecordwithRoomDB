package net.mycompany.deliveryrecords.mvp.model;

import android.content.Context;

import net.mycompany.deliveryrecords.mvp.delecate.LoginDelecate;
import net.mycompany.deliveryrecords.repository.UserRepository;

public class LoginModel {
    UserRepository repository;

    public LoginModel(Context ctxt){
        repository=new UserRepository(ctxt);
    }
    public void checkUser(String user,String pw,LoginDelecate delecate){
        if (repository.checkUser(user,pw)){
            delecate.onSuccess();
        }
        else {
            delecate.onFail();
        }
    }


}
