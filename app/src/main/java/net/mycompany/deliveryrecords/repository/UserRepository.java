package net.mycompany.deliveryrecords.repository;

import android.content.Context;
import android.os.AsyncTask;

import net.mycompany.deliveryrecords.local_db.Dao.UserDao;
import net.mycompany.deliveryrecords.local_db.Entity.User;

public class UserRepository extends BaseRepository {
    UserDao udao;
    public UserRepository(Context ctxt) {
        super(ctxt);
        udao=db.getuserDao();
    }
    public void insertUser(User user){
        myInsertTask mit=new myInsertTask(udao);
        mit.execute(user);
    }
    public boolean checkUser(String user,String pw){
        int count=udao.checkUser(user,pw);
        if (count>0){
            return true;
        }
        else {
            return false;
        }
    }
    class myInsertTask extends AsyncTask<User,Void,Void>{
        UserDao udao;

        public myInsertTask(UserDao udao) {
            this.udao = udao;
        }

        @Override
        protected Void doInBackground(User... users) {
            udao.insertUser(users[0]);
            return null;
        }
    }

}
