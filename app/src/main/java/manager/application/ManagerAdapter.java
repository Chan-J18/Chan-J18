package manager.application;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

import user.domain.model.entity.ListBean;

public class ManagerAdapter extends RecyclerView.Adapter<ManagerAdapter.MyViewHolder> {

    private List<ListBean> proMsg;
    private static setOnClickListener msetOnClickListener;

    public void  setItemClickListener(setOnClickListener s1)
    {
        msetOnClickListener = s1;
    }


    interface setOnClickListener
    {
        void OnClick(Bundle bundle);
    }

    public void setProMsg(List<ListBean> l){
        proMsg = l;}

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
                        bundle.putSerializable("Pmsg",(Serializable) proMsg.get(position));
                        msetOnClickListener.OnClick(bundle);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        int num = 0;
        num = proMsg.size();
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
