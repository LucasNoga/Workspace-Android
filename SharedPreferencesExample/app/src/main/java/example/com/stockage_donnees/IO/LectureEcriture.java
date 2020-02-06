package example.com.stockage_donnees.IO;

/* Énoncé
Très simple, on va faire en sorte d'écrire votre pseudo dans deux fichiers : un en stockage interne, l'autre en stockage externe.
N'oubliez pas de vérifier qu'il est possible d'écrire sur le support externe !
 */

/* Détails techniques
Il existe une constante qui indique que le périphérique est en lecture seule (et que par conséquent il est impossible d'écrire dessus),
c'est la constante Environment.MEDIA_MOUNTED_READ_ONLY.

 Si un fichier n'existe pas, vous pouvez le créer avec boolean createNewFile(). */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.com.stockage_donnees.R;

public class LectureEcriture extends Activity {
    private String PRENOM = "prenom.txt";
    private String userName = null;
    private File mFile = null;

    private EditText et_prenom;
    private Button buttonWrite = null;
    private Button buttonRead = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_prenom = findViewById(R.id.et_prenom);

        // On crée un fichier qui correspond à l'emplacement extérieur
        mFile = new File(Environment.getExternalStorageDirectory().getPath() + "/Android/data/ " + getPackageName() + "/files/" + PRENOM);

        buttonWrite = findViewById(R.id.write);
        buttonWrite.setOnClickListener(new View.OnClickListener() {

            public void onClick(View pView) {
                ecriture();
            }
        });

        buttonRead = findViewById(R.id.read);
        buttonRead.setOnClickListener(new View.OnClickListener() {

            public void onClick(View pView) {
                lecture();
            }
        });
    }

    private void ecriture(){
        try {
            // Flux interne
            FileOutputStream output = openFileOutput(PRENOM, MODE_PRIVATE);

            //on recupere le nom saisi
            String text = et_prenom.getText().toString();

            // On écrit dans le flux interne
            output.write(text.getBytes());
            output.close();

            // Si le fichier est lisible et qu'on peut écrire dedans
            if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && !Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
                // On crée un nouveau fichier. Si le fichier existe déjà, il ne sera pas créé
                mFile.createNewFile();
                output = new FileOutputStream(mFile);
                output.write(userName.getBytes());
                output.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lecture(){
        try {
            FileInputStream input = openFileInput(PRENOM);
            int value;
            // On utilise un StringBuffer pour construire la chaîne au fur et à mesure
            StringBuffer lu = new StringBuffer();
            // On lit les caractères les uns après les autres
            while((value = input.read()) != -1) {
                // On écrit dans le fichier le caractère lu
                lu.append((char)value);
            }

            Toast.makeText(LectureEcriture.this, "Interne : " + lu.toString(), Toast.LENGTH_SHORT).show();
            input.close();

            if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                lu = new StringBuffer();
                input = new FileInputStream(mFile);
                while((value = input.read()) != -1)
                    lu.append((char)value);

                Toast.makeText(LectureEcriture.this, "Externe : " + lu.toString(), Toast.LENGTH_SHORT).show();
                input.close();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
