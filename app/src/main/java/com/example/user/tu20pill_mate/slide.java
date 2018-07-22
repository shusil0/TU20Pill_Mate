package com.example.user.tu20pill_mate;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class slide extends PagerAdapter {

    Context context;
    LayoutInflater inflater;


    //Images
    public int[] image_list = {R.drawable.logo, R.drawable.alarm1, R.drawable.doctor, R.drawable.thumbs_up};

    // Titles list
    public String[] title_list = {"Welcome", "Welcome", "Welcome", "Welcome"};

    // Descriptions
    public String[] descrip_list = {"You can set a timer for your medication", "You can enable notifications to remind you", "You can get advice from our doctors", "Let's Start"};

    // Background color list
    public int[] background_list = {Color.rgb(55, 55, 111), Color.rgb(29, 125, 152), Color.rgb(10, 119, 219), Color.rgb(1, 188, 212)};


    public String[] btn_list = {"Get Started", "Get Started", "Get Started", "Get Started"};


    public slide(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return title_list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (RelativeLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_slide, container, false);
        RelativeLayout layoutslide = (RelativeLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle = (TextView) view.findViewById(R.id.txtTitle);
        TextView description = (TextView) view.findViewById(R.id.txtDescription);
        Button btnSlide = (Button) view.findViewById(R.id.getStarted);
        layoutslide.setBackgroundColor(background_list[position]);
        imgslide.setImageResource(image_list[position]);
        txttitle.setText(title_list[position]);
        btnSlide.setText(btn_list[position]);
        description.setText(descrip_list[position]);

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }


}
