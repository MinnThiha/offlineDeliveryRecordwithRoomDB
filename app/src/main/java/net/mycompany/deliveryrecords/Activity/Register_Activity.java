package net.mycompany.deliveryrecords.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.local_db.Entity.User;
import net.mycompany.deliveryrecords.repository.UserRepository;

public class Register_Activity extends AppCompatActivity {
    private EditText et_name,et_pw,et_cpw;
    private Button btn_save;
    private UserRepository repository;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        btn_save=findViewById(R.id.btn_save_ra);
        et_name=findViewById(R.id.et_uname_rea);
        et_pw=findViewById(R.id.et_pw_rea);
        et_cpw=findViewById(R.id.et_cpw_rea);
        repository=new UserRepository(this);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                String pw=et_pw.getText().toString();
                String cpw=et_cpw.getText().toString();
                if (name.isEmpty()){
                    et_name.setText("Need to fill UserName");
                    return;
                }
                if(pw.isEmpty() || cpw.isEmpty()){
                    Toast.makeText(Register_Activity.this,"Need to fill password",Toast.LENGTH_LONG).show();
                    return;
                }
                if (!cpw.equals(pw)){
                    Toast.makeText(Register_Activity.this,"Passwords are mismatch",Toast.LENGTH_LONG).show();
                    return;
                }

                User u=new User(name,pw);
                repository.insertUser(u);
                Toast.makeText(Register_Activity.this,"Successful Registered",Toast.LENGTH_LONG).show();
                finish();

            }
        });

    }
}
