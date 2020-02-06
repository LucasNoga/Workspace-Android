package fr.utt.if26.if26_tp4v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        TextView result = (TextView) findViewById(R.id.result);
        Etudiant etudiant = (Etudiant) extras.getSerializable("etudiant");
        String genre;
        Log.i("test", etudiant.getSexe());
        if (etudiant.getSexe().equals("femme"))
            genre = "elle";
        else
            genre = "il";

        String str = "Etudiant : "+genre+ " s'appelle " + etudiant.getNom() + " " + etudiant.getPrenom() + " " + genre + " a " + etudiant.getAge()
                +" ans son langage favori est : "+ etudiant.getLangage();
        result.setText(str);
    }
}
