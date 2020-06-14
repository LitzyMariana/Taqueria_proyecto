package sample.Login;

public class usuario {

    int id_usuario;
    String nombre, telefono, contraseña;
    float sueldo;
    int id_rol;
    String tipo_rol;

    public usuario() {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.sueldo = sueldo;
        this.id_rol = id_rol;
        this.tipo_rol = tipo_rol;
    }

    public usuario(int id_usuario, String nombre, int id_rol, float sueldo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.id_rol = id_rol;
        this.sueldo=sueldo;
    }

    public usuario(int id_usuario, String nombre, String tipo_rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.tipo_rol = tipo_rol;
    }


    public int getId_ususario() {
        return id_usuario;
    }

    public void setId_ususario(int id_ususario) {
        this.id_usuario = id_ususario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }

    public usuario(int id_rol) {
        this.id_rol = id_rol;
    }

    @Override
    public String toString(){return Integer.toString(id_rol);}
}
