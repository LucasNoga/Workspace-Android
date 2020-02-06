package example.com.stockage_donnees.shared_preferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import example.com.stockage_donnees.R;

public class PreferenceActivityExample extends AppCompatActivity {
    EditText nom, password, email;
    TextView data = null;
    Button b1;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Password = "password";
    public static final String Email = "email";
    SharedPreferences sharedpreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefs_activity);
        email = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        b1 = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.twa);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String passwordString = sharedpreferences.getString(Password, null);
        String emailString = sharedpreferences.getString(Email, null);

        if (emailString != null && passwordString != null) {
            data.setText(emailString + " " + passwordString);
        } else {
            data.setText("Pas de donnees");
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String pw = password.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Email, e);
                editor.putString(Password, pw);

                editor.commit();
                Toast.makeText(PreferenceActivityExample.this, "Your data is saved", Toast.LENGTH_LONG).show();
            }
        });
    }
}