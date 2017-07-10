package chap.lang.com.qq;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import chap.lang.com.qq.DbMannager.DbMannager;
import chap.lang.com.qq.domain.ShopimgCar;

/**
 * Created by Administrator on 2017/6/27.
 */
public class ShopingDeteils extends Activity implements View.OnClickListener {
    private static final String TAG = "ShopingDeteils";
    private ImageView  goodsshowImg,startImg;
    private TextView priceTxt,goosName;
    private Button shoping_cart_btn,qingxionggou_bt;
    private int postion;
    private String []names;
    private DbMannager db;
    private ImageView deteils_car_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopimgdeteis_layout);
        initView();
        postion=getIntent().getIntExtra("position",-1);
        names= getIntent().getStringArrayExtra("names");
        boolean existence = isExistence(postion);
        if(existence){
            shoping_cart_btn.setEnabled(false);
            shoping_cart_btn.setBackgroundColor(getResources().getColor(R.color.gray));
        }
        switch (postion){
            case 0:
                goodsshowImg.setImageResource(R.mipmap.a);
                priceTxt.setText("1000");
                goosName.setText(names[0]);
                break;
            case 1:
                goodsshowImg.setImageResource(R.mipmap.b);
                priceTxt.setText("300");
                goosName.setText(names[1]);
                break;
            case 2:
                goodsshowImg.setImageResource(R.mipmap.c);
                priceTxt.setText("100");
               goosName.setText(names[2]);
                break;
            case 3:
                goodsshowImg.setImageResource(R.mipmap.d);
                priceTxt.setText("20");
                goosName.setText(names[3]);
                break;
            case 4:
                goodsshowImg.setImageResource(R.mipmap.e);
                priceTxt.setText("39");
               goosName.setText(names[4]);
                break;
            case 5:
                goodsshowImg.setImageResource(R.mipmap.f);
                priceTxt.setText("350");
                goosName.setText(names[5]);
                break;
            case 6:
                goodsshowImg.setImageResource(R.mipmap.g);
                priceTxt.setText("2000");
                goosName.setText(names[6]);
                break;
            case 7:
                goodsshowImg.setImageResource(R.mipmap.j);
                priceTxt.setText("40");
                goosName.setText(names[7]);
                break;
        }
        shoping_cart_btn.setOnClickListener(this);
    }

    private void initView() {
        goodsshowImg= (ImageView) findViewById(R.id.deteils_goods_iv);
        startImg= (ImageView) findViewById(R.id.deteis_start_img);
        priceTxt= (TextView) findViewById(R.id.deteis_preat1_tv);
        shoping_cart_btn= (Button) findViewById(R.id.deteils_shopimgcart_bt);
        qingxionggou_bt= (Button) findViewById(R.id.deteils_qingxionggou_bt);
        goosName= (TextView) findViewById(R.id.deteils_goods_shoutv);
        deteils_car_img= (ImageView) findViewById(R.id.deteils_img);

        deteils_car_img.setOnClickListener(this);
         db=new DbMannager(ShopingDeteils.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.deteils_shopimgcart_bt:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示信息");
                builder.setMessage("确定要加入购物车？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ShopingDeteils.this,"加入购物车成功",Toast.LENGTH_SHORT).show();
                        shoping_cart_btn.setEnabled(false);
                        shoping_cart_btn.setBackgroundColor(getResources().getColor(R.color.gray));
                        String pricerStr= priceTxt.getText().toString().trim();
                        String goodsName=goosName.getText().toString().trim();
                        int price=Integer.parseInt(pricerStr);
                        ShopimgCar car=new ShopimgCar();
                        car.setPostion(postion);
                        car.setGoodsName(goodsName);
                        car.setPrice(price);
                        db.Add(car);
                    }
                });
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
                builder.show();
                break;
            case R.id.deteils_img:
                Intent intent=new Intent(ShopingDeteils.this,MainActivity.class);
                intent.putExtra("flag",TAG);
                startActivity(intent);
                break;
        }


    }

    public boolean isExistence(int postion) {
        boolean flag=false;
        List<HashMap<String, Object>> data = db.Query();
        for (HashMap<String,Object> item:data){
           int p= (Integer) item.get("POSTON");
            if(p==postion){
                flag=true;
            }
        }
        return flag;
    }
}
