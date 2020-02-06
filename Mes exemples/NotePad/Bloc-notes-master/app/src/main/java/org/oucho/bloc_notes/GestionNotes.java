package org.oucho.bloc_notes;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class GestionNotes {

	final ArrayList<Note> notes = new ArrayList<>();
	private Context context = null;

	public GestionNotes(Context context) {
		this.context = context;
	}

	public boolean isEmpty() {
		return notes.isEmpty();
	}

/*	private boolean getNoteByText(String t) {
		for (Note n : notes)
			if (n.findChanges(t)) {
				return true;
			}
		return false;
	}*/

/*	public boolean getNoteByText(CharSequence text) {
		return getNoteByText(text.toString());
	}*/

	public List<Note> getAllNotes() {
		return notes;
	}

	public Note getNoteById(int id) {
		return notes.get(id);
	}


	public void deleteNote(Note note) {
		note.delete(context);
		notes.remove(note);
	}

	public void deleteNote(int index) {
		notes.get(index).delete(context);
		notes.remove(index);
	}

	public void addNote(Note note) {
		if (note == null || notes.contains(note)) return;
		note.gestionNotes = this;
		notes.add(note);
		try {
			note.saveToFile(context);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**genere un nom de fichier pour l'attribut filename*/
	public String generateFilename() {
		int id = -1;
		String name;
		do{
			name = "note_"+id+".txt";
			id++;
		}while(context.getFileStreamPath(name).exists());
		return name;
	}

	public Note newFromClipboard(BlocNotesApplication application) {
		Note note = Note.newFromClipboard(this, application);
		if (note == null) return null;
		addNote(note);
		return note;
	}

	public void loadNotes() {
		String[] files = context.fileList();
		notes.clear();
		for (String fname : files) {
			try {
				notes.add(Note.newFromFile(this, context, fname));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
