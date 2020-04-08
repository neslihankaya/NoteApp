package com.neslihankaya.noteapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.neslihankaya.noteapp.data.NoteAppContract.NotesEntry;
import com.neslihankaya.noteapp.data.NoteAppContract.CategoriesEntry;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="noteapp.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_CATEGORIES_CREATE="CREATE TABLE "+ CategoriesEntry.TABLE_NAME + " ("+ CategoriesEntry._ID+ "INTEGER PRIMARY KEY, "+CategoriesEntry.Category + "TEXT)";

    private static final String TABLE_NOTES_CREATE="CREATE "+ NotesEntry.TABLE_NAME + " ("+ NotesEntry._ID+ "INTEGER PRIMARY KEY, "+NotesEntry.Content + "TEXT, " + NotesEntry.Creation_Date + " TEXT DEFAULT CURRENT_TIMESTAMP, "+NotesEntry.End_Date + "TEXT, " + NotesEntry.Done + "INTEGER,"+" FOREIGN KEY ( "+ NotesEntry.Category_ID + ")" + " REFERENCES " + CategoriesEntry.TABLE_NAME +"(" + CategoriesEntry._ID + ") " + ")";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super( context, name, factory, version );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( TABLE_CATEGORIES_CREATE );
        sqLiteDatabase.execSQL( TABLE_NOTES_CREATE );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CategoriesEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NotesEntry.TABLE_NAME);
        onCreate( sqLiteDatabase );
    }
}
