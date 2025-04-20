package com.cadastro.sistema_de_cadastro.controller;

import com.cadastro.sistema_de_cadastro.dao.EstudanteDAO;
import com.cadastro.sistema_de_cadastro.model.Estudante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.List;
import java.util.Optional;
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
    private TableView table;

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

    Estudante estudante = new Estudante();
    EstudanteDAO estudanteDAO = new EstudanteDAO();

    private List<Estudante> todosEstudantes;
    private ObservableList<Estudante> observableListEstudante;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //método obrigatório

        preparaListaTabela();

        ocultarBotoes();
    }


    @FXML
    public void salvar(ActionEvent event) {
        if (validador()) {
            estudante.setNome(txtNome.getText().toString());
            estudante.setIdade(Integer.valueOf(txtIdade.getText().toString()));

            if (btnMasc.isSelected()) {
                estudante.setSexo("Masculino");
            } else if (btnFem.isSelected()) {
                estudante.setSexo("Feminino");
            }

            estudanteDAO.inserir(estudante);
            preparaListaTabela();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setContentText("Aluno adicionado com sucesso!");
            alert.show();

            limparCampos();

            System.out.println("Estudante salvo no banco de dados!");
        }
    }

    @FXML
    public void editar(ActionEvent event){

        if(validador()){
            estudante.setNome(txtNome.getText().toString());
            estudante.setIdade(Integer.valueOf(txtIdade.getText().toString()));

            if (btnMasc.isSelected()) {
                estudante.setSexo("Masculino");
            } else if (btnFem.isSelected()) {
                estudante.setSexo("Feminino");
            }

            estudanteDAO.editar(estudante, estudante.getId());
            preparaListaTabela();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setContentText("Aluno editado com sucesso!");
            alert.show();
            limparCampos();

            btnEditar.setVisible(false);
            btnDeletar.setVisible(false);
        }

        btnSalvar.setVisible(true);

    }

    @FXML
    public void deletar(ActionEvent event){

        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação de exclusão");
        alert.setHeaderText("Deseja mesmo excluir esse item?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK){
            estudanteDAO.apagar(estudante.getId());
            preparaListaTabela();
            limparCampos();
        }
        btnDeletar.setVisible(false);

    }

    // método chamado todda vez q seleciona algo na tabela, então preenche os campos de estudante
    @FXML
    void preencherCampos(MouseEvent event){

        estudante = (Estudante) table.getSelectionModel().getSelectedItem(); //Estudante em que o usuárioo clickou na tabela

        if(estudante != null){

            btnEditar.setVisible(true);
            btnDeletar.setVisible(true);
            btnSalvar.setVisible(false);

            txtNome.setText(estudante.getNome());
            txtIdade.setText(String.valueOf(estudante.getIdade()));

            if(estudante.getSexo().equals("Masculino")){
                btnMasc.setSelected(true);
            }else if (estudante.getSexo().equals("Feminino")){
                btnFem.setSelected(true);
            }
        }

    }

        //
    void preparaListaTabela(){

        tv_matricula.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tv_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tv_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        todosEstudantes = estudanteDAO.buscarTodos();

        observableListEstudante = FXCollections.observableList(todosEstudantes);

        table.setItems(observableListEstudante);

    }


    //Método para verificar se os campos foram preenchidos
    public boolean validador(){
        StringBuffer mensagem = new StringBuffer();

        if(txtNome.getText().equals("")){
            mensagem.append("O campo Nome é obrigatório!\n");
        }
        if(txtIdade.getText().equals("")){
        mensagem.append("O campo Idade é obrigatório!\n");
        }

        if(mensagem.length() > 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setHeaderText("ERRO");
            alert.setContentText(mensagem.toString());
            alert.show();

            return false;
        }else{
            return true;
        }

    }

    void limparCampos(){
        txtNome.setText("");
        txtIdade.setText("");
    }

    void ocultarBotoes(){
        this.btnEditar.setVisible(false);
        this.btnDeletar.setVisible((false));
    }


}
