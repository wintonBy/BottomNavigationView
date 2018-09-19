package com.winton.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        NavigationView mNV = findViewById(R.id.nv);
        mNV.setBackgroundColor(Color.GRAY);
        List<NavigationView.Model> tabs = new ArrayList<>();
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).title("主页").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).title("tab1").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).title("tab2").build());
        mNV.setItems(tabs);
        mNV.build();
        mNV.check(0);

        mNV.setOnTabSelectedListener(new NavigationView.OnTabSelectedListener() {
            @Override
            public void selected(int i, NavigationView.Model model) {
                Toast.makeText(MainActivity.this,model.getTitle(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void unselected(int i, NavigationView.Model model) {

            }
        });
        mNV.reminder(0,true,"100");
        mNV.reminder(1,true,"10");
        mNV.reminder(2,true,"25");
    }

}
