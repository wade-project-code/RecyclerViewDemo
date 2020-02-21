package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wade on 2020/2/1.
 */
public class MainActivity extends AppCompatActivity {
    private List<String> mImgText;
    private List<Integer> mImgs;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter adapter;
    private Button mBtnAdd, mBtnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        initList();

        mBtnAdd = findViewById(R.id.mBtnAdd);
        mBtnRemove = findViewById(R.id.mBtnRemove);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setItemAnimator(new RecyclerViewAnim());
        adapter = new RecyclerViewAdapter(mImgText,mImgs,this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemInserted(1);
            }
        });

        mBtnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.notifyItemRemoved(1);
            }
        });
    }

    private void initList(){
        mImgText = new ArrayList<>();
        mImgs = new ArrayList<>();

        mImgText.add("BLUE");
        mImgs.add(Color.BLUE);

        mImgText.add("BLACK");
        mImgs.add(Color.BLACK);

        mImgText.add("CYAN");
        mImgs.add(Color.CYAN);

        mImgText.add("DKGRAY");
        mImgs.add(Color.DKGRAY);

        mImgText.add("GRAY");
        mImgs.add(Color.GRAY);

        mImgText.add("GREEN");
        mImgs.add(Color.GREEN);

        mImgText.add("LTGRAY");
        mImgs.add(Color.LTGRAY);

        mImgText.add("MAGENTA");
        mImgs.add(Color.MAGENTA);

        mImgText.add("RED");
        mImgs.add(Color.RED);
    }
}
