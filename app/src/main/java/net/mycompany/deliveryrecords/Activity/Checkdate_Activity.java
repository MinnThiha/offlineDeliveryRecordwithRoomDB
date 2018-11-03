package net.mycompany.deliveryrecords.Activity;


import android.app.DatePickerDialog;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import net.mycompany.deliveryrecords.Adapter.CheckdateAdapter;
import net.mycompany.deliveryrecords.Adapter.RecordAdapter;
import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.mvp.contract.CheckdateContract;
import net.mycompany.deliveryrecords.mvp.presenter.CheckByDatePresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Checkdate_Activity extends AppCompatActivity implements CheckdateContract.CheckDatecontractView {
    private android.support.v7.widget.Toolbar tb;
    private RecyclerView rv;
    private CheckdateAdapter cda;
    CheckByDatePresenter presenter;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkdate_activity);
        tb=findViewById(R.id.tb_cda);
        setSupportActionBar(tb);
        rv=findViewById(R.id.rv_cda);
        rv.setLayoutManager(new LinearLayoutManager(Checkdate_Activity.this));
        tv=findViewById(R.id.tv_date_cda);



        List<Records> record=new ArrayList<>();//0

        presenter=new CheckByDatePresenter(Checkdate_Activity.this);
        cda=new CheckdateAdapter(Checkdate_Activity.this,record);
        rv.setAdapter(cda);


        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        String sdate=day+"/"+month+"/"+year;
        tv.setText(sdate);
        presenter.displayrecordbydateView(sdate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_dppicker,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dpset();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displaydateRecords(List<Records> date) {
     cda.setNewList(date);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String getString() {
        return "hello";
    }

    public void dpset(){

        Calendar cal=Calendar.getInstance();
         int year=cal.get(Calendar.YEAR);
         int day=cal.get(Calendar.DAY_OF_MONTH);
         int month=cal.get(Calendar.MONTH);

        DatePickerDialog dpd=new DatePickerDialog(Checkdate_Activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int iyear, int imonth, int idayOfMonth) {
                String date=idayOfMonth+"/"+imonth+"/"+iyear;
                tv.setText(date);
                presenter.displayrecordbydateView(tv.getText().toString());
            }
        }, year,month,day);
        dpd.show();

    }
}
