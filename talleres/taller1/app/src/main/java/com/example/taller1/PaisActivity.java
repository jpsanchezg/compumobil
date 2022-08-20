package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        ListView listView = findViewById(R.id.listapaises);
        listView.setClickable(true);
        setTitle("Lista de paises");

        try {



            String nombresPaises =loadJSONFromAsset();

            List<Pais> items = new ArrayList<>();
            JSONObject root = new JSONObject(nombresPaises);

            JSONArray array= root.getJSONArray("paises");



            System.out.println(array.length());
            for(int i=0;i<array.length();i++)
            {
                JSONObject object= array.getJSONObject(i);
                Pais datos = new Pais();
                datos.setCapital(object.getString("capital"));
                datos.setNombre_pais(object.getString("nombre_pais"));
                datos.setNombre_pais_int(object.getString("nombre_pais_int"));
                datos.setSigla(object.getString("sigla"));
                items.add(datos);
            }

            ArrayAdapter<Pais> adapter = new ArrayAdapter<Pais>(this, android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext() , DetallePaisActivity.class);
                    Pais item = items.get(position);

                    intent.putExtra("datospais",item);
                    startActivity(intent);
                }
            });

            JSONObject nested= root.getJSONObject("nested");
            Log.d("TAG","flag value "+nested.getBoolean("flag"));




        } catch (JSONException e) {
            e.printStackTrace();
        }



    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}