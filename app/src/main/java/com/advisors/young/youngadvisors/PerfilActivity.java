package com.advisors.young.youngadvisors;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class PerfilActivity extends AppCompatActivity {

    private static final int COD_SELECCIONADA = 10;
    private static final int COD_FOTO = 20;
    String  Nombre, Apellidos, Correo, Telefono, Usuario, Password, Respuesta1, Respuesta2, Pregunta1, Pregunta2;
    TextView bienvenido;
    ImageView Foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Intent intent = getIntent();
        Nombre = intent.getStringExtra(RegistrarActivity.INombre);
        Apellidos = intent.getStringExtra(RegistrarActivity.IApellidos);
        Correo = intent.getStringExtra(RegistrarActivity.ICorreo);
        Telefono = intent.getStringExtra(RegistrarActivity.ITelefono);
        Usuario = intent.getStringExtra(RegistrarActivity.IUsuario);
        Password = intent.getStringExtra(RegistrarActivity.IPassword);
        Pregunta1 = intent.getStringExtra(RegistrarActivity.IPregunta1);
        Respuesta1 = intent.getStringExtra(RegistrarActivity.IRespuesta1);
        Pregunta2 = intent.getStringExtra(RegistrarActivity.IPregunta2);
        Respuesta2 = intent.getStringExtra(RegistrarActivity.IRespuesta2);

        bienvenido = findViewById(R.id.TVBienvenido);
        bienvenido.append(" " + Nombre);
        Foto = findViewById(R.id.IVPerfil);
    }

    public void subirFoto(View view){
        final CharSequence[] opciones={"Tomar Foto","Elegir de Galeria","Cancelar"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Elige una Opción");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){
                    //abriCamara();
                }else{
                    if (opciones[i].equals("Elegir de Galeria")){
                        Intent intent=new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione"), COD_SELECCIONADA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case COD_SELECCIONADA:
                Uri miPath=data.getData();
                Foto.setImageURI(miPath);
                //try {
                //   bitmap=MediaStore.Images.Media.getBitmap(this.getContentResolver(),miPath);
                //    Foto.setImageBitmap(bitmap);
                //} catch (IOException e) {
                //    e.printStackTrace();
                //}
                break;
            case COD_FOTO:
                /*
                MediaScannerConnection.scanFile(getContext(), new String[]{path}, null,
                        new MediaScannerConnection.OnScanCompletedListener() {
                            @Override
                            public void onScanCompleted(String path, Uri uri) {
                                Log.i("Path",""+path);
                            }
                        });

                bitmap= BitmapFactory.decodeFile(path);
                Foto.setImageBitmap(bitmap);
                */
                break;
        }
        //bitmap=redimensionarImagen(bitmap,600,800);
    }
}
