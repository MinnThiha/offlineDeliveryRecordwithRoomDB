package net.mycompany.deliveryrecords.local_db.Dao;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import net.mycompany.deliveryrecords.local_db.Entity.User;



@Dao
public interface UserDao {
    @Query("Select count(*) from tbl_user where name=:name and pw=:pw")
    int checkUser(String name,String pw);

    @Insert
    void insertUser(User u);
}
