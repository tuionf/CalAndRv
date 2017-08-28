package com.example.tuionf.calandrv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView historyRecycler;
    private HistoryAdapter historyAdapter;
    private ArrayList<PomodoroHistory> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        historyRecycler = (RecyclerView) findViewById(R.id.history_recycler);

        //设置布局管理器
        historyRecycler.setLayoutManager(new LinearLayoutManager(this));

//        BaseQuickAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view, mDataList);
//        homeAdapter.openLoadAnimation();

        historyAdapter = new HistoryAdapter(MainActivity.this,mDataList);
//        historyRecycler.addItemDecoration(new GroupItemDecoration(mDataList));
        historyRecycler.addItemDecoration(new TestItemDecoration(mDataList));
        historyRecycler.setAdapter(historyAdapter);
    }

    private void initData() {

        mDataList = new ArrayList<>();
        mDataList.clear();
        mDataList.add(new PomodoroHistory(true,"08月24日","星期四"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava1")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava11")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava111")));

        mDataList.add(new PomodoroHistory(true,"08月25日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava2")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava12")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava112")));

        mDataList.add(new PomodoroHistory(true,"08月26日","星期六"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava23")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava123")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava1123")));

        mDataList.add(new PomodoroHistory(true,"08月27日","星期四"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava1")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava11")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava111")));

        mDataList.add(new PomodoroHistory(true,"08月28日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro(false)));

        mDataList.add(new PomodoroHistory(true,"08月29日","星期六"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava23")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava123")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava1123")));

        mDataList.add(new PomodoroHistory(true,"08月30日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro(false)));
//
        mDataList.add(new PomodoroHistory(true,"08月31日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro(false)));

        mDataList.add(new PomodoroHistory(true,"08月24日","星期四"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava1")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava11")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava111")));

        mDataList.add(new PomodoroHistory(true,"08月25日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava2")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava12")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava112")));

        mDataList.add(new PomodoroHistory(true,"08月26日","星期六"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava23")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava123")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava1123")));

        mDataList.add(new PomodoroHistory(true,"08月27日","星期四"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava1")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava11")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava111")));

        mDataList.add(new PomodoroHistory(true,"08月28日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro(false)));

        mDataList.add(new PomodoroHistory(true,"08月29日","星期六"));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Java","Rxjava23")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava123")));
        mDataList.add(new PomodoroHistory(new Pomodoro("06:00","07:00","Android","Rxjava1123")));

        mDataList.add(new PomodoroHistory(true,"08月30日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro(false)));
//
        mDataList.add(new PomodoroHistory(true,"08月31日","星期五"));
        mDataList.add(new PomodoroHistory(new Pomodoro(false)));

    }
}
