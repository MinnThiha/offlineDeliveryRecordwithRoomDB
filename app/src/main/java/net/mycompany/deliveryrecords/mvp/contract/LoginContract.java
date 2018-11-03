package net.mycompany.deliveryrecords.mvp.contract;

import android.content.Context;

public interface LoginContract {
    interface LoginActivityView{
        void displayError();
        void displaySuccess();
        Context getContext();
    }
    interface LoginActivityPresenter{
        void checkLoginUser(String user,String pw);
    }
}
