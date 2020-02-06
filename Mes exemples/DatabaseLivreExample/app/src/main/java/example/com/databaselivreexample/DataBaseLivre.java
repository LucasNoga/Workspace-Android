package example.com.databaselivreexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* GestionLivres va permettre de gérer
   l'insert, le delete, l'update et le select de livres dans la BD et de faire des requêtes pour récupérer un livre contenu dans la BD.
*/
public class DataBaseLivre {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "knsvjgjs.db";

    private static final String TABLE_LIVRES = "table_livres";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_ISBN = "ISBN";
    private static final int NUM_COL_ISBN = 1;
    private static final String COL_TITRE = "Titre";
    private static final int NUM_COL_TITRE = 2;

    //represente notre base de données de livre
    private MaDataBaseSQL databaseLivre;

    //objet necessaire pour avoir accees en lecture ou en ecriture a la base de donnees
    private SQLiteDatabase database;

    //On crée la BDD et sa table
    public DataBaseLivre(Context context){
        databaseLivre = new MaDataBaseSQL(context, NOM_BDD, VERSION_BDD);
    }

    //on ouvre la BDD en écriture
    public void open(){
            database = databaseLivre.getWritableDatabase();
    }

    //on ferme l'accès à la BDD
    public void close(){
        database.close();
    }

    //getter pour recuperer l'acces a notre base
    public SQLiteDatabase getDatabase(){
        return database;
    }

    //Insertion d'un tuple dans la base de donnees (fonctionne comme une HashMap)
    public long insertLivre(Livre livre){
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ISBN, livre.getIsbn());
        values.put(COL_TITRE, livre.getTitre());

        return database.insert(TABLE_LIVRES, null, values);//on insère l'objet dans la BDD via le ContentValues
    }

    //Mise a jour un livre fonctionne plus ou moins comme une insertion, on recupere le livre grace a son ID
    public int updateLivre(int id, Livre livre){
        ContentValues values = new ContentValues();
        values.put(COL_ISBN, livre.getIsbn());
        values.put(COL_TITRE, livre.getTitre());
        return database.update(TABLE_LIVRES, values, COL_ID + " = " +id, null);
    }

    //Suppression d'un livre de la BD grâce à l'ID
    public int removeLivreWithID(int id){
        return database.delete(TABLE_LIVRES, COL_ID + " = " +id, null);
    }

    //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
    public Livre getLivreWithTitre(String titre){
        Cursor c = database.query(TABLE_LIVRES, new String[] {COL_ID, COL_ISBN, COL_TITRE}, COL_TITRE + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToLivre(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Livre cursorToLivre(Cursor c) {
        if (c.getCount() == 0) //si aucun élément n'a été retourné dans la requête, on renvoie null
            return null;


        c.moveToFirst(); //Sinon on se place sur le premier élément
        Livre livre = new Livre();  //On créé un livre

        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        livre.setId(c.getInt(NUM_COL_ID));
        livre.setIsbn(c.getString(NUM_COL_ISBN));
        livre.setTitre(c.getString(NUM_COL_TITRE));

        c.close();  //On ferme le cursor

        //On retourne le livre
        return livre;
    }
}
