package com.example.rellayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rellayapp.model.Personne;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView l;
    ArrayAdapter<Personne> ar;
    ArrayList<Personne> listePersonnes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        l=findViewById(R.id.liste);
        Intent intent = getIntent();
        listePersonnes= (ArrayList<Personne>) intent.getSerializableExtra("liste");
        ar=new ArrayAdapter<Personne>(this, android.R.layout.simple_list_item_1,listePersonnes);
        l.setAdapter(ar);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
