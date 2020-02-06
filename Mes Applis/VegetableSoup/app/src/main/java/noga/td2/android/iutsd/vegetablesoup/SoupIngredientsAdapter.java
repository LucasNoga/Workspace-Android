package noga.td2.android.iutsd.vegetablesoup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;

/**Permet de creer un modele de données pour le spinner*/
public class SoupIngredientsAdapter extends BaseAdapter implements Serializable {

    //les attributs
    private Context activityContext;  //le contexte de l'activité dans laquelle le modele est utilisé, dans notre cas c'est content_activity
    private String[] ingredients;   //contient le nom de tous les ingredients qui seront afficher dans la liste
    private String[] quantities;    //contient la quantité de tous les ingredients qui seront afficher dans la liste


    public SoupIngredientsAdapter(Context activityContext) {
        this.activityContext = activityContext; //recupere le contexte de l'activité
        this.ingredients = activityContext.getResources().getStringArray(R.array.soupIngredients);   //recupere les ingredients dans les resources
        this.quantities = activityContext.getResources().getStringArray(R.array.soupIngredientsQuantities);  //recupere les quantités dans les ressources
    }

    @Override
    /**recupere le nombre total d'ingredients*/
    public int getCount() {
        return ingredients.length;
    }

    @Override
    /**recupere l'ingredient dependant de la position*/
    public SoupIngredient getItem(int position) {
        return new SoupIngredient(ingredients[position], quantities[position]);
    }

    @Override
    /**recupere uniquement la position de l'item selectionne dans le spinner*/
    public long getItemId(int position) {
        return position;
    }

    @Override
    /**retourne un objet de type view, dans notre cas un simple textView pour resumé nous aurons un textview pour chaque ingredients dans notre spinner cette méthode est appele a chaque fois qu l'on clique sur le spinner*/
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(activityContext); //un objet qui contient le contexte principale qui a été serailisé
        convertView = inflater.inflate(R.layout.soup_ingredients, null); // ajoute au contexte serialisé une vue qui contient uniquement un textview qui lui aussi vien dêtre serialisé
        TextView tw_ingredients = (TextView) convertView.findViewById(R.id.label_ingredients); //on caste notre vue serialisé en Textviexw pour avoir uniquement le nom de notre legume dedans
        tw_ingredients.setText(this.quantities[position]+ " " +this.ingredients[1]); //recupere pour chaque ingredient dans le tableau un textview avec son nom et sa quantité
        return convertView;
    }

    /**méthode pour derementer la quantité*/
    public void reduitQuantite(int position) {
        if (Integer.valueOf(quantities[position]) > 0)
            quantities[position] = (Integer.valueOf(quantities[position]) - 1) + "";
    }

    /**méthode pour incrémenter la quantité*/
    public void augmenteQuantite(int position) {
        quantities[position] = (Integer.valueOf(quantities[position]) + 1) + "";
    }
}

