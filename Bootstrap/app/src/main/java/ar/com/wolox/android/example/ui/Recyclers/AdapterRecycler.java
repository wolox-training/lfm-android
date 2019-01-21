package ar.com.wolox.android.example.ui.Recyclers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ar.com.wolox.android.R;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.mViewHolder> {
    private ArrayList<String> mList;

    public void setDataSet(ArrayList<String> mData) {
        mList=mData;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder{
        public TextView mText;
        public mViewHolder(TextView V){
            super(V);
            mText=V;
        }
    }
    @NonNull
    @Override
    public AdapterRecycler.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        mViewHolder vh = new mViewHolder(v);
        return vh;
    }


    public void onBindViewHolder(mViewHolder holder, int position) {

    holder.mText.setText(mList.get(position));

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
}
