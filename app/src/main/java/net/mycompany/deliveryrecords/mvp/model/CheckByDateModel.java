package net.mycompany.deliveryrecords.mvp.model;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.mvp.delecate.CheckByDateDelegate;
import net.mycompany.deliveryrecords.repository.RecordsRepository;

import java.util.List;

public class CheckByDateModel {
    RecordsRepository repository;

    public CheckByDateModel(Context ctxt) {
        repository=new RecordsRepository(ctxt);
    }
    public List<Records> QueryBydate(String date){
        return repository.QueryBydate(date);
    }
}
