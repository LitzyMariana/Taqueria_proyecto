package sample.Login;

public class roles {

    int id_rol;
    String tipo_rol;

    public roles(int id_rol, String tipo_rol) {
        this.id_rol = id_rol;
        this.tipo_rol = tipo_rol;
    }

    public roles (String tipo_rol){this.tipo_rol = tipo_rol;}
    public roles(int id_rol){this.id_rol= id_rol;}

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

    @Override
    public String toString(){return tipo_rol;}
}
