package com.example.tuionf.calandrv;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by tuion on 2017/8/28.
 */

public class GroupItemDecoration extends RecyclerView.ItemDecoration {

    private List<PomodoroHistory> mList = null;
    private int mHeight = 5;
    private Paint mPaint;
    private Rect mBounds;//用于存放测量文字Rect

    public GroupItemDecoration(List<PomodoroHistory> mList) {
        this.mList = mList;
        mPaint = new Paint();
        mBounds = new Rect();
        mPaint.setTextSize(12);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            int position = params.getViewLayoutPosition();

            if (position == 0 || mList.get(position).isFirst()) {//等于0肯定要有title的
                drawTitleArea(c, left, right, child, params, position);

            } else {//其他的通过判断

            }
        }
    }

    private void drawTitleArea(Canvas c, int left, int right, View child, RecyclerView.LayoutParams params, int position) {//最先调用，绘制在最下层
        mPaint.setColor(Color.BLUE);
        c.drawRect(left, child.getTop() - params.topMargin - mHeight, right, child.getTop() - params.topMargin, mPaint);
        mPaint.setColor(Color.BLACK);
        mPaint.getTextBounds(mList.get(position).getDay(), 0, mList.get(position).getDay().length(), mBounds);
        c.drawText(mList.get(position).getDay(), child.getPaddingLeft(), child.getTop() - params.topMargin - (mHeight / 2 - mBounds.height() / 2), mPaint);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int pos = ((LinearLayoutManager)(parent.getLayoutManager())).findFirstVisibleItemPosition();
        View child = parent.findViewHolderForLayoutPosition(pos).itemView;//出现一个奇怪的bug，有时候child为空，所以将 child = parent.getChildAt(i)。-》 parent.findViewHolderForLayoutPosition(pos).itemView
        if (pos == 0 || mList.get(pos).isFirst()) {
            String text = mList.get(pos).getDay();
            mPaint.setColor(Color.BLUE);
            c.drawRect(parent.getPaddingLeft(), parent.getPaddingTop(), parent.getRight() - parent.getPaddingRight(), parent.getPaddingTop() + mHeight, mPaint);
            mPaint.setColor(Color.BLACK);
            mPaint.getTextBounds(text, 0, text.length(), mBounds);
            c.drawText(text, child.getPaddingLeft(),
                    parent.getPaddingTop() + mHeight - (mHeight / 2 - mBounds.height() / 2),
                    mPaint);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        if (mList.get(pos).isFirst() || pos == 0){
            outRect.top = mHeight;
        }else {
            outRect.top = 0;
        }
    }
}
