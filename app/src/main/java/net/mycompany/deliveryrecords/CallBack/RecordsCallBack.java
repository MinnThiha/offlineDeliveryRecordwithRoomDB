package net.mycompany.deliveryrecords.CallBack;

import net.mycompany.deliveryrecords.local_db.Entity.Records;

public interface RecordsCallBack {
    void recordOnclickListener(Records records);
    void recordOnlongClickListener(Records records);
}
