package ar.com.wolox.android.example.ui.Recyclers;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ar.com.wolox.android.R;

public class RecyclerActivity extends Activity {

    public android.support.v7.widget.RecyclerView recyclerViewHorizontal;
    private  android.support.v7.widget.RecyclerView.LayoutManager linearLayoutManagerHorizontal;
    private AdapterRecycler mAdapter;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(findViewById(R.id.activity_recycler));
        recyclerViewHorizontal = (android.support.v7.widget.RecyclerView) findViewById(R.id.recycler_horizontal);
        mData=new ArrayList<String>();
        mData.add("s1");
        mData.add("s2");
        mData.add("s3");
        mData.add("s4");
        // use a linear layout manager
        linearLayoutManagerHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewHorizontal.setLayoutManager(linearLayoutManagerHorizontal);

        // specify an adapter (see also next example)
        mAdapter = new AdapterRecycler();
        mAdapter.setDataSet(mData);
        recyclerViewHorizontal.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);

    }
}

