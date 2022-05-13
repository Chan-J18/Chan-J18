package project.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.servicesystem.R;

import java.util.List;

import project.domain.model.entity.project;
import project.infrastructure.db.convert.convert_pro;

public class ProjectActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName,edtIntroduce,edtContent;
    private TextView tvId;
    private Button btnChange,btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        //信息传输
        Intent intent =getIntent();
        List<project>  list=  convert_pro.getPmsg(intent.getSerializableExtra("Pmsg"));
        //得到完整project信息
        list = convert_pro.getPro(list,intent.getSerializableExtra("Umsg"),getApplicationContext());

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
    }

    @Override
    public void onClick(View view) {

    }
}