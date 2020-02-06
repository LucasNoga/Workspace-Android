package example.com.stockage_donnees.IO;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

import example.com.stockage_donnees.R;

public class SharedPreferenceFonctionnement extends AppCompatActivity{
    public final static String FAVORITE_COLOR = "fav color";
    private static final String MY_PREFERENCES = "Prefs";
    private static final String NOM = "nom";
    private static final String PRENOM = "prenom";
    private TextView tw = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_activity);

        tw = (TextView) findViewById(R.id.text);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String nom = sharedPref.getString(NOM, "defaultValue");
        String prenom = sharedPref.getString(PRENOM, "defaultValue");

        if(!nom.equals("defaultValue") || !prenom.equals("defaultValue")){
            tw.setText(nom + " " + prenom);
        }


        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(NOM, "Noga");
        edit.putString(PRENOM, "Lucas");
        edit.apply();
    }

   /*///////////////////////////////AUTRE METHODE/////////////////////////////////////////////////////

    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(FAVORITE_COLOR, "FFABB4");
        editor.apply();

        // On veut la chaîne de caractères d'identifiant FAVORITE_COLOR
        // Si on ne trouve pas cette valeur, on veut rendre "FFFFFF"
        String couleur = preferences.getString(FAVORITE_COLOR, "FFFFFF");

        editor.remove(FAVORITE_COLOR);//pour supprimer la preference
        Map<String, ?> test = preferences.getAll();//permet de  recuperer toutes les pref


   A RETENIR
   Il est possible d'enregistrer les préférences de l'utilisateur avec la classe SharedPreferences.
   */

    /*
    Pour permettre à l'utilisateur de sélectionner ses préférences, on peut définir une PreferenceActivity qui facilite le processus.
    On peut ainsi insérer des CheckBox, des EditText, etc.
     */

    /*
    Il est possible d'enregistrer des données dans des fichiers facilement, comme en Java.
    Cependant, on trouve deux endroits accessibles : en interne (sur un emplacement mémoire réservé à l'application sur le téléphone)
    ou en externe (sur un emplacement mémoire amovible, comme par exemple une carte SD).
     */

    /*
    Enregistrer des données sur le cache permet de sauvegarder des fichiers temporairement.
     */
}
