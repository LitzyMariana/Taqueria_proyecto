package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TacoDAO {

    private int id_taco;
    private String tipo_taco;
    private float costo, precio;


    public int getId_taco() {
        return id_taco;
    }

    public void setId_taco(int id_taco) {
        this.id_taco = id_taco;
    }

    public String getTipo_taco() {
        return tipo_taco;
    }

    public void setTipo_taco(String tipo_taco) {
        this.tipo_taco = tipo_taco;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }



    private Connection con;
    public TacoDAO(){
        con = conexion.con;

    }
    public void insTaco(){

        String query = "insert into taco" + "(tipo_taco, costo, precio) " +
                "values('"+tipo_taco+"',"+costo+","+precio+")";

        try{

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updTaco(){
        String query = "update taco set tipo_taco='"+tipo_taco+"', costo="+costo+", precio="+precio+"";
        try{

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void delTaco(){
        String query= "delete from taco where id_taco="+id_taco;
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e)  {
            e.printStackTrace();
        }
    }
    public ObservableList<TacoDAO> selAllTaco(){

        ObservableList<TacoDAO> listaP = FXCollections.observableArrayList();
        TacoDAO objP = null;
        String query ="select * from taco order by tipo_taco";
        try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){
                objP = new TacoDAO();
                objP.setId_taco(res.getInt("id_taco"));
                objP.setTipo_taco(res.getString("tipo_taco"));
                objP.setCosto(res.getFloat("costo"));
                objP.setPrecio(res.getFloat("precio"));
                listaP.add(objP);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaP;
    }

}
