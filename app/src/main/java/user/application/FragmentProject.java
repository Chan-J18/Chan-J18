package user.application;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesystem.R;

import java.io.Serializable;
import java.util.List;

import project.interfaces.CreateProActivity;
import user.domain.model.entity.ListBean;
import user.domain.model.Service.ProjectService;

public class FragmentProject extends Fragment implements View.OnClickListener {

    private String id,state;
    private RecyclerView recyclerView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_project,container,false);
        id = getArguments().getString("id");
        state=getArguments().getString("state");

        button = v.findViewById(R.id.pro_btn);
        recyclerView = v.findViewById(R.id.pro_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        button.setOnClickListener(this);
        List<ListBean> list = new ProjectService(getContext()).get(id);
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setProMsg(list);
        myAdapter.setMsg(id,state);
        myAdapter.setContext(getContext());
        recyclerView.setAdapter(myAdapter);
        return v;
    }

    //发布项目
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), CreateProActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("id",(Serializable) id);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
