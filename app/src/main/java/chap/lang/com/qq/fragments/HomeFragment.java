package chap.lang.com.qq.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chap.lang.com.qq.R;
import chap.lang.com.qq.RegisterActivity;
import chap.lang.com.qq.ShopingDeteils;

/**
 * Created by Administrator on 2017/6/26.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private GridView gv;
    private List<HashMap<String,Object>> datalist;
    private int[]imgId={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.j};
    private  String []names={"台式电脑","儿童三轮车","电饭煲","仓鼠粮","厨房秤","儿童汽车","台式电脑","餐具"};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if(view==null){
           view=inflater.inflate(R.layout.fragment_home_layout,container,false);
       }
        initView(view);
        return view;
    }

    private void initView(View v) {
      gv= (GridView) v.findViewById(R.id.gridView_main);
        initData();
        String []from={"IMG","TXT"};
        int []to={R.id.home_item_img,R.id.home_item_name};
     gv.setAdapter(new SimpleAdapter(v.getContext(),datalist,R.layout.home_item,from,to));
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup)view.getParent()).removeView(view);
    }

    private void initData() {
        datalist=new ArrayList<HashMap<String, Object>>();
        for (int i=0;i<imgId.length;i++){
            HashMap<String,Object> map= new HashMap<String,Object>();
            map.put("IMG",imgId[i]);
            map.put("TXT",names[i]);
            datalist.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent =new Intent(HomeFragment.this.getActivity(),ShopingDeteils.class);
        intent.putExtra("position",i);
        intent.putExtra("names",names);
        startActivity(intent);
    }
}
