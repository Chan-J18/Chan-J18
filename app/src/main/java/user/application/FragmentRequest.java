package user.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesystem.R;

import java.io.Serializable;
import java.util.List;

import request.domain.entity.request;
import request.interfaces.CreateReqActivity;
import user.domain.model.Service.RequestService;

public class FragmentRequest extends Fragment implements View.OnClickListener {

    private String id,state;
    private RecyclerView recyclerView;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_request,container,false);
        id = getArguments().getString("id");
        state=getArguments().getString("state");

        button = v.findViewById(R.id.pro_btn);
        recyclerView = v.findViewById(R.id.pro_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<request> list = new RequestService(getContext()).get(id);
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setReqMsg(list);
        myAdapter.setMsg(id,state);
        myAdapter.setContext(getContext());
        recyclerView.setAdapter(myAdapter);
        button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), CreateReqActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("id",(Serializable) id);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
