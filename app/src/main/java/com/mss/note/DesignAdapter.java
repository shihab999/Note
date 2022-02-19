package com.mss.note;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DesignAdapter extends RecyclerView.Adapter<DesignViewHolder> {

    Activity activity;
    List<Contact> datalist;


    public DesignAdapter(Activity activity, List<Contact> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public DesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.design, parent, false);

        return new DesignViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesignViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Contact contact = datalist.get(position);

        holder.title.setText(contact.getTitle());
        holder.description.setText(contact.getDescription());


        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(activity, Update.class);
                intent.putExtra("id",contact.getId());
                intent.putExtra("title",contact.getTitle());
                intent.putExtra("description",contact.getDescription());
                activity.startActivity(intent);
                activity.finish();

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactDB.getContactDB(activity).contactDAO().Delete(contact);

                datalist.remove(position);
                notifyDataSetChanged();

                Toast.makeText(activity, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
