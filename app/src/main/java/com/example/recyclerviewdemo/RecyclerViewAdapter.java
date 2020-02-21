package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wade on 2020/2/1.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<String> mImgText = new ArrayList<>();
    private List<Integer> mImgs = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(List<String> mImgText, List<Integer> mImgs, Context mContext){
        this.mImgText = mImgText;
        this.mImgs = mImgs;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mRelativeLayout.setBackgroundColor(mImgs.get(position));
        Glide.with(mContext)
                .load(R.drawable.ic_bubble_chart_black_24dp)
                .error(R.mipmap.ic_launcher)
                .into(holder.mImgView);
        holder.mTextView.setText(mImgText.get(position));
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,mImgText.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImgText.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mRelativeLayout;
        ImageView mImgView;
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRelativeLayout = itemView.findViewById(R.id.mRelativeLayout);
            mImgView = itemView.findViewById(R.id.mImgView);
            mTextView = itemView.findViewById(R.id.mTextView);
        }
    }
}
