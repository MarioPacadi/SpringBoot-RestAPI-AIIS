package hr.algebra.dogsfx;

import hr.algebra.dogsfx.api.DogClient;
import hr.algebra.dogsfx.helper.Alerts;
import hr.algebra.dogsfx.helper.SerializationWhitelist;
import hr.algebra.dogsfx.model.DogBreed;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogClientApplication extends Application {

    private DogClient dogClient;

    private TableView<DogBreed> dogTable;
    private TextField breedNameField;
    private TextField breedTypeField;
    private TextArea breedDescriptionArea;
    private Button saveButton;
    private Button updateButton;
    private Button deleteButton;
    private Button exportButton;
    private Button importButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        dogClient = new DogClient();

        // Initialize UI components
        dogTable = new TableView<>();
        breedNameField = new TextField();
        breedTypeField = new TextField();
        breedDescriptionArea = new TextArea();
        saveButton = new Button("Save");
        updateButton = new Button("Update");
        deleteButton = new Button("Delete");
        exportButton = new Button("Export");
        importButton = new Button("Import");

        Button loadButton = new Button("Load Dog Breeds");
        Button getButton = new Button("Get Dog Breed");

        // Set column names and cell values for the table
        TableColumn<DogBreed, String> breedNameColumn = new TableColumn<>("Breed Name");
        breedNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBreedName()));
        TableColumn<DogBreed, String> breedTypeColumn = new TableColumn<>("Breed Type");
        breedTypeColumn.setCellValueFactory(data ->new SimpleStringProperty(data.getValue().getBreedType()));
        TableColumn<DogBreed, String> breedDescriptionColumn = new TableColumn<>("Breed Description");
        breedDescriptionColumn.setCellValueFactory(data ->new SimpleStringProperty(data.getValue().getBreedType()));

        dogTable.getColumns().addAll(breedNameColumn, breedTypeColumn,breedDescriptionColumn);

        // Set table selection listener
        dogTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                DogBreed selectedDog = dogTable.getSelectionModel().getSelectedItem();
                breedNameField.setText(selectedDog.getBreedName());
                breedTypeField.setText(selectedDog.getBreedType());
                breedDescriptionArea.setText(selectedDog.getBreedDescription());
            } else {
                clearFields();
            }
        });

        // Set event handlers for buttons
        saveButton.setOnAction(event -> saveDog());
        updateButton.setOnAction(event -> updateDog());
        deleteButton.setOnAction(event -> deleteDog());
        exportButton.setOnAction(event -> exportDogBreed());
        importButton.setOnAction(event -> importDogBreed(primaryStage));

        loadButton.setOnAction(event -> loadDogBreeds());
        getButton.setOnAction(event -> getDogBreed());

        // Create layout
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        HBox topBox=new HBox(loadButton, getButton);
        topBox.setSpacing(10);

        root.getChildren().addAll(
                topBox,
                dogTable,
                createForm(),
                createButtonBar()
        );

        // Set the scene
        Image icon=new Image(Objects.requireNonNull(getClass().getResourceAsStream("/hr/algebra/dogsfx/images/WatchDog.png")));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Dog Client");
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    private void loadDogBreeds() {
        List<DogBreed> dogs = dogClient.getAllDogs();
        dogTable.setItems(FXCollections.observableArrayList(dogs));
        clearFields();
    }

    private void refreshDogTable() {
        List<DogBreed> dogs = dogClient.getAllDogs();
        dogTable.setItems(FXCollections.observableArrayList(dogs));
        clearFields();
    }

    private void cleanDogTable() {
        dogTable.setItems(FXCollections.observableArrayList());
        clearFields();
    }

    private void clearFields() {
        breedNameField.clear();
        breedTypeField.clear();
        breedDescriptionArea.clear();
    }

    private void getDogBreed() {
        String breedName = breedNameField.getText();
        DogBreed dog = dogClient.getByName(breedName);
        if (dog != null) {
            breedTypeField.setText(dog.getBreedType());
            breedDescriptionArea.setText(dog.getBreedDescription());
        } else {
            clearFields();
            Alerts.notFound(breedName);
        }
    }

    private GridPane createForm() {
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        Label breedNameLabel = new Label("Breed Name:");
        breedNameField.setPromptText("Enter breed name");

        Label breedTypeLabel = new Label("Breed Type:");
        breedTypeField.setPromptText("Enter breed type");

        Label breedDescriptionLabel = new Label("Breed Description:");
        breedDescriptionArea.setPrefRowCount(3);
        breedDescriptionArea.setPromptText("Enter breed description");

        form.addColumn(0, breedNameLabel, breedTypeLabel, breedDescriptionLabel);
        form.addColumn(1, breedNameField, breedTypeField, breedDescriptionArea);

        return form;
    }

    private HBox createButtonBar() {
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(10);
        buttonBar.getChildren().addAll(saveButton, updateButton, deleteButton, exportButton, importButton);

        return buttonBar;
    }

    private void saveDog() {
        String breedName = breedNameField.getText();
        String breedType = breedTypeField.getText();
        String breedDescription = breedDescriptionArea.getText();

        DogBreed dog = new DogBreed(breedName, breedType, breedDescription);
        dogClient.saveDog(dog);
        refreshDogTable();
    }

    private void updateDog() {
        DogBreed selectedDog = dogTable.getSelectionModel().getSelectedItem();
        if (selectedDog != null) {
            String breedName = breedNameField.getText();
            String breedType = breedTypeField.getText();
            String breedDescription = breedDescriptionArea.getText();

            DogBreed updatedDog = new DogBreed(breedName, breedType, breedDescription);
            dogClient.updateDog(selectedDog.getBreedName(), updatedDog);
            refreshDogTable();
        }
    }

    private void deleteDog() {
        DogBreed selectedDog = dogTable.getSelectionModel().getSelectedItem();
        if (selectedDog != null) {
            dogClient.deleteDog(selectedDog.getBreedName());
            refreshDogTable();
        }
    }
    private void exportDogBreed() {
        List<DogBreed> dogBreeds = new ArrayList<>(dogTable.getItems());
        if (!dogBreeds.isEmpty()) {
            // Perform serialization to .ser file using ObjectOutputStream
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dogBreeds.ser"))) {
                oos.writeObject(dogBreeds);
                Alerts.showInfoAlert("Export Successful", "The dog breeds have been exported successfully.");
            } catch (FileNotFoundException e) {
                Alerts.showErrorAlert("Export Failed", "File not found.");
                throw new RuntimeException(e);
            } catch (IOException e) {
                Alerts.showErrorAlert("Export Failed", "An error occurred during export.");
                throw new RuntimeException(e);
            }
        } else {
            Alerts.showWarningAlert("No Dog Breeds", "There are no dog breeds to export.");
        }
    }

    private void importDogBreed(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files (*.ser)", "*.ser"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile))) {
                Object obj = ois.readObject();

                if (obj instanceof List<?> importedList) {
                    List<DogBreed> importedBreeds = new ArrayList<>();

                    for (Object importedObj : importedList) {
                        if (importedObj instanceof DogBreed importedBreed && SerializationWhitelist.isClassAllowed(importedObj.getClass())) {
                            importedBreeds.add(importedBreed);
                        } else {
                            Alerts.showErrorAlert("Invalid File", "The selected file contains invalid dog breeds.");
                            return; // Exit method if any invalid breed is found
                        }
                    }

                    dogTable.getItems().addAll(importedBreeds);
                    Alerts.showInfoAlert("Import Successful", "The dog breeds have been imported successfully.");
                } else {
                    Alerts.showErrorAlert("Invalid File", "The selected file does not contain valid dog breeds.");
                }
            } catch (IOException | ClassNotFoundException e) {
                Alerts.showErrorAlert("Import Failed", "An error occurred during import.");
            }
        } else {
            Alerts.showWarningAlert("Error", "An error occurred while selecting the file.");
        }
    }


//    private void exportDogBreed() {
//        DogBreed selectedDog = dogTable.getSelectionModel().getSelectedItem();
//        if (selectedDog != null) {
//            // Perform serialization to .ser file using ObjectOutputStream
//            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dogBreed.ser"))) {
//                oos.writeObject(selectedDog);
//                Alerts.showInfoAlert("Export Successful", "The dog breed has been exported successfully.");
//            } catch (FileNotFoundException e) {
//                Alerts.showErrorAlert("Export Failed", "File not found.");
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                Alerts.showErrorAlert("Export Failed", "An error occurred during export.");
//                throw new RuntimeException(e);
//            }
//        } else {
//            Alerts.showWarningAlert("No Dog Breed Selected", "Please select a dog breed to export.");
//        }
//    }
//
//
//    private void importDogBreed(Stage primaryStage) {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Files (*.ser)", "*.ser"));
//        File selectedFile = fileChooser.showOpenDialog(primaryStage); // Replace primaryStage with your stage instance
//
//        if (selectedFile != null) {
//            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(selectedFile))) {
//                Object obj = ois.readObject();
//
//                if (obj instanceof DogBreed importedBreed) {
//                    dogTable.getItems().add(importedBreed);
//                    Alerts.showInfoAlert("Import Successful", "The dog breed has been imported successfully.");
//                } else {
//                    Alerts.showErrorAlert("Invalid File", "The selected file does not contain a valid dog breed.");
//                }
//            } catch (IOException | ClassNotFoundException e) {
//                Alerts.showErrorAlert("Import Failed", "An error occurred during import.");
//            }
//        } else {
//            Alerts.showWarningAlert("Error", "An error occurred while selecting file");
//        }
//    }

}
