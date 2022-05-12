package user.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesystem.R;

import java.util.List;

import user.domain.model.entity.ListBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ListBean> listMsg;

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
        }
    }

    @Override
    public int getItemCount() {
        return listMsg.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView introduce;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recyc_tv_name);
            introduce = itemView.findViewById(R.id.recyc_tv_introduce);
        }

    }
}
