package net.mycompany.deliveryrecords.mvp.model;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.repository.RecordsRepository;

import java.util.List;

public class CheckModel {
    RecordsRepository repository;
    public CheckModel(Context ctxt){
        repository=new RecordsRepository(ctxt);
    }
    public LiveData<List<Records>> getAllRecord(){
        return repository.getAll();
    }
    public void deleteRecords(Records records){
        repository.deleteRecords(records);
    }
}
