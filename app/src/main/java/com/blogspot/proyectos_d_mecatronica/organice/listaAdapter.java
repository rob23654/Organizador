package com.blogspot.proyectos_d_mecatronica.organice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MrBob on 8/8/2015.
 */
public class listaAdapter extends ArrayAdapter<lista>{
    Context context;
    int layoutResourceId;
    lista datos[]=null;

    public listaAdapter (Context context, int layoutResourceId, lista[] datos){

        super(context,layoutResourceId,datos);

        this.context=context;
        this.layoutResourceId=layoutResourceId;
        this.datos=datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View item = convertView;
        listaHolder holder=null;
        if(item==null){
            LayoutInflater inflater=((MainActivity)context).getLayoutInflater();
            item=inflater.inflate(layoutResourceId,parent,false);

            holder = new listaHolder ();
            holder.imagen = (ImageView)item.findViewById(R.id.imagen);
            holder.tarea = (TextView)item.findViewById(R.id.tarea);
            item.setTag(holder);
        }else {
            holder = (listaHolder)item.getTag();
        }
        lista listas = datos[position];
        holder.tarea.setText(listas.tarea);
        holder.imagen.setImageResource(listas.imagen);
        return item;
    }

    static class listaHolder{
        ImageView imagen;
        TextView tarea;
    }
}
