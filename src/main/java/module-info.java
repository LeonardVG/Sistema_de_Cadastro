module com.cadastro.sistema_de_cadastro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cadastro.sistema_de_cadastro to javafx.fxml;
    exports com.cadastro.sistema_de_cadastro to javafx.graphics;
}