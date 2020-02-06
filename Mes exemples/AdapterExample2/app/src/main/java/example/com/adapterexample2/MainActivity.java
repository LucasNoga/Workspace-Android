package example.com.adapterexample2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        List<Tweet> tweets = genererTweets();

        TweetAdapter adapter = new TweetAdapter(MainActivity.this, tweets);
        mListView.setAdapter(adapter);
    }

    private List<Tweet> genererTweets(){
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        tweets.add(new Tweet(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        tweets.add(new Tweet(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        return tweets;
    }
}
