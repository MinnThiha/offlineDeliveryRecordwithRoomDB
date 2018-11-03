package net.mycompany.deliveryrecords.mvp.contract;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Entity.Records;

import java.util.List;

public interface CheckContract {
    interface CheckContractView{
        void displayRecords(LiveData<List<Records>> recordslist);
        Context getContext();

    }
    interface CheckPresenter{
        void displayRecordstoView();
        void deleteRecords(Records records);
    }
}
