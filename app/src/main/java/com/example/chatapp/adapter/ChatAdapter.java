package com.example.chatapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.Model.MessagesModel;
import com.example.chatapp.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessagesModel> messagesModels;
    Context context;
    int SENDER_VIEW_TYPE=1;
    int RECEIVER_VIEW_TYPE=2;

    public ChatAdapter(ArrayList<MessagesModel> messagesModels, Context context) {
        this.messagesModels = messagesModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==SENDER_VIEW_TYPE){
            View view= LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return new senderViewHolder(view);
        }
        else {
            View view= LayoutInflater.from(context).inflate(R.layout.sample_reciver,parent,false);
            return new receiverViewHolder(view);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(messagesModels.get(position).getMid().equals(FirebaseAuth.getInstance().getUid())){
            return SENDER_VIEW_TYPE;
        }
        else {
            return RECEIVER_VIEW_TYPE;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MessagesModel messagesModel= messagesModels.get(position);

            if (holder.getClass()==senderViewHolder.class){
                ((senderViewHolder)holder).senderMsg.setText(messagesModel.getMessage());
                ((senderViewHolder)holder).senderTime.setText(messagesModel.getTimeStamp().toString());
            }
            else {
                ((receiverViewHolder)holder).receiverMsg.setText(messagesModel.getMessage());
                ((receiverViewHolder)holder).receiverTime.setText(messagesModel.getTimeStamp().toString());
            }
    }

    @Override
    public int getItemCount() {
        return messagesModels.size();
    }

    public class receiverViewHolder extends RecyclerView.ViewHolder {

        TextView receiverMsg , receiverTime;
        public receiverViewHolder(@NonNull View itemView) {
            super(itemView);

            receiverMsg=itemView.findViewById(R.id.receiverText);
            receiverTime=itemView.findViewById(R.id.receiverTimer);
        }
    }

    public class senderViewHolder extends RecyclerView.ViewHolder {

        TextView senderMsg , senderTime;
        public senderViewHolder(@NonNull View itemView) {
            super(itemView);
            senderMsg=itemView.findViewById(R.id.senderText);
            senderTime=itemView.findViewById(R.id.sender_Timer);
        }
    }


}
