package com.example.myrecyclerviewtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private RecyclerView recyclerView ;
  private MyRecAdapter adapter;
  private List<Model> list;
  private Button mSave;
  private int editPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSave = findViewById(R.id.btn_save);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddAndEditModel.class);
                startActivityForResult(intent, 100);

            }
        });
        initRecView();
        loadData();
    }

    private void loadData() {
        if (list==null){
            list = new ArrayList<>();
            adapter.add(new Model(1,"John" , "Bose"));
            adapter.add(new Model(2,"Jena","Bose"));
            adapter.add(new Model(3,"July" , "Bose"));
            adapter.add(new Model(4,"Derek",  "Dow"));
            adapter.add(new Model(5,"John","Dow"));
            adapter.add(new Model(6,"Dr" , "Dow"));
        }
    }

    private void initRecView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        MyRecAdapter.ItemModelClickListener itemModelClickListener = new MyRecAdapter.ItemModelClickListener() {
            @Override
            public void clickItemModels(Model model,int position) {
                //Toast.makeText(MainActivity.this, "user" +" "+model.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,AddAndEditModel.class);
                intent.putExtra("model",model);
                editPosition = position;
                startActivityForResult(intent, 200);

            }
        };
        adapter = new MyRecAdapter(itemModelClickListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){

            Model model = (Model) data.getSerializableExtra("model");
            adapter.add(model);
        }
        else if(requestCode == 200){

            Model model = (Model) data.getSerializableExtra("model");
            adapter.update(model,editPosition);
            editPosition =0;
        }
    }
}
