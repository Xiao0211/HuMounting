package com.hyt.yoodao.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View mTopView;
    private View mStickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopView = findViewById(R.id.tv_top_view);
        mStickView = findViewById(R.id.tv_stick_view);
        MyScrollView mScrollView = findViewById(R.id.scrollView);


        mScrollView.setScrollViewListener(new MyScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
                //y:scrollview滚动的高度
                if (y > mTopView.getHeight()) {
                    mStickView.setVisibility(View.VISIBLE);
                } else {
                    mStickView.setVisibility(View.GONE);
                }
            }
        });


    }

}
