package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import sample.Login.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnCancelar, btnIngresar;
    @FXML
    private Label lblErrorLogin;
    @FXML
    private ImageView imgTaco , imgUser;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private ComboBox<roles> cmbRol;

    usuario  user;

    LoginDAO loginDAO = new LoginDAO(conexion.getConnection());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File TacoFile  = new File("Imagenes/taco.png");
        Image TacoImage = new Image(TacoFile.toURI().toString());
        imgTaco.setImage(TacoImage);

        File UserFile  = new File("Imagenes/user.png");
        Image UserImage = new Image(UserFile.toURI().toString());
        imgUser.setImage(UserImage);

        //initLogin();
        /*btnIngresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    validarUsuarios();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
        //btnCancelar.setOnAction(handlerCancel);

    }

    public  void loginButtonOnAction(ActionEvent event){

        if(txtUsuario.getText().equals(null)==false&& txtContrasena.getText().equals(null)==false){
            validarLogin();
        }else {
            lblErrorLogin.setText("Ingresa un usuario y su contraseña");
        }

    }

    public void btnCancelarOnAction(ActionEvent event){
        Stage stage =(Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    public void validarLogin(){

        //conexion conectarAhora = new conexion();
        Connection conectarBD = conexion.getConnection();

        String verificarLogin = "SELECT count(1) FROM usuario WHERE nombre = '"+txtUsuario.getText()+"' AND contraseña= '"+txtContrasena.getText()+"'";

        try {

            Statement st = conectarBD.createStatement();
            ResultSet rs = st.executeQuery(verificarLogin);

            while (rs.next()){
                if (rs.getInt(1)==1){

                    if (txtUsuario.getText().equals("Litzy")){

                        showStageAdmin();

                    }else {
                        showStageMesero();
                    }

                }else {
                    lblErrorLogin.setText("Login invalido");

                }

            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    /*private void initLogin()
    {
        cmbRol.setItems(loginDAO.fetchRol());
    }*/

    /*public void validarUsuarios() throws IOException {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        Alert alertUser= new Alert(Alert.AlertType.INFORMATION);

        user = loginDAO.finIdRol(txtUsuario.getText());

        if (loginDAO.validUser(txtUsuario.getText(), txtContrasena.getText())) {

            if (user.getId_rol()==1)
            {
                if(user.getId_rol() == cmbRol.getSelectionModel().getSelectedIndex()+1) {
                    showStageAdmin();
                    ((Stage) (btnIngresar.getScene().getWindow())).hide();
                }else
                {
                    alertUser.setContentText("Este usuario no tiene ese rol");
                    alertUser.show();
                }
            }else if (user.getId_rol()==2)
            {
                if(user.getId_rol() == cmbRol.getSelectionModel().getSelectedIndex()+1) {
                    showStageMesero();
                    ((Stage) (btnIngresar.getScene().getWindow())).hide();
                }else
                {
                    alertUser.setContentText("Este usuario no tiene ese rol");
                    alertUser.show();
                }
            }

        } else {
            alert.setContentText("Usuario Inconrrecto");
            alert.show();
        }

    }*/

    /*EventHandler<ActionEvent> handlerCancel = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            cmbRol.valueProperty().setValue(null);

            txtUsuario.setText("");
            txtContrasena.setText("");
        }
    };*/

    public void showStageAdmin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("recepcionAdmin.fxml"));
        Stage st= new Stage();
        st.setTitle("ADMINISTRADOR");

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        st.setScene(scene);
        st.initStyle( StageStyle.TRANSPARENT );
        st.setMaximized(true);
        st.show();
    }

    public void showStageMesero() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("recepcionMesero.fxml"));
        Stage st= new Stage();
        st.setTitle("CAPTURISTA");

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        st.setScene(scene);
        st.initStyle( StageStyle.TRANSPARENT );
        st.setMaximized(true);
        st.show();
    }




}
