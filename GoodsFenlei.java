package chap.lang.com.qq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;
import chap.lang.com.qq.fragments.PopularityFranment;
import chap.lang.com.qq.fragments.PriceFranment;
import chap.lang.com.qq.fragments.SalesFranment;

/**
 * Created by Administrator on 2017/6/30.
 */
public class GoodsFenlei extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
//    private ListView gooods_lv;
//    private ArrayList<HashMap<String,Object>> listdata;
//    private int[]imgId={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.j};
    //文字测试
     private ViewPager fenleiVg;
    private List<Fragment> fragment;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodefenlei);
        initView();
    }

    private void initView() {
        rg= (RadioGroup) findViewById(R.id.goods_rg);
        fenleiVg= (ViewPager) findViewById(R.id.goodsfenlei_vg);
        findViewById(R.id.goods_price_rb).setOnClickListener(this);
        findViewById(R.id.goods_sales_rb).setOnClickListener(this);
        findViewById(R.id.goods_shelves_rb).setOnClickListener(this);
        findViewById(R.id.goods_popularity_rb).setOnClickListener(this);
        initData();
        fenleiVg.setAdapter(new FragmentPagerAdapter(this.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }
        });
        fenleiVg.setOnPageChangeListener(this);
        rg.check(R.id.goods_price_rb);
    }

   private void initData() {
       fragment=new ArrayList<Fragment>();
       fragment.add(new PriceFranment());
       fragment.add(new SalesFranment());
       fragment.add(new PopularityFranment());
       fragment.add(new SalesFranment());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.goods_price_rb:
                fenleiVg.setCurrentItem(0,true);
                break;
            case R.id.goods_sales_rb:
                fenleiVg.setCurrentItem(1,true);
                break;
            case R.id.goods_popularity_rb:
                fenleiVg.setCurrentItem(2,true);
                break;
            case R.id.goods_shelves_rb:
                fenleiVg.setCurrentItem(3,true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
     switch (position){
         case 0:
             rg.check(R.id.goods_price_rb);
             break;
         case 1:
             rg.check(R.id.goods_sales_rb);
             break;
         case 2:
             rg.check(R.id.goods_popularity_rb);
             break;
         case 3:
             rg.check(R.id.goods_shelves_rb);
             break;
     }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
