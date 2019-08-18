package com.example.administrator.helloworld;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;




public class UserService {
    private DatabaseHelper dbHelper;

    public UserService(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public boolean login(String username, String password) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=? and password=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username, password});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    public boolean name(String username) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "select * from user where username=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{username});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    public boolean register(User user) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        String sql = "insert into user(username,password) values(?,?)";
        Object obj[] = {user.getUsername(), user.getPassword1()};
        sdb.execSQL(sql, obj);
        return true;
    }

    public void delete(String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from user where username=?", new Object[] { name });
        db.close();
    }

    public void update(String name, String pass) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update user set password=? where username=?", new Object[] {
                pass, name });

        db.close();
    }

}




