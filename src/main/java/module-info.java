module com.cadastro.sistema_de_cadastro {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens com.cadastro.sistema_de_cadastro to javafx.fxml;
    exports com.cadastro.sistema_de_cadastro to javafx.graphics;
    exports com.cadastro.sistema_de_cadastro.model to javafx.graphics;
    opens com.cadastro.sistema_de_cadastro.model to javafx.base, javafx.fxml;
    exports com.cadastro.sistema_de_cadastro.controller to javafx.graphics;
    opens com.cadastro.sistema_de_cadastro.controller to javafx.fxml;

}