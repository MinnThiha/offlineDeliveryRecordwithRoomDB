package net.mycompany.deliveryrecords.Activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.mycompany.deliveryrecords.Adapter.RecordAdapter;
import net.mycompany.deliveryrecords.CallBack.RecordsCallBack;
import net.mycompany.deliveryrecords.R;
import net.mycompany.deliveryrecords.Utils.AppConstant;
import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.mvp.contract.CheckContract;
import net.mycompany.deliveryrecords.mvp.presenter.CheckPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckActivity extends AppCompatActivity implements CheckContract.CheckContractView {
    private RecordAdapter ad;
    private RecyclerView rv;
    CheckPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_activity);
        rv=findViewById(R.id.rv_ca);
        rv.setLayoutManager(new LinearLayoutManager(CheckActivity.this));
        final List<Records> r=new ArrayList<>();
        ad=new RecordAdapter(CheckActivity.this,r);
        presenter=new CheckPresenter(CheckActivity.this);
        rv.setAdapter(ad);
        ad.recordCallbackListener(new RecordsCallBack() {
            @Override
            public void recordOnclickListener(Records records) {
                Intent i=new Intent(CheckActivity.this,Record_activity.class);
                Bundle bd=new Bundle();
                bd.putString(AppConstant.ITEM_KEY,records.getItemname());
                bd.putString(AppConstant.RECEIVED_KEY,records.getReceiver_name());
                bd.putString(AppConstant.LOCATION_KEY,records.getLocation());
                bd.putString(AppConstant.RECEIVED_Ph_KEY,records.getReceiver_ph());
                bd.putString(AppConstant.DATE_KEY,records.getDelivery_date());
                i.putExtras(bd);
                startActivity(i);
            }

            @Override
            public void recordOnlongClickListener(Records records) {
                presenter.deleteRecords(records);
            }
        });


    }


    @Override
    public void displayRecords(LiveData<List<Records>> recordslist) {
        recordslist.observe(CheckActivity.this, new Observer<List<Records>>() {
            @Override
            public void onChanged(@Nullable List<Records> records) {
               ad.setnewRecord(records);
                Collections.reverse(records);
            }
        });
    }

    @Override
    public Context getContext() {
        return this;
    }
}
