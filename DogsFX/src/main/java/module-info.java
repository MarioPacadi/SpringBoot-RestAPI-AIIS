module hr.algebra.dogsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.web;
    requires com.google.gson;

    opens hr.algebra.dogsfx to javafx.fxml;
    exports hr.algebra.dogsfx;
    exports hr.algebra.dogsfx.model;
    opens hr.algebra.dogsfx.model;
}