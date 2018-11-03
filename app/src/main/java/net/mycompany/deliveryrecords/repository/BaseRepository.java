package net.mycompany.deliveryrecords.repository;

import android.content.Context;

import net.mycompany.deliveryrecords.local_db.Database.Record_db;

public class BaseRepository {
    protected Record_db db;

    public BaseRepository(Context ctxt) {
        db=Record_db.getIns(ctxt);
    }

}
