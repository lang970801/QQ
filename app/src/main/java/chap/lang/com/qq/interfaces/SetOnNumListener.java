package chap.lang.com.qq.interfaces;

import chap.lang.com.qq.ViewHolder;

/**
 * Created by Administrator on 2017/7/3.
 */
public interface SetOnNumListener {
    void onAddNumListener(int price,ViewHolder holder);
    void onSubNumListener(int price,ViewHolder holder);
}
