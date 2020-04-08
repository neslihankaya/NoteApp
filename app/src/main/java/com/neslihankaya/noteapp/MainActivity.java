package com.neslihankaya.noteapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.neslihankaya.noteapp.data.DBHelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner categories;
    ListView lstV_notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );


        FloatingActionButton fab = findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this,NoteActivity.class );
                startActivity( intent );
            }
        } );

        defineViews();
        String[] notes = getResources().getStringArray(R.array.notes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.notes_single_line,R.id.txtNote,notes);
        lstV_notes.setAdapter( adapter );
        lstV_notes.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String note = (String) lstV_notes.getItemAtPosition( i );
                Intent intent =new Intent( MainActivity.this,NoteActivity.class );
                String category = categories.getSelectedItem().toString();
               Bundle bundle=new Bundle();
                bundle.putString("note",note);
                bundle.putString("category",category);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        } );


        
    }

    private void defineViews() {
        lstV_notes =findViewById( R.id.listView_notes );
        categories =findViewById( R.id.spinner_categories );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_categories) {
            Intent intent = new Intent( MainActivity.this,CategoryActivity.class );
            startActivity( intent );
            return true;
        }

        return super.onOptionsItemSelected( item );
    }
}
