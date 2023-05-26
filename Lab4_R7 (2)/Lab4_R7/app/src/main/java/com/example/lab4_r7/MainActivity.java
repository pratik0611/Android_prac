package com.example.lab4_r7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name=findViewById(R.id.editTextTextPersonName);
        EditText pass=findViewById(R.id.editTextTextPassword);
        EditText repass=findViewById(R.id.editTextTextPassword2);
        RadioGroup gender=findViewById(R.id.radioGroup);
        Spinner subject=findViewById(R.id.spinner);
        Button reg=findViewById(R.id.button);
        Intent intent= new Intent(MainActivity.this,ShowActivity.class);

        ArrayList<String> sub=new ArrayList<>();
        sub.add("Engineering");
        sub.add("Arts");

        ArrayAdapter<String> subada=new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sub);

        subject.setAdapter(subada);

        subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    intent.putExtra("sub",sub.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selid=radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton=findViewById(selid);
                intent.putExtra("gend",radioButton.getText().toString());
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("name",name.getText().toString());
                startActivity(intent);
            }
        });
    }
}