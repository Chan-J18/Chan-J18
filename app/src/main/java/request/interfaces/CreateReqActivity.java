package request.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.servicesystem.R;

import project.domain.model.entity.project;
import project.infrastructure.db.Dao.DaoProject;
import request.domain.entity.request;
import request.infrastructure.Dao.DaoRequest;

public class CreateReqActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText edtName,edtIntroduce,edtContent,edtTimetable;
    private Button btnCreate;
    private Spinner spinner;
    private request req;
    private String pro_type,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_req);
        id = (String)getIntent().getExtras().getSerializable("id");

        getView();
        btnCreate.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);
    }

    public void getView()
    {
        spinner = findViewById(R.id.pro_new_spinner);
        btnCreate =findViewById(R.id.pro_new_btnCreate);
        edtName = findViewById(R.id.pro_new_edtname);
        edtIntroduce =findViewById(R.id.pro_new_edtintroduce);
        edtContent =findViewById(R.id.pro_new_edtcontent);
        edtTimetable =findViewById(R.id.pro_new_edttimetable);
    }

    public void getData()
    {
        String name = edtName.getText().toString();
        String introduce = edtIntroduce.getText().toString();
        String content = edtContent.getText().toString();
        String type = pro_type;
        if(name==null||introduce==null||content==null)
        {
            Toast.makeText(getApplicationContext(),"项目信息不能为空!",Toast.LENGTH_SHORT).show();
        }else{
            req =new request();
            req.setRname(name);
            req.setRtype(pro_type);
            req.setRintroduce(introduce);
            req.setRcontent(content);
        }
    }

    public void createReq()
    {
        DaoRequest daoRequest = new DaoRequest(getApplicationContext());
        daoRequest.insertRequest(req,id);
        Toast.makeText(getApplicationContext(),"发布成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        getData();
        createReq();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spn = (Spinner)adapterView;
        String item = (String) spn.getItemAtPosition(i);
        pro_type = item;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}