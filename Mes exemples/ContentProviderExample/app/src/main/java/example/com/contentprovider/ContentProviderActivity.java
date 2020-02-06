package example.com.contentprovider;

import example.com.contentprovider.DataBaseInformation.Cours;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class ContentProviderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		insertRecords();
		displayContentProvider();
	}

	private void insertRecords() {
		ContentValues contact = new ContentValues();
		contact.put(Cours.COURS_NAME, "Android");
		contact.put(Cours.COURS_DESC, "Introduction à la programmation sous Android");
		getContentResolver().insert(AndroidProvider.CONTENT_URI, contact);

		contact.clear();
		contact.put(Cours.COURS_NAME, "Java");
		contact.put(Cours.COURS_DESC, "Introduction à la programmation Java");
		getContentResolver().insert(AndroidProvider.CONTENT_URI, contact);

		contact.clear();
		contact.put(Cours.COURS_NAME, "Iphone");
		contact.put(Cours.COURS_DESC, "Introduction à l'objectif C");
		getContentResolver().insert(AndroidProvider.CONTENT_URI, contact);
	}

	private void displayContentProvider() {
		String columns[] = new String[] { Cours.COURS_ID, Cours.COURS_NAME, Cours.COURS_DESC };
		Uri mContacts = AndroidProvider.CONTENT_URI;
        Cursor cur = getContentResolver().query(mContacts, columns, null, null, null);
		Toast.makeText(ContentProviderActivity.this, cur.getCount() + "",
				Toast.LENGTH_LONG).show();

		if (cur.moveToFirst()) {
			String name;
			do {
				name = cur.getString(cur.getColumnIndex(Cours.COURS_ID)) + " " +
						cur.getString(cur.getColumnIndex(Cours.COURS_NAME)) + " " + 
						cur.getString(cur.getColumnIndex(Cours.COURS_DESC));
				Toast.makeText(this, name + " ", Toast.LENGTH_LONG).show();
			} while (cur.moveToNext());
		}

	}
}