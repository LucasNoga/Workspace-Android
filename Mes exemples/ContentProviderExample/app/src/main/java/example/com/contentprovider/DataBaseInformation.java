package example.com.contentprovider;

import android.provider.BaseColumns;
/**Classe pour avoir le schema de la base de donnees*/
public class DataBaseInformation {

	public DataBaseInformation() {}

	public static final class Cours implements BaseColumns {
		private Cours() {}

		public static final String COURS_ID = "COURS";
		public static final String COURS_NAME = "COURS_NAME";
		public static final String COURS_DESC = "COURS_DESC";
	}
}
