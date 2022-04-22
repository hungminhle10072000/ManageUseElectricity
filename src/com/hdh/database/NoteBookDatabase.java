package com.hdh.database;

import com.hdh.model.NoteBook;

import java.util.ArrayList;
import java.util.List;

public class NoteBookDatabase {

    private List<NoteBook> listNoteBook = new ArrayList<>();

    public void createNoteBook(NoteBook noteAdd) {
        this.listNoteBook.add(noteAdd);
    }

    public List<NoteBook> getListNoteBook() {
        return listNoteBook;
    }

    public void setListNoteBook(List<NoteBook> listNoteBook) {
        this.listNoteBook = listNoteBook;
    }
}
