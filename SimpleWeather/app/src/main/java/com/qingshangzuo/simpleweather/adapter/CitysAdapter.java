package com.qingshangzuo.simpleweather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import com.qingshangzuo.simpleweather.R;




public class CitysAdapter extends RecyclerView.Adapter<CitysAdapter.ViewHolder> {

    private ArrayList<String> citys;
    private Context mContext;
    private OnItemClick mOnItemClick;

    public CitysAdapter(ArrayList<String> citys, Context parentContext) {
        this.citys = citys;
        mContext = parentContext;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public interface OnItemClick {
        void onClick(String city, int position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layout;

        private TextView textView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.city_layout);
            textView = itemView.findViewById(R.id.city);
        }
    }

    @NonNull
    @Override
    public CitysAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.city_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitysAdapter.ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(citys.get(position));
        viewHolder.layout.setOnClickListener(v -> mOnItemClick.onClick(citys.get(position), position));
    }

    @Override
    public int getItemCount() {
        return citys.size();
    }
}
