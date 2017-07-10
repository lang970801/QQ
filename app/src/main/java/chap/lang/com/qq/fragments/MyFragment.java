package chap.lang.com.qq.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import chap.lang.com.qq.R;
import chap.lang.com.qq.utils.SPUtils;

/**
 * Created by Administrator on 2017/6/26.
 */
public class MyFragment extends Fragment{
    private View view;
    private TextView userName;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      if(view==null){
          view=inflater.inflate(R.layout.fragment_my_layout,container,false);
          initView(view);

      }
        return view;
    }

    private void initView(View v) {
        String name =(String)SPUtils.get(v.getContext(), "share_data", "account");
        userName= (TextView) v.findViewById(R.id.my_username_tv);
        userName.setText(name);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup)view.getParent()).removeView(view);
    }
}
