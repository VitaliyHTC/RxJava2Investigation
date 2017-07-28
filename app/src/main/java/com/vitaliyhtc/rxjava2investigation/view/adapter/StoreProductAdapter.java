package com.vitaliyhtc.rxjava2investigation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vitaliyhtc.rxjava2investigation.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreProductAdapter extends RecyclerView.Adapter<StoreProductAdapter.ViewHolder> {

    private List<String> mItems;

    public StoreProductAdapter() {
        mItems = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(List<String> items) {
        mItems = items;
    }

    public void appendItems(String string) {
        mItems.add(string);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView mTextView;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        void bind(String text) {
            mTextView.setText(text);
        }
    }
}
