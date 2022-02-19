package com.mss.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText title, description;
    AppCompatButton update;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        update = findViewById(R.id.update);

        intent = getIntent();

        int id_ = intent.getIntExtra("id",0);
        String title_ = intent.getStringExtra("title");
        String description_ = intent.getStringExtra("description");

        title.setText(title_);
        description.setText(description_);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title_str = title.getText().toString();
                String description_str = description.getText().toString();

                Contact contact = new Contact();
                contact.setId(id_);
                contact.setTitle(title_str);
                contact.setDescription(description_str);

                ContactDB.getContactDB(Update.this).contactDAO().Update(contact);
                
                startActivity(new Intent(Update.this,MainActivity.class));
                Toast.makeText(Update.this, "Updated", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}