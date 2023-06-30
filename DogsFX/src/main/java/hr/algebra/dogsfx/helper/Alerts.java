package hr.algebra.dogsfx.helper;

import javafx.scene.control.Alert;

import java.util.Objects;

public class Alerts {

    public static void showAlert(Alert.AlertType alertType, String title, String header, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void showInfoAlert(String header, String message) {
        Alerts.showAlert(Alert.AlertType.INFORMATION, "Info Dialog", header, message);
    }

    public static void showErrorAlert(String header, String message) {
        Alerts.showAlert(Alert.AlertType.ERROR, "Error Dialog", header, message);
    }

    public static void showWarningAlert(String header, String message) {
        Alerts.showAlert(Alert.AlertType.WARNING, "Warning Dialog", header, message);
    }

    public static void checkName(String name) {
        if(!name.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$") || name.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Wrong value");
            alert.setContentText("The name should consist solely of letters.");

            alert.showAndWait();
        }
    }

    public static void notFound(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Not found");
        alert.setContentText("The specified "+text+" does not exist.");

        alert.showAndWait();
    }
}