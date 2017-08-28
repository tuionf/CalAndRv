package com.example.tuionf.calandrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tuion on 2017/8/24.
 */

public class HistoryAdapter extends RecyclerView.Adapter {

    private  List<PomodoroHistory> mList = null;
    private  Context mContext;

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_GROUP = 1;


    public HistoryAdapter(Context mContext,List<PomodoroHistory> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }


    @Override
    public int getItemViewType(int position) {
        int viewType;
        if (mList.get(position).isFirst()){
            viewType = TYPE_GROUP;
        }else {
            viewType = TYPE_TEXT;
        }
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = null;
        switch(viewType){
            case TYPE_GROUP:
                myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.history_item_font,null));
            break;
            case TYPE_TEXT:
                myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.history_item_content,null));
                break;
            default:
                break;
        }

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myholder = (MyViewHolder) holder;

        myholder.setData(position,mList.get(position).isFirst());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView startTime;
        private TextView endTime;
        private TextView content;
        private TextView day;
        private TextView weekDay;
        private TextView tag;
        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            startTime = (TextView) itemView.findViewById(R.id.startTime);
            endTime = (TextView) itemView.findViewById(R.id.endTime);
            content = (TextView) itemView.findViewById(R.id.content);
            tag = (TextView) itemView.findViewById(R.id.tag);
            day = (TextView) itemView.findViewById(R.id.day);
            weekDay = (TextView) itemView.findViewById(R.id.weekDay);
        }

        public void setData(int position,boolean isFirst) {
            PomodoroHistory pomodoroHistory = mList.get(position);
            Pomodoro pomodoro = pomodoroHistory.getPomodoro();
            if (isFirst) {
                day.setText(pomodoroHistory.getDay());
                weekDay.setText(pomodoroHistory.getWeekDay());
            }else {
                if(pomodoro.isHasContent()){
                    startTime.setText(pomodoroHistory.getPomodoro().getStartTime());
                    endTime.setText(pomodoroHistory.getPomodoro().getEndTime());
                    content.setText(pomodoroHistory.getPomodoro().getContent());
                    tag.setText(pomodoroHistory.getPomodoro().getTag());
                    view.findViewById(R.id.start_end_time_ll).setVisibility(View.VISIBLE);
                    tag.setVisibility(View.VISIBLE);
                }else {
                    view.findViewById(R.id.start_end_time_ll).setVisibility(View.GONE);
                    tag.setVisibility(View.GONE);
                    content.setText("暂无数据");
                }

            }
        }


    }

    public interface GroupListener {
        Boolean IsGroupFirst(int position);
    }
}
