package com.hyt.yoodao.my;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Describe : 带滑动监听的scrollview
 */
public class MyScrollView extends ScrollView {

    public interface ScrollViewListener {
        void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy);
    }

    private ScrollViewListener scrollViewListener = null;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    /**
     * 这里有个问题，滚动视图的setOnScrollChangeListener滚动监听，要求6.0（API23）之后才能用。
     * 解决方法：在6.0以下有onScrollChanged方法，也能监听滚动视图滑动，但是这个方法不能直接调用，
     * 所以要自定义一个继承滚动视图的图，提供一个方法，把onScrollChanged暴露出来。
     */
    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

}
