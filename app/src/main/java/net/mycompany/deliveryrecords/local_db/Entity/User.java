package net.mycompany.deliveryrecords.local_db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tbl_user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String pw;

    public User(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
