package chap.lang.com.qq.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import chap.lang.com.qq.R;

/**
 * Created by Administrator on 2017/6/24.
 */
public class GoodsFenleiAdapter extends BaseAdapter{
    private Context context;
   private ArrayList<HashMap<String,Object>> listdata;
    private LayoutInflater mInflater;
    public GoodsFenleiAdapter(Context context, ArrayList<HashMap<String,Object>> listdata){
        this.context=context;
        this.listdata=listdata;
        this.mInflater=LayoutInflater.from(context);
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
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
         if (convertView==null){
            convertView= mInflater.inflate(R.layout.goodsfenlei_item,null);
             ViewHolder holder=new ViewHolder();
             holder.img= (ImageView) convertView.findViewById(R.id.goodsfenlei_iv);
             holder.xingqin_tv=(TextView) convertView.findViewById(R.id.goods_xingqin);
             holder.price_tv=(TextView) convertView.findViewById(R.id.goods_price);
             holder.haopin_tv=(TextView) convertView.findViewById(R.id.goods_haopin);
             convertView.setTag(holder);
         }
        final ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.img.setImageResource((Integer) listdata.get(i).get("IMGID"));
        holder.xingqin_tv.setText((String) listdata.get(i).get("DETAILS"));
        holder.price_tv.setText((String)listdata.get(i).get("PRICE"));
        holder.haopin_tv.setText((String)listdata.get(i).get("HAOPIN"));
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView xingqin_tv, price_tv,haopin_tv;
    }
}
