package net.mycompany.deliveryrecords.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.icu.text.AlphabeticIndex;
import android.os.AsyncTask;

import net.mycompany.deliveryrecords.local_db.Dao.RecordDao;
import net.mycompany.deliveryrecords.local_db.Entity.Records;

import java.util.List;

public class RecordsRepository extends BaseRepository {
    RecordDao RDao;
    public RecordsRepository(Context ctxt) {
        super(ctxt);
        RDao=db.getRecordDao();
    }
    public LiveData<List<Records>> getAll(){

        return RDao.getAllRecords();
    }
    public List<Records> QueryBydate(String date){
        return RDao.QueryBydate(date);
    }
    public void insertRecords(Records records){
        myInsertTask mit=new myInsertTask(RDao);
        mit.execute(records);
    }
    public void deleteRecords(Records records){
       myDeleteTask mdt=new myDeleteTask(RDao);
       mdt.execute(records);

    }
    public void updateRecords(Records records){
        myUpdateTask mut=new myUpdateTask(RDao);
        mut.execute(records);
    }


    class myInsertTask extends AsyncTask<Records,Void,Void>{
        RecordDao RDao;

        public myInsertTask(RecordDao RDao) {
            this.RDao = RDao;
        }

        @Override
        protected Void doInBackground(Records... records) {
            RDao.insertRecord(records[0]);
            return null;
        }
    }

    class myDeleteTask extends AsyncTask<Records,Void,Void>{
        RecordDao RDao;

        public myDeleteTask(RecordDao RDao) {
            this.RDao = RDao;
        }

        @Override
        protected Void doInBackground(Records... records) {
            RDao.deleteRecord(records[0]);
            return null;
        }
    }
    class myUpdateTask extends AsyncTask<Records,Void,Void>{
        RecordDao RDao;

        public myUpdateTask(RecordDao RDao) {
            this.RDao = RDao;
        }

        @Override
        protected Void doInBackground(Records... records) {
            RDao.updateRecord(records[0]);
            return null;
        }
    }

}
