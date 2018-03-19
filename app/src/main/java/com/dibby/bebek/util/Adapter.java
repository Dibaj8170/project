package com.dibby.bebek.util;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dibby.bebek.R;

/**
 * Created by dibby on 09/03/2018.
 */

public class Adapter extends PagerAdapter {

    public Context context;

    private int[] sliderImagesId = new int[]{
            R.drawable.bebek, R.drawable.telur_mateng, R.drawable.sawah,
            R.drawable.putih, R.drawable.kuning
    };

    public Adapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[position]);
        ((ViewPager) container).addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        ((ViewPager) container).removeView((ImageView) obj);
    }
}
