package com.advisors.young.youngadvisors;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class RegistrarActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{
    EditText Nombre, Apellidos, Correo, Telefono, Usuario, Password, Respuesta1, Respuesta2;
    Spinner Pregunta1, Pregunta2;
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        requestQueue = Volley.newRequestQueue(this);

        progreso = new ProgressDialog(this);
        progreso.setMessage("Validando...");
        progreso.show();

        String url = "https://aaron-lkbron.000webhostapp.com/PHP/Extraer_Preguntas.php?Consulta=SELECT%20*%20FROM%20Pregunta_seguridad";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);

        Nombre = findViewById(R.id.ETNombre);
        Apellidos = findViewById(R.id.ETApellidos);
        Correo = findViewById(R.id.ETCorreo);
        Telefono = findViewById(R.id.ETTelefono);
        Usuario = findViewById(R.id.ETUsuario);
        Password = findViewById(R.id.ETPass);
        Pregunta1 = findViewById(R.id.spinnerPregunta1);
        Respuesta1 = findViewById(R.id.ETRespuesta1);
        Pregunta2 = findViewById(R.id.spinnerPregunta2);
        Respuesta2 = findViewById(R.id.ETRespuesta2);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this, "!Ups¡ \n" + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("Datos");
        JSONObject jsonObject = null;
        String[] Preguntas = new String[jsonArray.length()];
        try {
            for(int i = 0; i < jsonArray.length(); i++)
            {
                jsonObject = jsonArray.getJSONObject(i);
                Preguntas[i] = jsonObject.optString("Pregunta");
                Preguntas[i] = Preguntas[i].replace(" ", "");
            }
            List<String> listSpinner = Arrays.asList(Preguntas);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listSpinner);
            Pregunta1.setAdapter(adapter);
            Pregunta2.setAdapter(adapter);
        }catch (Exception e){
            progreso.hide();
            Toast.makeText(this, "Algo salio mal :( \n"+e.toString(), Toast.LENGTH_LONG).show();
        }
        progreso.hide();
    }
}
