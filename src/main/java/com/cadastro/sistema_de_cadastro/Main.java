package com.cadastro.sistema_de_cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage janela;  //o Stage é a janela da aplicação, é como a moldura onde tudo aparece
                   //em um navegador de internet, a janela do navegador seria o Stage.
                   // e o que está dentro da janela, como o site carregado, seria a Scene.
    @Override
    public void start(Stage stage) throws Exception { // O método start é obrigatório em qualquer aplicação JavaFX.
                                                      // Ele é chamado automaticamente quando a aplicação inicia.
                                                      //O parâmetro stage é fornecido pelo sistema e representa
                                                      // a janela principal da aplicação.
        janela = stage;

        //carregando o layout da interface gráfica definido no arquivo telaPrincipal.fxml.
        Parent tela = FXMLLoader.load(getClass().getResource("telaPrincipal.fxml"));

        Scene scene = new Scene(tela);//A Scene representa o conteúdo que será exibido dentro da janela (Stage).
                                      //Esta criando a cena com a interface carregada do FXML.

        janela.setScene(scene); //define que o conteúdo da janela principal será a scene criado anteriormente
        janela.show();          //exibe a janela na tela
    }

}

