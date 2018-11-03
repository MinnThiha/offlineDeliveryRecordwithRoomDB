package net.mycompany.deliveryrecords.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.Utils.AppConstant;
import net.mycompany.deliveryrecords.mvp.contract.LoginContract;
import net.mycompany.deliveryrecords.mvp.presenter.LoginPresenter;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login_Activity extends AppCompatActivity implements LoginContract.LoginActivityView {
    private EditText et_name,et_pw;
    private Button btn_login,btn_register;
    private SharedPreferences shp;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        et_name=findViewById(R.id.et_name_la);
        et_pw=findViewById(R.id.et_pw_la);
        btn_login=findViewById(R.id.btn_login_la);
        btn_register=findViewById(R.id.btn_register_la);
        presenter=new LoginPresenter(this);
//        Typeface tf=Typeface.createFromAsset(getAssets(),"fonts/zone.ttf");
//        btn_register.setTypeface(tf);

        shp=getSharedPreferences(AppConstant.LOGIN_NAME,MODE_PRIVATE);

        int checkLogin=shp.getInt(AppConstant.LOGIN_KEY,0);
        if (checkLogin==1){
            startActivity(new Intent(Login_Activity.this,MainActivity.class));
            finish();
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et_name.getText().toString();
                String pw=et_pw.getText().toString();
                if (uname.isEmpty()||pw.isEmpty()){
                    Toast.makeText(Login_Activity.this,"UserName or Password Wrong",Toast.LENGTH_SHORT).show();
                }
                presenter.checkLoginUser(uname,pw);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(a);
            }
        });
    }

    @Override
    public void displayError() {
        Toast.makeText(Login_Activity.this,"Login Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displaySuccess() {
        shp.edit().putInt(AppConstant.LOGIN_KEY,1).apply();
        startActivity(new Intent(Login_Activity.this,MainActivity.class));
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
