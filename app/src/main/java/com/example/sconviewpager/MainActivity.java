package com.example.sconviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    MyPagerAdapter myPagerAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        button = findViewById(R.id.button);

        FirsstFragment firsstFragment = new FirsstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThirdFragment thirdFragment = new ThirdFragment();

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        myPagerAdapter.addItem(firsstFragment);
        myPagerAdapter.addItem(secondFragment);
        myPagerAdapter.addItem(thirdFragment);

        pager.setAdapter(myPagerAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });

    }

}
class MyPagerAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> items = new ArrayList<Fragment>();

    public void addItem(Fragment item){
        items.add(item);
    }
    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}