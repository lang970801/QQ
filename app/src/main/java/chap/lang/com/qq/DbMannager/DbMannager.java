package chap.lang.com.qq.DbMannager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chap.lang.com.qq.domain.ShopimgCar;

/**
 * Created by Administrator on 2017/6/27.
 */
public class DbMannager {
    private Context context;
    private MyDbHelper dbHelper;
    private SQLiteDatabase db;
    private ArrayList<HashMap<String,Object>>listdata;
    public DbMannager(Context context){
        dbHelper=new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public  void Add(ShopimgCar shopimgCar){
        String sql="insert into goods_info values(null,?,?,?)";
            db.execSQL(sql, new Object[]{shopimgCar.getGoodsName(),shopimgCar.getPrice(), shopimgCar.getPostion()});
    }
    public List<HashMap<String,Object>> Query(){
        listdata=new ArrayList<HashMap<String, Object>>();
        String retrieveSql = "select * from goods_info";
        Cursor c = db.rawQuery(retrieveSql, null);
        while(c.moveToNext()) {
            HashMap<String,Object>map=new HashMap<String,Object>();
            String goods_name = c.getString(c.getColumnIndex("goods_info"));
            int price = c.getInt(c.getColumnIndex("price"));
            int postion = c.getInt(c.getColumnIndex("postions"));
            map.put("GOODS",goods_name);
            map.put("POSTON",postion);
            map.put("PRICE",price);
            listdata.add(map);
        }
        return listdata;
    }
    public void Delete(String  postions){
        int b = db.delete("goods_info", "postions=?", new String []{postions});
    }
}
