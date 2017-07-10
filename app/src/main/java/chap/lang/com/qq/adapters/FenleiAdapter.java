package chap.lang.com.qq.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chap.lang.com.qq.R;
import chap.lang.com.qq.domain.ShopimgCar;

/**
 * Created by Administrator on 2017/6/24.
 */
public class FenleiAdapter extends BaseAdapter{
    private Context context;
   private ArrayList<String> listdata;
    private LayoutInflater mInflater;
    public FenleiAdapter(Context context,ArrayList<String> listdata){
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
            convertView= mInflater.inflate(R.layout.fenlei_item_layuot,null);
             ViewHolder holder=new ViewHolder();
             holder.fenlei_tv=(TextView) convertView.findViewById(R.id.fenlei_item_tv);
             convertView.setTag(holder);
         }
        final ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.fenlei_tv.setText(listdata.get(i));

        return convertView;
    }
    class ViewHolder{
        TextView fenlei_tv;
    }
}
