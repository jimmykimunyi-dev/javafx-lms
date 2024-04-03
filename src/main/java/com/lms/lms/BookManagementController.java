package com.lms.lms;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class BookManagementController {

    @FXML
    private TableColumn<Book, String> id;

    @FXML
    private TableColumn<Book, String> title;

    @FXML
    private TableColumn<Book, String> author;

    @FXML
    private TableView<Book> bookTable;

    private Stage stage;

    private Scene scene;

    private Parent root;

    private BookDAO bookDAO;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @FXML
    public void switchToMainDashboard(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-dashboard.fxml"));
            Parent root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        try{
            int id = Integer.parseInt(String.valueOf(bookTable.getSelectionModel().getSelectedItem().getId()));
            String title = bookTable.getSelectionModel().getSelectedItem().getTitle();
            String author = bookTable.getSelectionModel().getSelectedItem().getAuthor();

            Book book = new Book(id, title, author);
            bookDAO.save(book);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize(){
        // load data from database
        loadBookData();

        // set data to table
        title.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject().asString());
        author.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject().asString());
        id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject().asString());

        // set data to table
        bookTable.setItems(bookList);

    }

    private void loadBookData(){
        bookList.clear();
        bookList.addAll(DatabaseUtils.getInstance().getAllBooks());
    }
}
