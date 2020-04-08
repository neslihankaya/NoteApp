package com.neslihankaya.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class CategoryActivity extends AppCompatActivity  {

    ListView listView_categories;
    EditText edtText_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_category );

        getSupportActionBar().setDisplayHomeAsUpEnabled( true);
        getSupportActionBar().setDisplayShowHomeEnabled( true );
        defineViews();

        listView_categories.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clicked_item= (String) listView_categories.getItemAtPosition( i );
                edtText_category.setText( clicked_item );
            }
        } );

    }

    private void defineViews() {
        listView_categories=findViewById( R.id.lstView_categories );
        edtText_category=findViewById( R.id.edtTxt_category );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
