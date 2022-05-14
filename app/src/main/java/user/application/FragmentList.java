package user.application;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.servicesystem.R;

import java.util.List;

import request.domain.entity.request;
import user.domain.model.Service.ProjectService;
import user.domain.model.Service.RequestService;
import user.domain.model.entity.ListBean;

public class FragmentList extends Fragment implements AdapterView.OnItemSelectedListener {

    private String type ;
    private Spinner spinner;
    private RecyclerView list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_layout,container,false);
        //设置spinner
        spinner = v.findViewById(R.id.spn_classify);
        list = v.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.array_spinner, android.R.layout.simple_spinner_item);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将数据绑定到Spinner视图上
        spinner.setAdapter(adapter);
        //添加条目被选中监听器
        spinner.setOnItemSelectedListener(this);

        MyAdapter myAdapter = new MyAdapter();
        if(type.equals("自由职业者"))
        {
            List<request> l = new RequestService(getContext()).getAll();
            myAdapter.setReqMsg(l);
            myAdapter.setState("Reqslist");
        }else if(type.equals("客户"))
        {
            List<ListBean> l = new ProjectService(getContext()).getAll();
            myAdapter.setProMsg(l);
            myAdapter.setState("Proslist");
        }
        myAdapter.setContext(getContext());
        list.setAdapter(myAdapter);
        return v;
    }

    public void setType(String  type)
    {
        this.type = type;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spn =(Spinner) adapterView;
        String item = (String)spn.getItemAtPosition(i);
        if(type.equals("客户"))
            setProSpinner(item);
        else if(type.equals("自由职业者"))
            setReqSpinner(item);
    }

    public void setProSpinner(String item)
    {
        if(item.equals("全部"))
        {
            //显示全部内容不管类别
            MyAdapter myAdapter = new MyAdapter();
            List<ListBean> proslist = new ProjectService(getContext()).getAll();
            myAdapter.setProMsg(proslist);
            myAdapter.setState("Proslist");
            list.setAdapter(myAdapter);

        }else if(item.equals("工作类"))
        {

        }else if(item.equals("生活类"))
        {

        }else if(item.equals("学习类"))
        {

        }else if(item.equals("其他"))
        {

        }
    }
    public void setReqSpinner(String item)
    {
        if(item.equals("全部"))
        {
            //显示全部内容不管类别
            MyAdapter myAdapter = new MyAdapter();
            List<request> reqslist = new RequestService(getContext()).getAll();
            myAdapter.setReqMsg(reqslist);
            myAdapter.setState("Reqslist");
            list.setAdapter(myAdapter);

        }else if(item.equals("工作类"))
        {

        }else if(item.equals("生活类"))
        {

        }else if(item.equals("学习类"))
        {

        }else if(item.equals("其他"))
        {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
