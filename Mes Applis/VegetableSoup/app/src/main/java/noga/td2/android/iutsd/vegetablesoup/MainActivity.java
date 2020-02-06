package noga.td2.android.iutsd.vegetablesoup;

/**
 * Projet: VegetableSoup
 * Auteur: Noga Lucas
 * Date: 27/02/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SoupIngredientsAdapter adapter; /**attribut pour avoir la liste et la quantité des ingredients dans le spinner (modele du spinner)*/
    Spinner ingredientsList;        /**attribut de type spinner qui sera la vue et avec comme modele adapter*/
    TextView soupRecipeIngredients; /**le textview qui affiche le texte avec les ingredients et leur quantité*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main); //recupere le contexte de l'activité


        ingredientsList = (Spinner) findViewById(R.id.spinner_list_ingredients); //recupere le spinner ou le select
        soupRecipeIngredients = (TextView) findViewById(R.id.soup_recipe_ingredients);//recupere le champ ou seront inscris les ingredients et les quantites
        adapter = new SoupIngredientsAdapter(this); //adapter contient les données
        ingredientsList.setAdapter(adapter);//on lie les données a la vue avec la méthode setAdapter
        Button add = (Button) findViewById(R.id.addVegetable);
        Button remove = (Button) findViewById(R.id.removeVegetable);

        //le bouton +
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.augmenteQuantite(ingredientsList.getSelectedItemPosition()); //recupere la position de l'item selectionner dans la liste et ajoute 1
                soupRecipeIngredients.setText(miseAJourTexte()); //ecrit dans le champ de texte vide les ingredient
                                                                                // et leur quantite en appelant la methode toString
            }
        });

        //le bouton -
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.reduitQuantite(ingredientsList.getSelectedItemPosition()); //recupere la position de l'item selectionner dans la liste et retire 1
                soupRecipeIngredients.setText(miseAJourTexte()); //ecrit dans le champ de texte vide les
                                                                // ingredient et leur quantite en appelant la methode toString
            }
        });



    }
    //methode pour lister les ingredients dans une chaine
    private String miseAJourTexte() {
        String str = "";

        for (int i = 0; i < adapter.getCount(); i++) {
            //recupere l'ingredient a un indice i
            SoupIngredient soupIngredient = (SoupIngredient) adapter.getItem(i);
            if (Integer.valueOf(soupIngredient.getQuantity()) > 0) {
                if (str.isEmpty())
                    str = getString(R.string.add) + " " + soupIngredient.getQuantity() + " " + soupIngredient
                            .getIngredient();
                else
                    str += ", " + soupIngredient.getQuantity() + " " + soupIngredient.getIngredient();
            }
        }

        return str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    //methode pour sauvegarder
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("AdpaterIngredients", this.adapter);
    }
    //methode pour restaurer
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.adapter = (SoupIngredientsAdapter) savedInstanceState.getSerializable("AdpaterIngredients");
        final TextView soupRecipeIngredients = (TextView) findViewById(R.id.soup_recipe_ingredients);
        soupRecipeIngredients.setText(miseAJourTexte());
    }
}

