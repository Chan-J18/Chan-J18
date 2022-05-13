package user.application;



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

import java.util.List;

import user.domain.model.entity.ListBean;
import user.domain.model.Service.ProjectService;

public class FragmentProject extends Fragment {

    private String id;
    private RecyclerView recyclerView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_project,container,false);
        id = getArguments().getString("id");

        button = v.findViewById(R.id.pro_btn);
        recyclerView = v.findViewById(R.id.pro_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ListBean> list = new ProjectService(getContext()).get(id);
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setListMsg(list);
        myAdapter.setId(id);
        recyclerView.setAdapter(myAdapter);
        return v;
    }

}
