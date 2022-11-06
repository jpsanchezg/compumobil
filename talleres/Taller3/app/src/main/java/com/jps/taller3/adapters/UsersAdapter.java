package com.jps.taller3.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jps.taller3.databinding.ItemContainerUserBinding;
import com.jps.taller3.listeners.UserListener;
import com.jps.taller3.models.Usuario;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>  {

    private List<Usuario> usuarioList;

    private final UserListener userListener;
    private Context context;
    private View.OnClickListener listener;

    public UsersAdapter(List<Usuario> usuarioList,UserListener userListener) {
        this.usuarioList = usuarioList;
        this.userListener = userListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerUserBinding itemContainerUserBinding = ItemContainerUserBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new UserViewHolder(itemContainerUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UserViewHolder holder, int position) {
        holder.setUserData(usuarioList.get(position));
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        ItemContainerUserBinding binding;
        UserViewHolder(ItemContainerUserBinding itemContainerUserBinding) {
            super(itemContainerUserBinding.getRoot());
            binding = itemContainerUserBinding;
        }
        void setUserData(Usuario user){
            binding.TextName.setText(user.getNombre());
            binding.imageprofile.setImageBitmap(getUserImage(user.getFotodeperfil()));
            binding.mostrarBTN.setOnClickListener(v -> userListener.onUserClicked(user));
        }
    }

    private Bitmap getUserImage(String image){
        byte[] decodedString = android.util.Base64.decode(image, android.util.Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
