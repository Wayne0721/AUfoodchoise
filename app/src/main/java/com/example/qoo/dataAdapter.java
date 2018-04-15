package com.example.qoo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Qoo on 2018/1/30.
 */


public class dataAdapter extends RecyclerView.Adapter<dataAdapter.ViewHolder> {
    private ArrayList<Data> datalist;
    public dataAdapter(ArrayList<Data> dataslist) {
        this.datalist = datalist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView storenameTextView;
        private final TextView priceTextView;
        private final TextView nameTextView;
        private final TextView typeTextView;
        private final TextView styleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            storenameTextView = (TextView) itemView.findViewById(R.id.col_storename);
            priceTextView = (TextView) itemView.findViewById(R.id.col_price);
            nameTextView = (TextView) itemView.findViewById(R.id.col_name);
            typeTextView = (TextView) itemView.findViewById(R.id.col_type);
            styleTextView = (TextView) itemView.findViewById(R.id.col_style);
        }
        public void setValues(Data data){
            storenameTextView.setText(data.getStorename());
            priceTextView.setText(data.getPrice());
            nameTextView.setText(data.getName());
            typeTextView.setText(data.getType());
            styleTextView.setText(data.getStyle());
        }
    }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            View view = LayoutInflater.from(context).inflate(R.layout.row_searchresult, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Log.d("DATAS",position+"");
            Data data = datalist.get(position);
            holder.setValues(data);
        }

        @Override
        public int getItemCount() {
            return datalist == null ? 0 : datalist.size();
        }
}
