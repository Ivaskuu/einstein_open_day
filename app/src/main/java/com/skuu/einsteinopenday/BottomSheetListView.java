package com.skuu.einsteinopenday;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by Adrian on 18/11/2017.
 */

public class BottomSheetListView extends ListView {
    public BottomSheetListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view = getChildAt(getChildCount() - 1);

        int diffBottom = (view.getBottom() - (getHeight() + getScrollY()));
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            if (diffBottom == 0) {
                return false;
            }
        }

        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (canScrollVertically(this)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean canScrollVertically(AbsListView absListView) {

        boolean canScroll = false;

        if (absListView != null && absListView.getChildCount() > 0) {

            boolean isOnTop = absListView.getFirstVisiblePosition() != 0 || absListView.getChildAt(0).getTop() != 0;
            boolean isAllItemsVisible = isOnTop && getLastVisiblePosition() == absListView.getChildCount();

            if (isOnTop || isAllItemsVisible)
                canScroll = true;
        }

        return canScroll;
    }
}