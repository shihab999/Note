package com.mss.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.insertbtn);
        recyclerView = findViewById(R.id.recycler);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Insert.class);
                startActivity(intent);
                finish();

            }
        });


        DesignAdapter adapter = new DesignAdapter(this, ContactDB.getContactDB(this).contactDAO().getAllData());
        recyclerView.setAdapter(adapter);

    }
}