package chap.lang.com.qq.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chap.lang.com.qq.DbMannager.DbMannager;
import chap.lang.com.qq.R;
import chap.lang.com.qq.ViewHolder;
import chap.lang.com.qq.adapters.MyAdapter;
import chap.lang.com.qq.domain.ShopimgCar;
import chap.lang.com.qq.interfaces.SetOnNumListener;

/**
 * Created by Administrator on 2017/6/26.
 */
public class ShoppingCarFrafement extends Fragment implements View.OnClickListener,SetOnNumListener{
    private View view;
    private ListView shopimg_car_lv;
    private EditText count;
    private List<Map<String,Object>> cdata =new ArrayList<Map<String, Object>>();
    private Button jiesuan,deleteBt;
    private TextView price_tv;
    private int prices;
    private  List<HashMap<String, Object>> listdata;
    private DbMannager db;
    private MyAdapter adapter;
    int sun;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.fragment_gouwuche_layout,container,false);
        }
        initView(view);
        return view;
    }

    private void initView(final View view) {
        db=new DbMannager(getActivity());
        count= (EditText) view.findViewById(R.id.lv_item_txt);
        shopimg_car_lv= (ListView) view.findViewById(R.id.shopimg_car_lv);
        jiesuan= (Button) view.findViewById(R.id.jiesuan);
        price_tv= (TextView) view.findViewById(R.id.price_tv);
        deleteBt= (Button) view.findViewById(R.id.delete);
        deleteBt.setOnClickListener(this);
        listdata = db.Query();
        adapter=new MyAdapter(getActivity(),listdata);
        shopimg_car_lv.setAdapter(adapter);


        jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup)view.getParent()).removeView(view);

    }

    @Override
    public void onClick(View view) {
        String posit=null;
        switch (view.getId()){
            case R.id.delete:
                HashMap<Integer, Boolean> state = adapter.state;
                for(int j=0;j<adapter.getCount();j++)
                    if (state.get(j) != null) {
                        ShopimgCar shop = (ShopimgCar) adapter.getItem(j);
                        int postion = shop.getPostion();
                        Log.i("asa", "postio" + postion);
                        posit = String.valueOf(postion);
                    }
                db.Delete(posit);
                adapter=new MyAdapter(getActivity(),listdata );
                shopimg_car_lv.setAdapter(adapter);
                break;
        }
    }


    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Map item = listdata.get(arg2);
        Log.i("Msg", "arg0="+arg0.getClass() +"  ,arg1="+arg1.getClass());
        CheckBox box =(CheckBox) arg1.findViewById(R.id.gouwuche_cb);
        if(cdata.contains(item)){
            cdata.remove(item);
            box.setChecked(false);
        }else{
            cdata.add(item);
            box.setChecked(true);
        }
        sumPrice();
    }

    public void sumPrice(){
        float sum=0;
        for(Map<String,Object> item : cdata){
            sum+=(Integer)item.get("PRICE")*(Integer)item.get("count");
        }
        price_tv.setText("总价：￥ "+sum);
    }

    @Override
    public void onAddNumListener(int price, ViewHolder holder) {
        Log.i("点击了","加");
        String numStr = holder.price_text.getText().toString();
        int num=Integer.parseInt(numStr);
        num++;
        holder.price_text.setText(num+"");
        int totalPrice=price*num;
        price_tv.setText(""+totalPrice);
    }

    @Override
    public void onSubNumListener(int price, ViewHolder holder) {
        Log.i("点击了","减");
        String numStr = holder.price_text.getText().toString();
        int num=Integer.parseInt(numStr);
        if(num>1){
            num--;
            holder.price_text.setText(num+"");
            int totalPrice=price*num;
            price_tv.setText(""+totalPrice);
        }else{
            Toast.makeText(getActivity(), "不能再减少了", Toast.LENGTH_SHORT).show();
        }
    }
}
