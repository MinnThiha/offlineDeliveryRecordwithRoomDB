package net.mycompany.deliveryrecords.local_db.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Dao.RecordDao;
import net.mycompany.deliveryrecords.local_db.Dao.UserDao;
import net.mycompany.deliveryrecords.local_db.Entity.Records;
import net.mycompany.deliveryrecords.local_db.Entity.User;

@Database(entities = {User.class,Records.class},version =1 ,exportSchema = false)
public abstract class Record_db extends RoomDatabase {
    private static Record_db Ins;
    public abstract UserDao getuserDao();
    public abstract RecordDao getRecordDao();


    public static Record_db getIns(Context ctxt){
        if (Ins==null){
            Ins= Room.databaseBuilder(ctxt,Record_db.class,"record_db").allowMainThreadQueries().build();
        }
        return Ins;
    }
}
