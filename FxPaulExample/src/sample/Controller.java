package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    @FXML
    private TableView<Info> tableView;
    @FXML
    private TableColumn<Info, String> tableColumn1;
    @FXML
    private TableColumn<Info, String> tableColumn2;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    private DbProvider sqlProvider;

    private ObservableList<Info> items = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException {
        tableColumn1.setCellValueFactory(new PropertyValueFactory("name"));
        tableColumn2.setCellValueFactory(new PropertyValueFactory("phone"));
        tableView.setItems(items);
        sqlProvider = new DbProvider();
    }

    public void Ok(ActionEvent actionEvent) throws SQLException {
        insert();
        getAll();
        field1.clear();
        field2.clear();
    }

    private boolean insert() throws SQLException {
        String query = "INSERT INTO info VALUES(?, ?)";
        PreparedStatement insertQuery = sqlProvider.createStatement(query);
        insertQuery.setString(1, field1.getText());
        insertQuery.setString(2, field2.getText());
        return insertQuery.execute();
    }

    private void getAll() throws SQLException {
        String selectAllQuery = "SELECT * FROM info";
        ResultSet rs = sqlProvider.createStatement(selectAllQuery).executeQuery();
        rewriteItems(rs);
    }

    private void rewriteItems(ResultSet rs) throws SQLException {
        List<Info> infos = new ArrayList<>();
        while (rs.next()) {
            Info info = new Info(rs.getString("name"), rs.getString("phone"));
            infos.add(info);
        }
        rs.close();
        items.clear();
        items.addAll(infos);
    }
}
