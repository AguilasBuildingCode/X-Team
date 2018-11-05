package com.advisors.young.youngadvisors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.advisors.young.youngadvisors.Entidades.Usuarios;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class InicioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,Response.Listener<JSONObject>, Response.ErrorListener{

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    String idUsuarios;
    Usuarios UsuarioActivo = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        requestQueue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
        idUsuarios = intent.getStringExtra("idUsuarios");
        String url = "https://aaron-lkbron.000webhostapp.com/PHP/Terminal.php?Consulta=SELECT%20*%20FROM%20Usuarios%20WHERE%20idUsuarios%20=%20'"+ idUsuarios +"'";
        url = url.replace(" ", "%20");
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("Datos");
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(0);
            UsuarioActivo.setIdUsuarios     (Integer.parseInt(jsonObject.optString("idUsuarios")));
            UsuarioActivo.setNombre         (jsonObject.optString("Nombres"));
            UsuarioActivo.setApellidos      (jsonObject.optString("Apellidos"));
            UsuarioActivo.setCorreo         (jsonObject.optString("Correo"));
            UsuarioActivo.setCorreo_act     (Integer.parseInt(jsonObject.optString("Correo_act")));
            UsuarioActivo.setTelefono       (jsonObject.optString("Telefono"));
            UsuarioActivo.setTel_act        (Integer.parseInt(jsonObject.optString("Tel_act")));
            UsuarioActivo.setUsuario        (jsonObject.optString("Usuario"));
            UsuarioActivo.setPassword       (jsonObject.optString("Password"));
            UsuarioActivo.setPregunta1      (jsonObject.optString("Pregunta1"));
            UsuarioActivo.setRespuesta1     (jsonObject.optString("Respuesta1"));
            UsuarioActivo.setPregunta2      (jsonObject.optString("Pregunta2"));
            UsuarioActivo.setRespuesta2     (jsonObject.optString("Respuesta2"));
            UsuarioActivo.setSobre_mi       (jsonObject.optString("Sobre_mi"));
        }catch (Exception e){

        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

}
