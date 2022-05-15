package user.interfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicesystem.R;

import user.application.FragmentList;
import user.application.FragmentProject;
import user.application.FragmentRequest;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment=null;
    private FragmentList fragmentList =null;
    private FragmentRequest fragmentRequest=null;
    private String id,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        id = getIntent().getStringExtra("id");
        state = getIntent().getStringExtra("state");

        switchFragment(1);

        btn1 = findViewById(R.id.user_btn1);
        btn2 = findViewById(R.id.user_btn2);
        btn1.setText("服务列表");
        btn2.setText("请求管理");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.user_btn1:
                switchFragment(1);
                break;
            case R.id.user_btn2:
                switchFragment(2);
                break;
        }
    }

    private void switchFragment(int choose) {
        fragmentManager =getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("state",state);
        switch (choose)
        {
            case 1:
                fragmentList = new FragmentList();
                fragment = fragmentList;
                break;
            case 2:
                fragmentRequest = new FragmentRequest();
                fragment = fragmentRequest;
                break;
        }
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.user_fragment,fragment);
        fragmentTransaction.commit();

    }

}