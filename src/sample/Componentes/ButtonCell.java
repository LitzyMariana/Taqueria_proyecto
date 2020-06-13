package sample.Componentes;

import javafx.scene.control.*;
import sample.Modelos.TacoDAO;
import sample.Vistas.FrmTaco;

import java.util.Optional;

public class ButtonCell extends TableCell<TacoDAO,String> {

    private Button btnCelda;
    private TacoDAO objP;
    public ButtonCell(int opc) {
        if (opc == 1) {

            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mensaje del Sistema");
                alert.setHeaderText("Confirmando Acción");
                alert.setContentText("¿Desea eliminar este taco?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get()==ButtonType.OK) {
                    objP = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    objP.delTaco();

                    ButtonCell.this.getTableView().setItems(objP.selAllTaco());
                    ButtonCell.this.getTableView().refresh();
                }

            });

        }
        else {
            btnCelda = new Button("Editar");
            btnCelda.setOnAction(event -> {

                TableView<TacoDAO> tbvTemp;
                tbvTemp=ButtonCell.this.getTableView();
                objP = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                new FrmTaco(tbvTemp,objP);

                objP = ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                objP.updTaco();

            });


        }
    }

    @Override
    protected void updateItem(String item, boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            setGraphic(btnCelda);
    }
}
