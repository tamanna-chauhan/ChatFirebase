package com.acadview.firebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{

    Context context;
    private ArrayList<MessageModel> msgList= null;

    public MessageAdapter(Context context){this.context = context;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String [] name = msgList.get(position).getUserName().split(" ");
        holder.idTV.setText(name[0]);
        holder.messageTV.setText(msgList.get(position).getUserMessage());

        Glide.with(context).load(msgList.get(position).getUserImg()).into(holder.idImg);

    }

    @Override
    public int getItemCount() {
        return msgList == null ? 0 : msgList.size();
    }

    public void swap(ArrayList<MessageModel> messageData) {

        this.msgList = messageData;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idTV,messageTV;
        ImageView idImg;

        public ViewHolder(View itemView) {
            super(itemView);

            idTV = itemView.findViewById(R.id.idTextView);
            messageTV = itemView.findViewById(R.id.messageTextView);
            idImg = itemView.findViewById(R.id.idImageView);

        }
    }
}
