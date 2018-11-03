package net.mycompany.deliveryrecords.mvp.presenter;

import net.mycompany.deliveryrecords.mvp.contract.LoginContract;
import net.mycompany.deliveryrecords.mvp.delecate.LoginDelecate;
import net.mycompany.deliveryrecords.mvp.model.LoginModel;

public class LoginPresenter implements LoginContract.LoginActivityPresenter {
    LoginContract.LoginActivityView view;
    LoginModel mdl;

    public LoginPresenter(LoginContract.LoginActivityView view) {
        this.view = view;
        mdl=new LoginModel(view.getContext());
    }

    @Override
    public void checkLoginUser(String user, String pw) {
        mdl.checkUser(user,pw,new LoginDelecate() {
            @Override
            public void onSuccess() {
                view.displaySuccess();
            }

            @Override
            public void onFail() {
                view.displayError();
            }
        });

    }
}
