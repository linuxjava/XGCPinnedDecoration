package com.example.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app.bean.LData;

import java.util.ArrayList;
import java.util.List;

import xgc.free.pinned.decoration.PinnedHeaderDecoration;
import xiao.free.decoration.HorizontalDividerItemDecoration;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SectionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new SectionAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new PinnedHeaderDecoration().registerTypePinnedHeader(LData.ITEM_TYPE_SECTION
                , new PinnedHeaderDecoration.PinnedHeaderCreator() {
                    @Override
                    public boolean create(RecyclerView parent, int adapterPosition) {
                        return true;
                    }
                }));
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .size(1).margin(10, 10).visibilityProvider(mAdapter).build());
        mRecyclerView.setAdapter(mAdapter);

        List<LData> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                datas.add(new LData(LData.ITEM_TYPE_SECTION, "Section " + i / 10));
            } else {
                datas.add(new LData(LData.ITEM_TYPE_DATA, "pos " + i));
            }
        }
        mAdapter.setDatas(datas);
    }


}
