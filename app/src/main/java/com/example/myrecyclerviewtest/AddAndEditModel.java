package com.example.myrecyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddAndEditModel extends AppCompatActivity {
    private TextView name, surname;
    private Button add;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_edit_model);
        Intent intent = getIntent();
        name =findViewById(R.id.tv_add_name);
        surname =findViewById(R.id.tv_addsurname);
        add =findViewById(R.id.bt_add);
        if (intent.hasExtra("model")) {
            model = (Model) intent.getSerializableExtra("model");
            initField(model);

        }
        add.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        if (model == null) {
            model = new Model();
        }

        model.setName(name.getText().toString());
        model.setSurName(surname.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("model", model);
        if(model.isState())
        setResult(200, intent);
        else {
            setResult(100, intent);}
        finish();
    }
    });
}

    private void initField(Model model) {

        name.setText( model.getName());
        surname.setText(model.getSurName());

    }
}


