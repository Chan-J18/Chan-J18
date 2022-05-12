package com.example.servicesystem.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.servicesystem.R;

import user.interfaces.FreeWorkerActivity;
import user.interfaces.UserActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button btnLogin,btnRegister;
    private Spinner spinner;
    private EditText edtId,edtPw;
    private int type = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.main_edt_id);
        edtPw = findViewById(R.id.main_edt_pw);
        spinner =findViewById(R.id.main_spinner);
        btnLogin = findViewById(R.id.main_btn_login);
        btnRegister = findViewById(R.id.main_btn_register);
        btnLogin.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {

        String id = edtId.getText().toString();
        String pw = edtPw.getText().toString();
        switch (view.getId())
        {
            case R.id.main_btn_login:
                //验证 错误error() return
                Intent intent=null;
                switch (type)
                {
                    case 0:
                        intent = new Intent(MainActivity.this, FreeWorkerActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, UserActivity.class);
                        break;
                }
                intent.putExtra("id",id);
                startActivity(intent);
                break;
            case R.id.main_btn_register:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spn = (Spinner)adapterView;
        String item = (String) spn.getItemAtPosition(i);
        if(item.equals("客户"))   type = 1;
        else if(item.equals("自由职业者")) type = 0;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}