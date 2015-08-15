package com.blogspot.proyectos_d_mecatronica.organice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista listas_datos[] = new lista[]{
                new lista(R.drawable.altisima,"Prioridad Altisima"),
                new lista(R.drawable.alta,"Prioridad Alta"),
                new lista(R.drawable.media,"Prioridad Media"),
                new lista(R.drawable.baja,"Prioridad Baja"),
                new lista(R.drawable.bajisimo,"Prioridad Bajisima")
        };
        listaAdapter adapter = new listaAdapter(this,R.layout.item,listas_datos);
        ls = (ListView)findViewById(R.id.listView);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>arg0 , View arg1, int arg2, long arg3){
                TextView v = (TextView) arg1.findViewById(R.id.tarea);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
         });
    }



}
