package example.com.menuexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.view.Menu.*;

public class Menu1 extends AppCompatActivity {

    //Notez qu'on utilise Menu.FIRST pour indiquer le premier élément d'un menu
    private final static int MENU_DESACTIVER = Menu.FIRST;
    private final static int MENU_RETOUR = Menu.FIRST + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);


        }

    /**Methode pour lancer le menu*/
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;

    }

    /**gestion des evenements du menu */
    public boolean onOptionsItemSelected (MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:
                MenuItem m;
                TextView tw = (TextView) findViewById(R.id.text);
                tw.setText("Item selectionné");
                //Dans le Menu "m", on active tous les items dans le groupe d'identifiant "R.id.group2"
                //m.setGroupEnabled(R.id.group2, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**Methode pour mettre a jour le menu*/
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /**Creation d'un menu contextuel*/
    public void onCreateContextMenu(ContextMenu menu, View vue, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, vue, menuInfo);
        menu.add(NONE, MENU_DESACTIVER, NONE, "Supprimer cet élément");
        menu.add(NONE, MENU_RETOUR, NONE, "Retour");
    }

    /**gestion des evenements du menu contextuel*/
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_DESACTIVER:
            case MENU_RETOUR:
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
