package com.example.rellayapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rellayapp.model.Personne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText nom;
    EditText prenom;
    Button b;
    Spinner sp;
    ArrayAdapter<String> ar;
    String[] liste={"IT", "FR","ES"};
    List<Personne> listePersonnes = new ArrayList<Personne>();
    int Intent1=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.editNom);
        prenom=findViewById(R.id.editPrenom);
        sp=findViewById(R.id.spLangue);
        ar=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,liste);
        sp.setAdapter(ar);
    }


    public void envoyer(View view) {
        Intent intent =  new Intent(MainActivity.this,Main2Activity.class );
        Personne p= new Personne(nom.getText().toString(), prenom.getText().toString(), sp.getSelectedItem().toString());
        listePersonnes.add(p);
        intent.putExtra("liste", (Serializable) listePersonnes);
        //startActivity(intent);
        //Cette methode est utilise pour declancher un intent avec retour
        startActivityForResult(intent, Intent1);
    }
    //Methode de callback que va se declencher lorsque des resultats sont renvoyes vers cette activity
    //apres avoir appele la meethode starActivityForResultat
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            String numero = data.getStringExtra("resultat");
            Toast.makeText(this,numero,Toast.LENGTH_LONG).show();
        }
    }
}
