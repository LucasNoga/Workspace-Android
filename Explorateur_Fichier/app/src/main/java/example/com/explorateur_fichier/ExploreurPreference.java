package example.com.explorateur_fichier;

import android.app.Activity;
import android.os.Bundle;

public class ExploreurPreference extends Activity {
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference);

}
