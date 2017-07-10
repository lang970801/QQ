package chap.lang.com.qq;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
//import android.support.v4.view.ViewPager.onPageChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chap.lang.com.qq.fragments.ClassfiyFranment;
import chap.lang.com.qq.fragments.ShoppingCarFrafement;
import chap.lang.com.qq.fragments.HomeFragment;
import chap.lang.com.qq.fragments.MyFragment;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends FragmentActivity implements OnPageChangeListener,View.OnClickListener {
    private RadioGroup rg;
    private ViewPager pager;
    private List<Fragment> fragment;
    private String flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        flag = getIntent().getStringExtra("flag");
        rg= (RadioGroup) findViewById(R.id.rg);
        pager= (ViewPager) findViewById(R.id.viewpager);
        findViewById(R.id.home).setOnClickListener(this);
        findViewById(R.id.fenlei).setOnClickListener(this);
        findViewById(R.id.gouwuche).setOnClickListener(this);
        findViewById(R.id.my).setOnClickListener(this);

        fragment=new ArrayList<Fragment>();
        fragment.add(new HomeFragment());
        fragment.add(new ClassfiyFranment());
        fragment.add(new ShoppingCarFrafement());
        fragment.add(new MyFragment());

        pager.setAdapter(new FragmentPagerAdapter(this.getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {

                    return fragment.get(position);
                }

                @Override
                public int getCount() {

                    return fragment.size();
                }
        });
        pager.setOnPageChangeListener(this);
        if (flag.equals("LoginActivity")){
            rg.check(R.id.home);
        }else if (flag.equals("ShopingDeteils")){
            rg.check(R.id.gouwuche);
            pager.setCurrentItem(2,true);
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home:
                Toast.makeText(MainActivity.this,"点击了1", LENGTH_SHORT).show();
                pager.setCurrentItem(0,true);
                break;
            case  R.id.fenlei:
                pager.setCurrentItem(1,true);
                break;
            case  R.id.gouwuche:
                pager.setCurrentItem(2,true);
                break;
            case  R.id.my:
                pager.setCurrentItem(3,true);
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        ViewGroup viewGroup= (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
      switch (position){
          case 0:
              rg.check(R.id.home);
              break;
          case 1:
              rg.check(R.id.fenlei);
              break;
          case 2:
              rg.check(R.id.gouwuche);
              break;
          case 3:
              rg.check(R.id.my);
              break;

      }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
