package com.neslihankaya.noteapp.data;

import android.provider.BaseColumns;

public class NoteAppContract {
    public static final class NotesEntry implements BaseColumns{
        public static final String TABLE_NAME="notes";

        public static final String _ID= BaseColumns._ID;
        public static final String Content="note";
        public static final String Creation_Date="creationDate";
        public static final String End_Date="endDate";
        public static final String Done="done";
        public static final String Category_ID="categoryID";

    }

    public static final class CategoriesEntry implements BaseColumns{
        public static final String TABLE_NAME="categories";

        public static final String _ID=BaseColumns._ID;
        public static final String Category="category";

    }
}
