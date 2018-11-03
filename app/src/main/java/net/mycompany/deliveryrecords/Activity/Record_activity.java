package net.mycompany.deliveryrecords.Activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.Utils.AppConstant;
import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.mvp.contract.RecordsContract;
import net.mycompany.deliveryrecords.mvp.presenter.RecordsPresenter;

import java.util.Calendar;

public class Record_activity extends AppCompatActivity implements RecordsContract.RecordActivityView {
    private EditText et_item,et_name,et_location,et_ph,et_date;
    private Button btn_save,btn_dp;
    private Boolean isUpdate=false;
    private Integer id=0;
    RecordsPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_activity);
        et_item=findViewById(R.id.et_name_ra);
        et_name=findViewById(R.id.et_rname_ra);
        et_location=findViewById(R.id.et_location_ra);
        et_ph=findViewById(R.id.et_ph_ra);
        et_date=findViewById(R.id.et_date_ra);
        btn_dp=findViewById(R.id.btn_dpick_ra);
        btn_save=findViewById(R.id.btn_save_ra);
        presenter=new RecordsPresenter(this);

        if(getIntent()!=null){
            Intent i=getIntent();
            Bundle bd=i.getExtras();
            if (bd!=null){
                isUpdate=true;
                String itemname=bd.getString(AppConstant.ITEM_KEY);
                String name=bd.getString(AppConstant.RECEIVED_KEY);
                String location=bd.getString(AppConstant.LOCATION_KEY);
                String ph=bd.getString(AppConstant.RECEIVED_Ph_KEY);
                String date=bd.getString(AppConstant.DATE_KEY);
                id=bd.getInt(AppConstant.ID_KEY);
                et_item.setText(itemname);
                et_date.setText(date);
                et_location.setText(location);
                et_name.setText(name);
                et_ph.setText(ph);
            }
        }


        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                final int year=cal.get(Calendar.YEAR);
                final int day=cal.get(Calendar.DAY_OF_MONTH);
                final int month=cal.get(Calendar.MONTH);
               DatePickerDialog dpd=new DatePickerDialog(Record_activity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       String date=day+"/"+month+"/"+year;
                       et_date.setText(date);
                   }
               }, year,month,day);
               dpd.show();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onClickSave();
            }
        });
    }


    public void onClickSave(){
        String iname=et_item.getText().toString();
        String name=et_name.getText().toString();
        String location=et_location.getText().toString();
        String ph=et_ph.getText().toString();
        String date=et_date.getText().toString();
        if (isUpdate){
            Records records=new Records(iname,name,location,ph,date,0);
            records.setId(id);
            presenter.updateRecords(records);
        }
        else {
            Records record=new Records(iname,name,location,ph,date,0);
            presenter.insertRecords(record);
        }
        Toast.makeText(Record_activity.this,"Save successful",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
