package chap.lang.com.qq.DbMannager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/6/27.
 */
public class MyDbHelper extends SQLiteOpenHelper{
    private static final String DBNAME="my.db";
    private static final int DBVERSION=1;
    public MyDbHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String createTableSql="create table goods_info(_id integer primary key autoincrement,goods_info varchar,price integer,postions integer)";
//        String createTableSql="create table goods_info(_id integer primary key autoincrement,price integer,postions integer)";
        db.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
