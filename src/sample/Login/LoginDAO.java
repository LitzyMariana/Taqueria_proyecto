package sample.Login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

    Connection conn;
    public LoginDAO(Connection conn){this.conn = conn;}

    public ObservableList<roles> fetchRol(){
        ObservableList<roles> rol = FXCollections.observableArrayList();

        try {

            String query = "select tipo_rol from roles";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
            roles p = null;
            while (rs.next()){
                p = new roles(rs.getString("tipo_rol"));
                rol.add(p);
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar informacion");
        }
        return  rol;
    }

    public usuario finIdRol(String  nom_user) {
        usuario p = new usuario();
        try {
            String query = "select u.id_rol from usuario u" +
                    " inner join roles r on u.id_rol = r.id_rol where u.nombre='" + nom_user + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                p = new usuario(rs.getInt("u.id_rol"));

            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return p;

    }

    public Boolean validUser(String username, String password) {
        ResultSet rs = null;
        int total=0;
        usuario e = null;
        try {
            String query = "SELECT count(*) as total from usuario where nombre = '" + username + "'" +
                    " and contraseña = md5('"+ password +"')";
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            total=rs.getInt("total");

            if(total==1)
            {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return (total>=1)? true:false;
    }




}
