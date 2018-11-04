package com.advisors.young.youngadvisors.Entidades;

import android.graphics.Picture;

public class Usuarios {
    private int idUsuarios, Correo_act, Tel_act;
    private String Nombre, Apellidos, Correo, Telefono,
            Usuario, Password, Pregunta1, Respuesta1, Pregunta2, Respuesta2, Sobre_mi;
    private Picture Foto;
    /*
    public Usuarios(int idUsuarios, String Nombre, String Apellidos, String Correo, int Correo_Act,
                    String Telefono, int Tel_Act, String Usuario, String Password, String Pregunta1,
                    String Respuesta1, String Pregunta2, String Respuesta2){
        this.idUsuarios = idUsuarios;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Correo_act = Correo_Act;
        this.Telefono = Telefono;
        this.Tel_act = Tel_Act;
        this.Usuario = Usuario;
        this.Password = Password;
        this.Pregunta1 = Pregunta1;
        this.Respuesta1 = Respuesta1;
        this.Pregunta2 = Pregunta2;
        this.Respuesta2 = Respuesta2;

    }
    */
    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public int getCorreo_act() {
        return Correo_act;
    }

    public void setCorreo_act(int correo_act) {
        Correo_act = correo_act;
    }

    public int getTel_act() {
        return Tel_act;
    }

    public void setTel_act(int tel_act) {
        Tel_act = tel_act;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPregunta1() {
        return Pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        Pregunta1 = pregunta1;
    }

    public void setRespuesta1(String respuesta1) {
        Respuesta1 = respuesta1;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public void setPregunta2(String pregunta2){
        this.Pregunta2 = pregunta2;
    }

    public String getPregunta2() {
        return Pregunta2;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        Respuesta2 = respuesta2;
    }

    public String getSobre_mi() {
        return Sobre_mi;
    }

    public void setSobre_mi(String sobre_mi) {
        this.Sobre_mi = sobre_mi;
    }

    public Picture getFoto() {
        return Foto;
    }

    public void setFoto(Picture foto) {
        Foto = foto;
    }
}
