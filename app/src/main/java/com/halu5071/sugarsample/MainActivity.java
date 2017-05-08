package com.halu5071.sugarsample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private static final int CREATE_BOOK_CODE = 1991;

    ListView mListView;
    MyListAdapter mAdapter;

    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findViewByIdを一括して行うsetView
        setView();

        mAdapter = new MyListAdapter(this, R.layout.book_card);
        mListView.setAdapter(mAdapter);
        mListView.setEmptyView(findViewById(R.id.empty_view));

        List<Book> mList = Book.listAll(Book.class);
        mAdapter.addAll(mList);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createIntent = new Intent(getApplicationContext(), CreateBookActivity.class);
                startActivityForResult(createIntent, CREATE_BOOK_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_BOOK_CODE && resultCode == RESULT_OK){
            if (data != null){
                Book book = ((Book) data.getSerializableExtra("book"));
                book.save();
//                long id = book.getId();
//                Log.d(TAG, "Book ID : " + id);
                mAdapter.add(book);
            }
        }
    }

    private void setView(){
        mListView = ((ListView) findViewById(R.id.list_view));
        mFab = ((FloatingActionButton) findViewById(R.id.fab));
        mFab.setImageResource(R.drawable.ic_add_white_24dp);
    }
}
