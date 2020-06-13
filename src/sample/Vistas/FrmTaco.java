package sample.Vistas;

import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import sample.Modelos.TacoDAO;

public class FrmTaco extends Stage {

    private TacoDAO objP;
    private TableView<TacoDAO> tbvTaco;
    private VBox vBox;
    private TextField txtDesc,txtCosto,txtPrecio;
    private Button btnGuardar;
    private Scene escena;



    public FrmTaco(TableView<TacoDAO> tbvTaco, TacoDAO obj){

        if(obj != null)
            objP = obj;

        else
            objP = new TacoDAO();

        this.tbvTaco = tbvTaco;
        CrearGUI();
        this.setTitle("Gestión de Tacos");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {


        vBox = new VBox();

        txtDesc = new TextField();
        txtDesc.setText(objP.getTipo_taco());
        txtDesc.setPromptText("Introduce el tipo de Taco");

        txtCosto = new TextField();
        txtCosto.setText(objP.getCosto()+"");
        txtCosto.setPromptText("Introduce el Costo");

        txtPrecio = new TextField();
        txtPrecio.setText(objP.getPrecio()+"");
        txtPrecio.setPromptText("Introduce el Precio");



        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> saveData());
        vBox.getChildren().addAll(txtDesc,txtCosto,txtPrecio,btnGuardar);
        escena = new Scene(vBox,500,500);


    }

    private void saveData() {

        objP.setTipo_taco(txtDesc.getText());
        objP.setCosto(Float.parseFloat(txtCosto.getText()));
        objP.setPrecio(Float.parseFloat(txtPrecio.getText()));

        //tengo duda
        if ( objP.getId_taco() >= 1 )
            objP.updTaco();
        else
            objP.insTaco();

        tbvTaco.setItems(objP.selAllTaco());
        tbvTaco.refresh();
        this.close();
    }
}
