package com.rku_21soeca21002.tutorial11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.txtName.setText(users.get(position).getName());
        holder.txtEmail.setText(users.get(position).getEmail());
        holder.txtNumber.setText(users.get(position).getNumber());
        holder.txtWebsite.setText(users.get(position).getWebsite());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtEmail,txtNumber,txtWebsite;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtWebsite = itemView.findViewById(R.id.txtWebsite);
        }
    }
}
