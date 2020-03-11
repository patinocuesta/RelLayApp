package com.example.rellayapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.rellayapp.controller.PersonneDAO;
import com.example.rellayapp.model.Personne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int counter;
    EditText nom;
    EditText prenom;
    Button b;
    Spinner sp;
    ArrayAdapter<String> ar;
    String[] liste={"Cadre", "Salarié","Sans emploi"};
    String situFami;
    RadioButton rb;
    Boolean enfants;
    Switch sw;
    CheckBox cb;
    List<String> appart= new ArrayList<String>();
    //List<Personne> listePersonnes = new ArrayList<Personne>();
    int Intent1=1;
    PersonneDAO personneDAO = new PersonneDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.editNom);
        prenom=findViewById(R.id.editPrenom);
        sp=findViewById(R.id.spSituPro);
        ar=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,liste);
        sp.setAdapter(ar);
        sw=findViewById(R.id.swEnfants);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    enfants = true;
                } else {
                    enfants = false;
                }
            }
        });



    }

    public void envoyer(View view) {
        Intent intent =  new Intent(MainActivity.this,Main2Activity.class );
        Personne p= new Personne(
                ++counter,
                nom.getText().toString(),
                prenom.getText().toString(),
                sp.getSelectedItem().toString(),
                situFami,
                enfants,
                appart );
        //listePersonnes.add(p);

        if (personneDAO.existePersonne(p)==null) {
            personneDAO.insertPersonne(p);
            intent.putExtra("liste", (Serializable) personneDAO.getAll());
            //startActivity(intent);
            //Cette methode est utilise pour declancher un intent avec retour
            startActivityForResult(intent, Intent1);
        }
        else{
            Toast.makeText(this,"Personne deja enregistré",Toast.LENGTH_LONG).show();

        }
        appart = new ArrayList<String>();

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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbCelibatire:
                if (checked)
                    rb=findViewById(R.id.rbCelibatire);
                    situFami = rb.getText().toString();
                    break;
            case R.id.rbDivorce:
                if (checked)
                    rb=findViewById(R.id.rbDivorce);
                    situFami = rb.getText().toString();
                    break;
            case R.id.rbMarrie:
                if (checked)
                    rb=findViewById(R.id.rbMarrie);
                    situFami = rb.getText().toString();
                    break;
            case R.id.rbVeuf:
                if (checked)
                    rb=findViewById(R.id.rbVeuf);
                    situFami = rb.getText().toString();
                    break;
        }
    }

    public void onCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.cbStudio:
                if (checked) {
                    cb = findViewById(R.id.cbStudio);
                    appart.add(cb.getText().toString());
                }
                else {
                    cb = findViewById(R.id.cbStudio);
                    appart.remove(cb.getText().toString());
                }
            break;
            case R.id.cbF2:
                if (checked) {
                    cb = findViewById(R.id.cbF2);
                    appart.add(cb.getText().toString());
                }
                else {
                    cb = findViewById(R.id.cbF2);
                    appart.remove(cb.getText().toString());
                }
                break;
            case R.id.cbF3:
                if (checked) {
                    cb = findViewById(R.id.cbF3);
                    appart.add(cb.getText().toString());
                }
                else {
                    cb = findViewById(R.id.cbF3);
                    appart.remove(cb.getText().toString());
                }
                break;
            case R.id.cbF4:
                if (checked) {
                    cb = findViewById(R.id.cbF4);
                    appart.add(cb.getText().toString());
                }
                else {
                    cb = findViewById(R.id.cbF4);
                    appart.remove(cb.getText().toString());
                }
                break;
            case R.id.cbMaison:
                if (checked) {
                    cb = findViewById(R.id.cbMaison);
                    appart.add(cb.getText().toString());
                }
                else {
                    cb = findViewById(R.id.cbMaison);
                    appart.remove(cb.getText().toString());
                }
                break;

        }
    }
}
