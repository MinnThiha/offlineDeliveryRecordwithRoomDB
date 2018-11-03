package net.mycompany.deliveryrecords.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.Utils.AppConstant;

public class MainActivity extends AppCompatActivity {
    private Button btn_record,btn_crecord,btn_trecord;
    private android.support.v7.widget.Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tb_ma);
        setSupportActionBar(tb);
        btn_record=findViewById(R.id.btn_record_ma);
        btn_crecord=findViewById(R.id.btn_crecord_ma);
        btn_trecord=findViewById(R.id.btn_trecord_ma);
        btn_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Record_activity.class);
                startActivity(i);

            }
        });

        btn_crecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,CheckActivity.class);
                startActivity(i);
            }
        });

        btn_trecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Checkdate_Activity.class);
                startActivity(i);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Logout){
            SharedPreferences shp=getSharedPreferences(AppConstant.LOGIN_NAME,MODE_PRIVATE);
            shp.edit().putInt(AppConstant.LOGIN_KEY,0).apply();
            Intent i=new Intent(MainActivity.this,Login_Activity.class);
            finish();
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
