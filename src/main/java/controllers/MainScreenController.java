package controllers;

import beans.ClientBeans;
import com.jfoenix.controls.JFXTextField;
import dao.ClientDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    /* Atributos para pegar os valores da tela; */

    @FXML private JFXTextField tfName;

    @FXML private JFXTextField tfIde;

    @FXML private JFXTextField tfProfession;

    @FXML private JFXTextField tfNumber;

    @FXML private JFXTextField tfCpf;

    public void initialize(URL location, ResourceBundle resources) {

    }

    /* Metodo para chamar a TreeTableView; */

    @FXML
    public void showTable() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TreeTableViewScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    /* Metodo para salvar as informações no banco de dados; */

    @FXML
    public void saveInformationClients(){
        ClientBeans clientBeans = new ClientBeans(tfName.getText(), tfCpf.getText(), tfNumber.getText(), tfProfession.getText(), tfIde.getText());
        ClientDao dao = new ClientDao();
        dao.saveInformation(clientBeans);
    }
}
