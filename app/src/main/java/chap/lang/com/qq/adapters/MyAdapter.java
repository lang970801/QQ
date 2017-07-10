package chap.lang.com.qq.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chap.lang.com.qq.R;
import chap.lang.com.qq.ViewHolder;
import chap.lang.com.qq.interfaces.SetOnNumListener;

/**
 * Created by Administrator on 2017/6/24.
 */
public class MyAdapter extends BaseAdapter{
    private Context contxt;
    private int count=0;
    private List<HashMap<String, Object>> listdata;
    private LayoutInflater mInflater;
    private SetOnNumListener setOnNumListener;
    public HashMap<Integer, Boolean> state = new HashMap<Integer, Boolean>();
    public MyAdapter(Context context, List<HashMap<String, Object>> listdata){
        this.contxt=context;
        this.listdata=listdata;
        this.mInflater=LayoutInflater.from(contxt);
//      setOnNumListener= (SetOnNumListener)contxt;

    }
    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int i) {
        return listdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView( int i, View convertView, ViewGroup viewGroup) {
       final Map<String,Object>item=listdata.get(i);
             item.put("count",1);
        Log.i("asadff",""+item);
        if (convertView==null){
            convertView= mInflater.inflate(R.layout.shopimg_car_item_layout,null);
             ViewHolder holder=new ViewHolder();
             holder.checkBox= (CheckBox) convertView.findViewById(R.id.shopimg_car_cb);
             holder.img= (ImageView) convertView.findViewById(R.id.shopimg_car_iv);
             holder.deteils_txt= (TextView) convertView.findViewById(R.id.shopimg_car_deteile_tv);
             holder.price_text=(TextView) convertView.findViewById(R.id.shopimg_car_price_tv);
             holder.addBt= (Button) convertView.findViewById(R.id.lv_item_add);
             holder.subtractBt= (Button) convertView.findViewById(R.id.lv_item_min);
             holder.showCount= (EditText) convertView.findViewById(R.id.lv_item_txt);
             convertView.setTag(holder);
         }
        final ViewHolder holder = (ViewHolder) convertView.getTag();
         int id= (int) listdata.get(i).get("POSTON");
        switch (id){
            case 0:
                holder.img.setImageResource(R.mipmap.a);
                break;
            case 1:
                holder.img.setImageResource(R.mipmap.b);
                break;
            case 2:
                holder.img.setImageResource(R.mipmap.c);
                break;
            case 3:
                holder.img.setImageResource(R.mipmap.d);
                break;
            case 4:
                holder.img.setImageResource(R.mipmap.e);
                break;
            case 5:
                holder.img.setImageResource(R.mipmap.f);
                break;
            case 6:
                holder.img.setImageResource(R.mipmap.g);
                break;
            case 7:
                holder.img.setImageResource(R.mipmap.j);
                break;
        }
        holder.deteils_txt.setText(""+listdata.get(i).get("GOODS"));
        holder.price_text.setText(""+listdata.get(i).get("PRICE"));
        holder.showCount.setText(item.get("count")+"");

//        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//                if (b){
//                    state.put(i,b);
//                }else {
//                    state.remove(i);
//                }
//
//                holder.checkBox.setChecked((state.get(i) == null ? false : true));
//            }
//        });

        holder.subtractBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnNumListener.onSubNumListener(10,holder);
            }
        });
        holder.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnNumListener.onAddNumListener(10,holder);
            }
        });
        return convertView;
    }

}
