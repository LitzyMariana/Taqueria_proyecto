package sample.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.Componentes.ButtonCell;
import sample.Modelos.TacoDAO;


public class CRUDTaco extends  Stage {

    private Scene escena;
    private VBox Vbox;
    private TableView<TacoDAO> tbvTaco;
    private Button btnAgregar;
    private TacoDAO objP;

    public CRUDTaco(){

        objP = new TacoDAO();
        CrearGUI();
        this.setTitle("Taqueria L & R");
        this.setScene(escena);
        this.show();
    }

    private void CrearGUI() {

        Vbox = new VBox();
        tbvTaco = new TableView<>();
        CrearTabla();
        btnAgregar = new Button("Agregar Taco");
        btnAgregar.setOnAction(event -> AgregarTaco());
        Vbox.getChildren().addAll(tbvTaco,btnAgregar);
        escena = new Scene(Vbox,575,450);

    }

    private void CrearTabla() {
        TableColumn<TacoDAO, Integer> tbcid_taco = new TableColumn<>("ID");
        tbcid_taco.setCellValueFactory(new PropertyValueFactory<>("id_taco"));

        TableColumn<TacoDAO, String> tbctipo_taco = new TableColumn<>("Descripción");
        tbctipo_taco.setCellValueFactory(new PropertyValueFactory<>("tipo_taco"));

        TableColumn<TacoDAO, Float> tbccosto = new TableColumn<>("Costo");
        tbccosto.setCellValueFactory(new PropertyValueFactory<>("costo"));

        TableColumn<TacoDAO, Float> tbcprecio = new TableColumn<>("Precio");
        tbcprecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<TacoDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(
                new Callback<TableColumn<TacoDAO, String>, TableCell<TacoDAO, String>>() {
                    @Override
                    public TableCell<TacoDAO, String> call(TableColumn<TacoDAO, String> param) {
                        return new ButtonCell(1);
                    }
                }
        );

        TableColumn<TacoDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<TacoDAO, String>, TableCell<TacoDAO, String>>() {
                    @Override
                    public TableCell<TacoDAO, String> call(TableColumn<TacoDAO, String> param) {
                        return new ButtonCell(2);
                    }
                }
        );

        tbvTaco.getColumns().addAll(tbcid_taco,tbctipo_taco,tbccosto,tbcprecio,tbcEditar,tbcBorrar);
        tbvTaco.setItems(objP.selAllTaco());
    }

    private void AgregarTaco() {
        new FrmTaco(tbvTaco, null);

    }
}
