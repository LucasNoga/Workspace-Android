package fr.utt.if26.if26_tp4v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    private Spinner liste = null;
    private EditText nomText, prenomText, ageText = null;
    private RadioGroup rg1 = null;

    //data
    private Etudiant etudiant = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_etudiant);

        nomText = (EditText) findViewById(R.id.nom);
        prenomText = (EditText) findViewById(R.id.prenom);
        ageText = (EditText) findViewById(R.id.age);
        liste = (Spinner) findViewById(R.id.spinner);
        rg1 = (RadioGroup) findViewById(R.id.rg);
        AjoutContenuSpinner();
        Button envoie = (Button) findViewById(R.id.envoie);
        envoie.setOnClickListener(this);
    }

    public void AjoutContenuSpinner() {
        List<String> langages = new ArrayList<>();
        langages.add("C++");
        langages.add("C");
        langages.add("Java");
        langages.add("Python");
        langages.add("PHP");
        langages.add(".NET");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_selectable_list_item, langages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//Le layout par défaut
        liste.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        sendIntent();
    }

    /**
     * Envoi de l'intent et lancement de l'activite 2
     */
    public void sendIntent() {
        creationEtudiant();

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("etudiant", etudiant);
        startActivity(intent);
    }

    public void creationEtudiant() {
        String nom = nomText.getText().toString();
        String prenom = prenomText.getText().toString();
        String ageString = ageText.getText().toString();
        String langage = liste.getSelectedItem().toString();
        String sexe = "";

        if (rg1.getCheckedRadioButtonId() == R.id.radioButton1)
            sexe = "femme";
        else if (rg1.getCheckedRadioButtonId() == R.id.radioButton2)
            sexe = "homme";

        if (nom.isEmpty() || prenom.isEmpty() || ageString.isEmpty() || langage.isEmpty() || sexe.isEmpty()) {
            affichageError(nom, prenom, ageString);
            return;
        }
        int age = Integer.valueOf(ageString);
        etudiant = new Etudiant(nom, prenom, age, langage, sexe);
    }

    private void affichageError(String nom, String prenom, String age) {
        String str = "";
        if (nom.isEmpty())
            str+= "nom manquant ";
        if (prenom.isEmpty())
            str+= "prenom manquant ";
        if (age.isEmpty())
            str+= "age manquant ";
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}