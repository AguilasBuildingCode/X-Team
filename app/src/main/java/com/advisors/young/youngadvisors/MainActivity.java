package com.advisors.young.youngadvisors;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.advisors.young.youngadvisors.Entidades.Usuarios;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    EditText usuario, password;
    ProgressDialog progreso;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    public final static String id = "idUsuarios";
    Usuarios UsuarioActivo = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.ETUsuario);
        password = findViewById(R.id.ETPass);
        requestQueue = Volley.newRequestQueue(this);
    }

    public void Iniciar(View view){
        progreso = new ProgressDialog(this);
        progreso.setMessage("Validando...");
        progreso.show();
        String url = "https://aaron-lkbron.000webhostapp.com/PHP/Terminal.php?Consulta=SELECT%20*%20FROM%20Usuarios%20WHERE%20Usuario%20=%20'"
                +usuario.getText().toString()+"'%20AND%20Password%20=%20'"
                +password.getText().toString()+"'";
        url = url.replace(" ", "%20");
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);
    }

    public void Registrar(View view){
        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("Datos");
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(0);
            UsuarioActivo.setIdUsuarios(Integer.parseInt(jsonObject.optString("idUsuarios")));
            if(UsuarioActivo.getIdUsuarios() != 0){
                UsuarioActivo.setNombre(jsonObject.optString("Nombres"));
                progreso.hide();
                Toast.makeText(this, "!Bienvenid@¡ " + UsuarioActivo.getNombre(), Toast.LENGTH_LONG).show();
                usuario.setText("");
                password.setText("");
                Intent intent = new Intent(this, InicioActivity.class);
                intent.putExtra(id, Integer.toString(UsuarioActivo.getIdUsuarios()));
                startActivity(intent);
            }else {
                progreso.hide();
                Toast.makeText(this, "Tal vez ocupas registrarte ;)", Toast.LENGTH_LONG).show();
                usuario.setText("");
                password.setText("");
            }
        }catch (Exception e){
            progreso.hide();
            Toast.makeText(this, "Algo salio mal :( \n"+e.toString(), Toast.LENGTH_LONG).show();
            usuario.setText("");
            password.setText("");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this, "!Ups¡ \n" + error.toString(), Toast.LENGTH_LONG).show();
        usuario.setText("");
        password.setText("");
    }
}
