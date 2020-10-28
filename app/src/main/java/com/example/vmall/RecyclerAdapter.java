package com.example.vmall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
   private List<Goods> goods;
   private Context context;
   private View inflater;
   private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerAdapter(Context context, List<Goods> goods) {
        this.goods = goods;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new MyViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, final int position) {
        Goods good=goods.get(position);
        holder.tvTitle.setText(good.getTitle());
        holder.tvPrice.setText(good.getPrices());
        holder.ivPic.setBackgroundResource(good.getIcon());

        if (onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvPrice;
        ImageView ivPic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tv_title);
            tvPrice=itemView.findViewById(R.id.tv_price);
            ivPic=itemView.findViewById(R.id.iv_pic);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
