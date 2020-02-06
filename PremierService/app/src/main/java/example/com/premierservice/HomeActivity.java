package example.com.premierservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button serviceBtn = (Button) findViewById(R.id.serviceBtn);


        serviceBtn.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(HomeActivity.this, FirstService.class));
            }
        });
    }
}