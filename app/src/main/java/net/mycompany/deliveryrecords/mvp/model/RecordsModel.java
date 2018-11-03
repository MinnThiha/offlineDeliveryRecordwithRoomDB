package net.mycompany.deliveryrecords.mvp.model;

import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.repository.RecordsRepository;

public class RecordsModel {
    RecordsRepository repository;
    public RecordsModel(Context ctxt){
        repository=new RecordsRepository(ctxt);
    }
    public void insertRecords(Records records){
        repository.insertRecords(records);
    }
    public void updateRecords(Records records){
        repository.updateRecords(records);
    }
}
