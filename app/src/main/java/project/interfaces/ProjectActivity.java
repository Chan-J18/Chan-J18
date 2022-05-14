package project.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicesystem.R;

import project.domain.model.entity.project;
import project.infrastructure.db.Dao.DaoProject;
import project.infrastructure.db.convert.convert_pro;

public class ProjectActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName,edtIntroduce,edtContent,edtTimetable;
    private TextView tvId;
    private Button btnChange,btnDelete;
    private Spinner spinner;
    private project pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        //信息传输
        Intent intent =getIntent();
        pro=  convert_pro.getPmsg(intent.getSerializableExtra("Pmsg"));
        //得到完整project信息
        pro = convert_pro.getPro(pro,intent.getSerializableExtra("Umsg"),getApplicationContext());

        setView();
        btnDelete.setOnClickListener(this);
        btnChange.setOnClickListener(this);
    }

    private void setView()
    {
        tvId =findViewById(R.id.pro_detail_tvid) ;
        btnChange =findViewById(R.id.pro_detail_btnChange);
        btnDelete =findViewById(R.id.pro_detail_btnDelete);
        edtName = findViewById(R.id.pro_detail_edtname);
        edtIntroduce =findViewById(R.id.pro_detail_edtintroduce);
        edtContent =findViewById(R.id.pro_detail_edtcontent);
        edtTimetable =findViewById(R.id.pro_detail_edttimetable);
        spinner = findViewById(R.id.pro_detail_spinner);

        //设置
        tvId.setText(pro.getPid());
        btnChange.setText("修改");
        btnDelete.setText("删除");
        edtName.setText(pro.getPname());
        edtIntroduce.setText(pro.getPintroduce());
        edtContent.setText(pro.getPcontent());
        edtTimetable.setText(pro.getWorktime());
        String type =pro.getPtype();
        if(type.equals("全部")) spinner.setSelection(0);
        else if(type.equals("工作类")) spinner.setSelection(1);
        else if(type.equals("生活类")) spinner.setSelection(2);
        else if(type.equals("学习类")) spinner.setSelection(3);
        else if(type.equals("其他")) spinner.setSelection(4);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.pro_detail_btnDelete:

                break;
            case R.id.pro_detail_btnChange:
                String state = pro.getPstate();
                if(state.equals("finish"))//项目已接受
                {
                    Toast.makeText(getApplicationContext(),"项目已接受,不可更改!",Toast.LENGTH_SHORT).show();
                }else if(state.equals("work"))//项目仍未接受处于发布状态
                {
                    DaoProject daoProject = new DaoProject(getApplicationContext());
                    daoProject.updateProject(pro.getPid(),getContent(),getTime());
                }
                break;
        }
    }

    public ContentValues getContent()
    {
        ContentValues values = new ContentValues();
        String pname = edtName.getText().toString();
        String pintroduce = edtIntroduce.getText().toString();
        String pcontent = edtContent.getText().toString();

        values.put("pname",pname);
        values.put("pintroduce",pintroduce);
        values.put("pcontent",pcontent);
        return values;
    }

    public String getTime()
    {
       return edtTimetable.getText().toString();
    }

}