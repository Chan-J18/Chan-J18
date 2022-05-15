package manager.interfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.servicesystem.R;

import manager.application.ManagerAdapter;
import user.domain.model.Service.ProjectService;

public class ManagerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        recyclerView = findViewById(R.id.manager_recycler);
        ManagerAdapter adapter = new ManagerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter.setProMsg(new ProjectService(getApplicationContext()).getAll());
        recyclerView.setAdapter(adapter);
    }
}