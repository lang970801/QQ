package chap.lang.com.qq.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chap.lang.com.qq.R;

/**
 * Created by Administrator on 2017/6/30.
 */
public class PriceFranment extends Fragment{
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null) {
              view=inflater.inflate(R.layout.fragment_price_layout,container,false);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        ((ViewGroup)view.getParent()).removeView(view);
        super.onDestroyView();
    }
}
