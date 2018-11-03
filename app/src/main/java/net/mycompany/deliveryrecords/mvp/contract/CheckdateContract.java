package net.mycompany.deliveryrecords.mvp.contract;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Entity.Records;

import java.util.List;

public interface CheckdateContract {
    interface CheckDatecontractView{
        void displaydateRecords(List<Records> date);
        Context getContext();
    }
    interface CheckdatePresenter{
        void displayrecordbydateView(String date);
    }
}
