package com.example.chunsik_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class SqlHelper extends SQLiteOpenHelper {

    private final static String db_name = "chunsikyee.db";
    private final static int db_version = 1;

    public SqlHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String create_sql = "CREATE TABLE \"Users\" (\n" +
//                "\t\"user_num\"\tINTEGER,\n" +
//                "\t\"user_id\"\tTEXT NOT NULL UNIQUE,\n" +
//                "\t\"user_pw\"\tTEXT NOT NULL,\n" +
//                "\t\"user_name\"\tTEXT NOT NULL,\n" +
//                "\t\"user_uid\"\tTEXT NOT NULL UNIQUE,\n" +
//                "\t\"isAdmin\"\tINTEGER NOT NULL CHECK(isAdmin == 0 or isAdmin == 1),\n" +
//                "\t\"user_organization\"\tTEXT NOT NULL,\n" +
//                "\tPRIMARY KEY(\"user_num\" AUTOINCREMENT)\n" +
//                "))";

        String create_sql = "create table if not exists Users(" +
                "user_num INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id text not null unique," +
                "user_pw text not null," +
                "user_name text not null," +
                "user_uid text not null unique," +
                "isAdmin INTEGER not null check(isAdmin == 0 or isAdmin == 1)," +
                "user_organization text not null)";

        String insert_sql = "insert into Users values('id','pw','name','uid',0,'oraginization')";
        sqLiteDatabase.execSQL(create_sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> getUserData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select user_name from Users", null);

        ArrayList<String> data = new ArrayList<>();

        while (cursor.moveToNext()){
            data.add(cursor.getString(0));
        }
        cursor.close();
        return data;
    }
}
