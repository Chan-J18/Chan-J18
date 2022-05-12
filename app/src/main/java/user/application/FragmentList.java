package user.application;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import com.example.servicesystem.R;

public class FragmentList extends Fragment {

    private int type ;
    private Spinner spinner;
    private int[] datas ={R.array.user_spinner,R.array.freework_spinner};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_layout,container,false);
        //设置spinner
        spinner = v.findViewById(R.id.spn_classify);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),datas[type], android.R.layout.simple_spinner_item);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将数据绑定到Spinner视图上
        spinner.setAdapter(adapter);
        //添加条目被选中监听器
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return v;
    }

    public void setType(int  type)
    {
        this.type = type;
    }
}
