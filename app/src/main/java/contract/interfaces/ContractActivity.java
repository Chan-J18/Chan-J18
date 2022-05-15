package contract.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.servicesystem.R;

public class ContractActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        imageView = findViewById(R.id.contract_iv);
        button = findViewById(R.id.contract_btn_sure);

        imageView.setImageResource(R.drawable.ic_contract);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"合同已生效！",Toast.LENGTH_SHORT).show();
    }
}