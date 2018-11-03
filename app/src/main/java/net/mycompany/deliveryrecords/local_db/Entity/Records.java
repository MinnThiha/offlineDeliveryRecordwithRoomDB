package net.mycompany.deliveryrecords.local_db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tbl_record")
public class Records {
    @PrimaryKey(autoGenerate = true)
    int id;

    private String itemname;
    private String receiver_name;
    private String location;
    private String receiver_ph;
    private String delivery_date;
    private int status=0;

    public Records(String itemname, String receiver_name, String location, String receiver_ph, String delivery_date, int status) {
        this.itemname = itemname;
        this.receiver_name = receiver_name;
        this.location = location;
        this.receiver_ph = receiver_ph;
        this.delivery_date = delivery_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReceiver_ph() {
        return receiver_ph;
    }

    public void setReceiver_ph(String receiver_ph) {
        this.receiver_ph = receiver_ph;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
