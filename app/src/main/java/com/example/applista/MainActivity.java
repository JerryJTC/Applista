package com.example.applista;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applista.WebService.Asynchtask;
import com.example.applista.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.example.applista.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ListView lstUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyitem);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity.this,MainActivity.this);
        ws.execute("GET");


        lstUsuarios = (ListView)findViewById(R.id.lstUsuarios);

        View header = getLayoutInflater().inflate(R.layout.lyitem, null);
        lstUsuarios.addHeaderView(header);

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONObject JSONlista =  new JSONObject(result);
        JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

        ArrayList<Usuario>  datosUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

        adaptadorUsuario adapatorUsuario = new adaptadorUsuario(this, datosUsuarios);

        lstUsuarios.setAdapter(adapatorUsuario);
    }
}