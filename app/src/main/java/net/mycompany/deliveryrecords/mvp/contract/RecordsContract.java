package net.mycompany.deliveryrecords.mvp.contract;

import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Entity.Records;

public interface RecordsContract {
    interface RecordActivityView{
        Context getContext();
    }
    interface RecordActivityPresenter{
        void insertRecords(Records records);
        void updateRecords(Records records);

    }
}
