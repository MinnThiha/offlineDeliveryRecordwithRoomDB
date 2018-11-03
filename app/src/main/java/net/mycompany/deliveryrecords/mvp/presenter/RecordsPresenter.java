package net.mycompany.deliveryrecords.mvp.presenter;

import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.mvp.contract.RecordsContract;
import net.mycompany.deliveryrecords.mvp.model.RecordsModel;

public class RecordsPresenter implements RecordsContract.RecordActivityPresenter {
    RecordsContract.RecordActivityView view;
    RecordsModel rdl;

    public RecordsPresenter(RecordsContract.RecordActivityView view) {
        this.view = view;
        rdl=new RecordsModel(view.getContext());
    }

    @Override
    public void updateRecords(Records records) {
        rdl.updateRecords(records);
    }

    @Override
    public void insertRecords(Records records) {
        rdl.insertRecords(records);
    }
}
