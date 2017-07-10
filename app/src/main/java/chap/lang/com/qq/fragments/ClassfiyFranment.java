package chap.lang.com.qq.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import chap.lang.com.qq.GoodsFenlei;
import chap.lang.com.qq.R;
import chap.lang.com.qq.adapters.FenleiAdapter;

/**
 * Created by Administrator on 2017/6/26.
 */
public class ClassfiyFranment extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private ListView fenlei_lv;
    private ArrayList<String> data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.fragment_fenlei_layout,container,false);
            initView(view);
        }
        return view;
    }

    private void initView(View v) {
        fenlei_lv= (ListView) v.findViewById(R.id.fenlei_lv);
        initData();
    }

    private void initData() {
        String [] goodsName={"时尚影音","耳机","MP3/MP4","数码相框","数码摄影","潮流女包","女装","办公"};
        data=new ArrayList<String>();
        for (int i=0;i<goodsName.length;i++){
            data.add(goodsName[i]);
        }
        FenleiAdapter adapter=new FenleiAdapter(getActivity(),data);
        fenlei_lv.setAdapter(adapter);
        fenlei_lv.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup)view.getParent()).removeView(view);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(getActivity(), GoodsFenlei.class);
        startActivity(intent);
    }
}
