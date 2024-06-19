package com.example.applista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


class adaptadorUsuario extends ArrayAdapter<Usuario> {
    public adaptadorUsuario(Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.lyitem, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitem, null);

        TextView txtNombre= (TextView)item.findViewById(R.id.lblNombre);
        txtNombre.setText(getItem(position).getNombres());

        TextView txtEmail = (TextView)item.findViewById(R.id.lblEmail);
        txtEmail.setText(getItem(position).getEmail());

        TextView txtWebsite = (TextView)item.findViewById(R.id.lblweb);
        txtWebsite.setText(getItem(position).getWebsite());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imageView);



        return(item);
    }
}