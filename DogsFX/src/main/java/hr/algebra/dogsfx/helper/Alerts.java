package hr.algebra.dogsfx.helper;

import javafx.scene.control.Alert;

import java.util.Objects;

public class Alerts {
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

//    static void checkPrice(String price) {              // real numbers
//        if(price.equals("") || !price.matches("((\\+|-)?([0-9]+)(\\.[0-9]+)?)|((\\+|-)?\\.?[0-9]+)")
//                || Double.parseDouble(price) < 0.0 || Double.parseDouble(price) > 99999.0) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Dialog");
//            alert.setHeaderText("Wrong value");
//            alert.setContentText("The price should be larger than 0.0 and smaller than 99999.0.");
//
//            alert.showAndWait();
//        }
//    }
//
//    static void checkStock(String stock) { // positive, non null integer regex
//        if(!stock.matches("^[1-9]\\d*$") || Integer.parseInt(stock) < 1 || Integer.parseInt(stock) > 10000) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Dialog");
//            alert.setHeaderText("Wrong value");
//            alert.setContentText("The stock should be larger than 0 and less than 10000.");
//
//            alert.showAndWait();
//        }
//    }
//
//    static void checkType(String type) {
//        if(!Objects.equals(type, CPU.toString()) && !Objects.equals(type, GPU.toString()) &&
//                !Objects.equals(type, MBO.toString()) && !Objects.equals(type, RAM.toString()) &&
//                !Objects.equals(type, STORAGE.toString()) && !Objects.equals(type, OTHER.toString())) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Dialog");
//            alert.setHeaderText("Wrong value");
//            alert.setContentText("The type should be one of the following: CPU, GPU, MBO, RAM, STORAGE, OTHER");
//
//            alert.showAndWait();
//        }
//    }
//
//    static void checkCode(String code) {
//        if(code.matches("^\\d{7}$") == false) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Dialog");
//            alert.setHeaderText("Wrong value");
//            alert.setContentText("The code should have exactly 7 digits.");
//
//            alert.showAndWait();
//        }
//    }
}