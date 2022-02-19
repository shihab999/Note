package com.mss.note;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DesignViewHolder extends RecyclerView.ViewHolder {

    TextView title, description;
    ImageView update, delete;


    public DesignViewHolder(@NonNull View itemView) {

        super(itemView);

        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);

        update = itemView.findViewById(R.id.update);
        delete = itemView.findViewById(R.id.delete);
    }


}
