package com.winton.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.winton.bottomnavigationview.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData(){
        final NavigationView mNV = findViewById(R.id.nv);
        List<NavigationView.Model> tabs = new ArrayList<>();
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_index,R.mipmap.ic_index_unchek).title("主页").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_music,R.mipmap.ic_music_uncheck).title("音乐").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_movie,R.mipmap.ic_movie_unchek).title("电影").build());
        mNV.setItems(tabs);
        mNV.setOnTabSelectedListener(new NavigationView.OnTabSelectedListener() {
            @Override
            public void selected(int i, NavigationView.Model model) {
                ((TextView)findViewById(R.id.tv_select)).setText(model.getTitle());
            }

            @Override
            public void unselected(int i, NavigationView.Model model) {

            }
        });
        mNV.build();
        mNV.reminder(0,true,"99");
        mNV.reminder(1,true,"···");
        mNV.reminder(2,true,"");

        mNV.postDelayed(new Runnable() {
            @Override
            public void run() {
                mNV.reminder(0,false,"");
                mNV.reminder(1,true,"");
                mNV.reminder(2,true,"22");
            }
        },2000);
    }

}
