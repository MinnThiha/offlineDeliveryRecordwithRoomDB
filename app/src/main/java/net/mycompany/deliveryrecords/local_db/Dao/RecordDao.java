package net.mycompany.deliveryrecords.local_db.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import net.mycompany.deliveryrecords.local_db.Entity.Records;

import java.util.List;

@Dao
public interface RecordDao {

    @Query("select * from tbl_record")
    LiveData<List<Records>> getAllRecords();

    @Insert
    void insertRecord(Records records);

    @Update
    void updateRecord(Records records);

    @Delete
    void deleteRecord(Records records);

   @Query("select * from tbl_record where delivery_date=:delivery_date")
    List<Records> QueryBydate(String delivery_date);
}
