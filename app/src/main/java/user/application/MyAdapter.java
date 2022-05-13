package user.application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesystem.R;

import java.io.Serializable;
import java.util.List;

import project.interfaces.ProjectActivity;
import user.domain.model.entity.ListBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ListBean> listMsg;
    private Context context;
    private String id;

    public void setId(String uid)
    {
        id = uid;
    }

    public void setContext(Context cont)
    {
        context = cont;
    }

    public void setListMsg(List<ListBean> l){listMsg = l;}
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false));
        return  holder;
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(listMsg!=null) {
            holder.name.setText(listMsg.get(position).getPro_name());
            holder.introduce.setText(listMsg.get(position).getPro_introduce());
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProjectActivity.class);
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("Pmsg",(Serializable) listMsg);
                    bundle.putSerializable("Umsg",(Serializable) id);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listMsg.size();
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
