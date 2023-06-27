module com.example.java_giorgi_kurdadze {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens com.example.java_giorgi_kurdadze to javafx.fxml;
    exports com.example.java_giorgi_kurdadze;
}