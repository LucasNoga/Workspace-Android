package example.com.textwatcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class TextWatcherActivity extends AppCompatActivity implements TextWatcher {
    private EditText status;
    private TextView nbCharTxt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        status = (EditText) findViewById(R.id.status);
        status.addTextChangedListener(this);
        nbCharTxt = (TextView) findViewById(R.id.indicator);
        nbCharTxt.setTextColor(Color.GREEN);
    }

    @Override
    public void afterTextChanged(Editable editable) {
        int nbChar = status.getText().toString().length();
        int leftChar = 20 - nbChar;
        nbCharTxt.setText(Integer.toString(leftChar) + " caracteres restant");
        nbCharTxt.setTextColor(Color.GREEN);
        if (leftChar < 10 && leftChar >= 0)
            nbCharTxt.setTextColor(Color.YELLOW);
        else if (leftChar <= 0)
        {
            nbCharTxt.setTextColor(Color.RED);
            nbCharTxt.setText(Integer.toString(Math.abs(leftChar)) + " caracteres en trop");
        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSeq, int arg1, int arg2, int arg3) {

    }

    @Override
    public void onTextChanged(CharSequence charSeq, int arg1, int arg2, int arg3) {

    }
}

