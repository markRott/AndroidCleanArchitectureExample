package com.stdmar.fcleanarchprj.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by sma on 10.09.17.
 */

public abstract class BaseRecyclerAdapter<Item, Holder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<Holder> {

    private Context context;
    private List<Item> data;
    protected IRecyclerItemTouchListener<Item> itemTouchListener;

    public BaseRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setItemTouchListener(IRecyclerItemTouchListener<Item> itemTouchListener) {
        this.itemTouchListener = itemTouchListener;
    }

    public void setData(@NonNull List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(Item data) {
        this.data.add(data);
        notifyDataSetChanged();
    }

    public void addData(@NonNull List<Item> newData, boolean addToStart) {
        if (newData.isEmpty()) return;

        int newDataSize = newData.size();
        if (addToStart) {
            this.data.addAll(0, newData);
            notifyItemRangeInserted(0, newDataSize);
        } else {
            int previousIndex = this.data.size() - 1;
            this.data.addAll(newData);
            if (previousIndex < 0) {
                //Previous list was empty, refresh all set
                notifyDataSetChanged();
            } else {
                notifyItemRangeInserted(previousIndex + 1, newDataSize);
            }
        }
    }

    public void addAllData(@NonNull List<Item> newData) {
        this.data.addAll(newData);
    }

    public List<Item> getData() {
        return data;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Item getItemByPosition(int position) {
        return data.get(position);
    }

    public BaseRecyclerAdapter<Item, Holder> clear() {
        data.clear();
        return this;
    }

    public void setupItemTouchListener(View view, final int position, final Item object) {
        if (itemTouchListener == null) return;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemTouchListener.onTouch(position, object);
            }
        });
    }

    public Context getContext() {
        return context;
    }
}
