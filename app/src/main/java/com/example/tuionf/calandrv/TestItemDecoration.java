package com.example.tuionf.calandrv;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by tuion on 2017/8/28.
 */

public class TestItemDecoration extends RecyclerView.ItemDecoration {

    private static final String TAG = "TestItemDecoration";
    private List<PomodoroHistory> mList = null;
    private Paint mPaint;
    private Paint mGroutPaint;
    private int mHeight = 5;
    private int mGroupHeight = 25;


    public TestItemDecoration(List<PomodoroHistory> mList) {
        this.mList = mList;
        //设置悬浮栏的画笔---mGroutPaint
        mGroutPaint = new Paint();
        mGroutPaint.setColor(Color.BLUE);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Log.e(TAG, "onDraw: " );
        final int left = parent.getLeft();
        final int right = parent.getRight();
        final int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            final View childView = parent.getChildAt(i);
//            final int bottom = childView.getTop();
//            final int top = bottom - mHeight;
//            c.drawRect(left, top, right, bottom, mPaint);
//        }

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        Log.e(TAG, "onDrawOver: " );
//      int itemCount = state.getItemCount();
        final int childCount = parent.getChildCount();
        final int left = parent.getLeft() + parent.getPaddingLeft();
        final int right = parent.getRight() - parent.getPaddingRight();
        String preGroupName;      //标记上一个item对应的Group
        String currentGroupName = "ITEM";       //当前item对应的Group

        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            float top = Math.max(mGroupHeight, view.getTop());//top 决定当前顶部第一个悬浮Group的位置
            int position = parent.getChildAdapterPosition(view);
            preGroupName = currentGroupName;
            currentGroupName = mList.get(position).getDay();

            if (currentGroupName == null || TextUtils.equals(currentGroupName, preGroupName))
                continue;
            int viewBottom = view.getBottom();
            if (position + 1 < childCount) {
                String nextGroupName = mList.get(position + 1).getDay();

                if (!currentGroupName.equals(nextGroupName) && viewBottom < top) {
                    top = viewBottom;
                }

            }
            //根据top绘制group背景
            //根据top绘制group
                c.drawRect(left, top - mGroupHeight, right, top, mGroutPaint);
                Paint.FontMetrics fm = mPaint.getFontMetrics();
                //文字竖直居中显示
                float baseLine = top - (mGroupHeight - (fm.bottom - fm.top)) / 2 - fm.bottom;
                c.drawText(currentGroupName, left , baseLine, mPaint);

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Log.e(TAG, "getItemOffsets: " );
//        outRect.set(30, 10, 20, 50);
        int pos = parent.getChildAdapterPosition(view);
        if (mList.get(pos).isFirst() || pos == 0 ) {
            outRect.set(0, 0, 0, 0);
        }else{
            outRect.set(0, 0, 0, 0);
        }

    }
}
