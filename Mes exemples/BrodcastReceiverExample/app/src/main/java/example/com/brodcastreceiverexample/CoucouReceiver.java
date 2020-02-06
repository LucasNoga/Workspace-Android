package example.com.brodcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lucasnoga on 08/10/2017.
 */

public class CoucouReceiver extends BroadcastReceiver {

    private static final String NOM_USER = "sdz.chapitreTrois.intent.extra.NOM";

    // Déclenché dès qu'on reçoit un broadcast intent qui réponde aux filtres déclarés dans le Manifest
    @Override
    public void onReceive(Context context, Intent intent) {
        // On vérifie qu'il s'agit du bon intent
        if(intent.getAction().equals("ACTION_COUCOU")) {
            String nom = intent.getStringExtra(NOM_USER); // On récupère le nom de l'utilisateur
            Toast.makeText(context, "Coucou " + nom + " !", Toast.LENGTH_LONG).show();
        }
    }
}
