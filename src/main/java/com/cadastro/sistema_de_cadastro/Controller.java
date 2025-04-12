package com.cadastro.sistema_de_cadastro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable { //implements é para estender uma interface (Initializable)

    //Declaração das variaveis de controle (SceneBuilder faz):
    @FXML
    private AnchorPane body;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnEditar;

    @FXML
    private RadioButton btnFem;

    @FXML
    private RadioButton btnMasc;

    @FXML
    private Button btnSalvar;

    @FXML
    private GridPane grid;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private TableView<?> table;

    @FXML
    private Label tituloCadastro;

    @FXML
    private TableColumn<?, ?> tv_idade;

    @FXML
    private TableColumn<?, ?> tv_matricula;

    @FXML
    private TableColumn<?, ?> tv_nome;

    @FXML
    private TableColumn<?, ?> tv_sexo;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //método obrigatório

    }
    //testando
    @FXML
    void testeAlert(ActionEvent event) {
        String nome = txtNome.getText().toString();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Testando");
        alert.setHeaderText("Ótimo!");
        alert.setContentText("parabens "+ nome +", funcionou!");
        alert.show();
    }
}
