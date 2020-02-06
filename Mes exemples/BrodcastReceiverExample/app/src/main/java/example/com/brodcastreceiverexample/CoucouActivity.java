package example.com.brodcastreceiverexample;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CoucouActivity extends AppCompatActivity {

    private static final String COUCOU = "sdz.chapitreTrois.intent.action.coucou";
    private IntentFilter filtre = null;
    private CoucouReceiver receiver = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coucou_layout);

        filtre = new IntentFilter(COUCOU);
        receiver = new CoucouReceiver();
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(receiver, filtre);
    }

    /** Si vous déclarez votre receiver dans le onResume, n'oubliez pas qu'il faut l'arrêter dans le onPause **/
    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
