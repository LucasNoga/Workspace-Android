package example.com.databaselivreexample;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.*;
import android.database.sqlite.SQLiteOpenHelper;


/*Cette classe va nous permettre de définir la table qui sera produite lors de l'instanciation de celle-ci.*/
public class MaDataBaseSQL extends SQLiteOpenHelper{

    private static final String TABLE_LIVRES = "table_livres";
    private static final String COL_ID = "ID";
    private static final String COL_ISBN = "ISBN";
    private static final String COL_TITRE = "Titre";

    //Requete pour la creation de la table
    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_LIVRES + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_ISBN + " TEXT NOT NULL, "
            + COL_TITRE + " TEXT NOT NULL);";

    /*Constructeur de la base*/
    public MaDataBaseSQL(Context context, String name, int version) {
        super(context, name, null, version);
    }


    @Override  //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    //suppression de la table et on la recréer
    //comme ça lorsque je change la version les id repartent de 0
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_LIVRES + ";");
        onCreate(db);
    }
}
