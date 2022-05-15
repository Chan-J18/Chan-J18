package project.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.servicesystem.R;
import com.google.android.material.datepicker.OnSelectionChangedListener;

import project.domain.model.entity.project;
import project.infrastructure.db.Dao.DaoProject;

public class CreateProActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText edtName,edtIntroduce,edtContent,edtTimetable;
    private Button btnCreate;
    private Spinner spinner;
    private project pro;
    private String pro_type,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pro);
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
        String time =edtTimetable.getText().toString() ;
        String type = pro_type;
        if(name==null||introduce==null||content==null||time==null)
        {
            Toast.makeText(getApplicationContext(),"项目信息不能为空!",Toast.LENGTH_SHORT).show();
        }else{
            pro =new project();
            pro.setPname(name);
            pro.setPtype(pro_type);
            pro.setPintroduce(introduce);
            pro.setPcontent(content);
            pro.setWorktime(time);
        }
    }

    public void createPro()
    {
        DaoProject daoProject = new DaoProject(getApplicationContext());
        daoProject.insertProject(pro,id);
        Toast.makeText(getApplicationContext(),"发布成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        getData();
        createPro();
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