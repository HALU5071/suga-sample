package com.halu5071.sugarsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by HALU on 2017/05/08.
 */

public class CreateBookActivity extends AppCompatActivity {

    String title;
    String content;
    int isbn;

    Toolbar toolbar;

    EditText editTitle;
    EditText editContent;
    EditText editIsbn;

    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);
        setView();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save(){
        title = editTitle.getText().toString();
        content = editContent.getText().toString();
        isbn = Integer.parseInt(editIsbn.getText().toString());

        Book book = new Book(isbn, title, content);
        Intent data = new Intent();
        data.putExtra("book", book);
        setResult(RESULT_OK, data);
        finish();
    }

    private void setView(){
        toolbar = ((Toolbar) findViewById(R.id.toolbar_create));
        editTitle = ((EditText) findViewById(R.id.edit_title));
        editContent = ((EditText) findViewById(R.id.edit_content));
        editIsbn = ((EditText) findViewById(R.id.edit_isbn));
        buttonSave = ((Button) findViewById(R.id.button_save));
    }
}
