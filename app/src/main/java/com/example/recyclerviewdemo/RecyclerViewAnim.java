package com.example.recyclerviewdemo;

import android.view.animation.AnimationUtils;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Wade on 2020/2/21.
 */
public class RecyclerViewAnim extends DefaultItemAnimator {

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        holder.itemView.setAnimation(
                AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.viewholder_remove)
        );
        return super.animateRemove(holder);
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        holder.itemView.setAnimation(
                AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.viewholder_add)
        );
        return super.animateAdd(holder);
    }

    @Override
    public long getAddDuration() {
        return 1000;
    }

    @Override
    public long getRemoveDuration() {
        return 1000;
    }
}
