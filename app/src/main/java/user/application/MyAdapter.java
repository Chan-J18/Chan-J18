package user.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesystem.R;

import java.io.Serializable;
import java.util.List;

import contract.interfaces.ContractActivity;
import project.interfaces.ProjectActivity;
import request.domain.entity.request;
import request.interfaces.RequestActivity;
import user.domain.model.Service.RequestService;
import user.domain.model.entity.ListBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ListBean> proMsg;
    private List<request> reqMsg;
    private String id,state;
    private static setOnClickListener msetOnClickListener;

    public void  setItemClickListener(setOnClickListener s1)
    {
        msetOnClickListener = s1;
    }


    interface setOnClickListener
    {
        void OnClick(Bundle bundle);
    }


    public void setMsg(String uid,String ustate)
    {
        id = uid;state=ustate;
    }
    public void setState(String state)
    {
        this.state = state;
    }


    public void setProMsg(List<ListBean> l){
        proMsg = l;}

    public void setReqMsg(List<request> l){
        reqMsg = l;}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false));
        return  holder;
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(proMsg !=null) {
            holder.name.setText(proMsg.get(position).getPro_name());
            holder.introduce.setText(proMsg.get(position).getPro_introduce());
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(msetOnClickListener!=null)
                    {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("state",state);
                        bundle.putSerializable("Umsg",(Serializable) id);
                        bundle.putSerializable("Pmsg",(Serializable) proMsg.get(position));
                        msetOnClickListener.OnClick(bundle);
                    }
                }
            });
        }else if(reqMsg!=null)
        {
            holder.name.setText(reqMsg.get(position).getRname());
            holder.introduce.setText(reqMsg.get(position).getRintroduce());
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(msetOnClickListener!=null)
                    {
                        Bundle bundle =new Bundle();
                        bundle.putSerializable("state",state);
                        bundle.putSerializable("Umsg",(Serializable) id);
                        bundle.putSerializable("Rmsg",(Serializable) reqMsg.get(position));
                        msetOnClickListener.OnClick(bundle);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        int num = 0;
        if(state.equals("Proslist")||state.equals("自由职业者")) {
            num = proMsg.size();
        }else if(state.equals("Reqslist")||state.equals("客户")){
            num = reqMsg.size();
        }

        return  num;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView introduce;
        LinearLayout layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recyc_tv_name);
            introduce = itemView.findViewById(R.id.recyc_tv_introduce);
            layout = itemView.findViewById(R.id.adapter_ll);
        }

    }
}
