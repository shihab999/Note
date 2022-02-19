package com.mss.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    EditText title, description;
    AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_str = title.getText().toString();
                String description_str = description.getText().toString();


                writetodatabase(title_str,description_str);

            }
        });
    }

    private void writetodatabase(String title_str, String description_str) {

        Contact contact = new Contact();
        contact.setTitle(title_str);
        contact.setDescription(description_str);

        ContactDB.getContactDB(Insert.this).contactDAO().Insert(contact);

        Toast.makeText(Insert.this,"Successful", Toast.LENGTH_SHORT).show();


        startActivity(new Intent(Insert.this,MainActivity.class));
        finish();
    }
}