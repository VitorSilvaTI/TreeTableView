package controllers;

import beans.ClientBeans;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dao.ClientDao;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Vitor da Silva Nascimento
 *
 * **/

public class TreeTableViewScreenController implements Initializable {

    /* Definição de cada coluna da tabela (obs: foram feitas no SceneBuilder); */

    @FXML
    private JFXTreeTableView<ClientBeans> tbTreeView;

    @FXML
    private TreeTableColumn<ClientBeans, Integer> coId;

    @FXML
    private TreeTableColumn<ClientBeans, String> coName;

    @FXML
    private TreeTableColumn<ClientBeans, String> coCpf;

    @FXML
    private TreeTableColumn<ClientBeans, String> coNumber;

    @FXML
    private TreeTableColumn<ClientBeans, String> coProfession;

    @FXML
    private TreeTableColumn<ClientBeans, String> coIde;

    @FXML
    private JFXTextField tfSearch;

    ClientDao dao = new ClientDao();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showValuesTable();
        searchByCpf();
    }

    public void showValuesTable() {

        // Pegando valores dos gets do client;

        coId.setCellValueFactory(date -> new SimpleIntegerProperty(date.getValue().getValue().getId()).asObject());
        coName.setCellValueFactory(date -> new SimpleStringProperty(date.getValue().getValue().getName()));
        coCpf.setCellValueFactory(date -> new SimpleStringProperty(date.getValue().getValue().getCpf()));
        coNumber.setCellValueFactory(date -> new SimpleStringProperty(date.getValue().getValue().getNumber()));
        coProfession.setCellValueFactory(date -> new SimpleStringProperty(date.getValue().getValue().getProfession()));
        coIde.setCellValueFactory(date -> new SimpleStringProperty(date.getValue().getValue().getIde()));

        /* o observable recebe o metodo do tipo arrayList onde o atributo clients recebe todos os valores que sao retornados
            no root ele recebe esse metodo passando os clientes e no set root ele vai setar todos valores na tabela
            como se fosse o setItems da tableView; */

        ObservableList<ClientBeans> clients = FXCollections.observableArrayList(dao.selectInformation());
        final TreeItem<ClientBeans> root = new RecursiveTreeItem<>(clients, RecursiveTreeObject::getChildren);

        tbTreeView.setRoot(root);
        tbTreeView.setShowRoot(false);

    }

    public void searchByCpf(){
        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> tbTreeView.setPredicate(clientBeans -> clientBeans.getValue().getCpf().contains(newValue)));
    }
}
