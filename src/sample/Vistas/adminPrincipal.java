package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class adminPrincipal extends Stage {

    private Scene escena;
    private BorderPane contenedor;
    private Label lblTacos, lblBebidas, lblEmpleados, lblRegistros;
    private Button btnSalir;
    private ToolBar tlbmenu;

    public adminPrincipal(){

        CrearGUI();
        this.setTitle("Administrador");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI(){

        tlbmenu = new ToolBar();
        btnSalir = new Button();
        tlbmenu.getItems().add(btnSalir);
        btnSalir.setOnAction(event -> salir());
        contenedor = new BorderPane();
        contenedor.setTop(tlbmenu);
        escena = new Scene(contenedor);

    }

    private void salir(){

    }


}
