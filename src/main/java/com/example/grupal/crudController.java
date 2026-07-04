package com.example.grupal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class crudController {

    @FXML
    private Label lblAlerta;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtIsbn;

    @FXML
    private ComboBox<String> cbGenero;

    @FXML
    private TableView<Libro> tblLibros;

    @FXML
    private TableColumn<Libro, Integer> colId;

    @FXML
    private TableColumn<Libro, String> colTitulo;

    @FXML
    private TableColumn<Libro, String> colAutor;

    @FXML
    private TableColumn<Libro, Integer> colAnio;

    @FXML
    private TableColumn<Libro, String> colIsbn;

    @FXML
    private TableColumn<Libro, String> colGenero;

    @FXML
    public void initialize() {
        iniciarComboBox();
        iniciarColumnas();
        cargarLibros();
        capturarSeleccion();
    }

    @FXML
    public void iniciarComboBox() {
        cbGenero.getItems().addAll(
                "Novela",
                "Ciencia Ficción",
                "Fantasía",
                "Romance",
                "Historia",
                "Infantil",
                "Biografía"
        );
    }

    @FXML
    public void iniciarColumnas() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
    }

    @FXML
    public void capturarSeleccion() {
        tblLibros.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {

            if (newVal != null) {
                txtTitulo.setText(newVal.getTitulo());
                txtAutor.setText(newVal.getAutor());
                txtAnio.setText(String.valueOf(newVal.getAnio()));
                txtIsbn.setText(newVal.getIsbn());
                cbGenero.setValue(newVal.getGenero());
            }

        });
    }

    @FXML
    public void limpiarCampos() {
        txtTitulo.clear();
        txtAutor.clear();
        txtAnio.clear();
        txtIsbn.clear();
        cbGenero.setValue(null);
    }

    @FXML
    public void cargarLibros() {

        ObservableList<Libro> lista = FXCollections.observableArrayList();

        String sql = "SELECT * FROM libros";

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Libro libro = new Libro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio"),
                        rs.getString("isbn"),
                        rs.getString("genero")
                );

                lista.add(libro);
            }

            tblLibros.setItems(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void guardarLibro() {

        if (txtTitulo.getText().isEmpty() ||
                txtAutor.getText().isEmpty() ||
                txtAnio.getText().isEmpty() ||
                txtIsbn.getText().isEmpty() ||
                cbGenero.getValue() == null) {

            lblAlerta.setText("Complete todos los campos.");
            return;
        }

        String sql = "INSERT INTO libros (titulo, autor, anio, isbn, genero) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtTitulo.getText());
            ps.setString(2, txtAutor.getText());
            ps.setInt(3, Integer.parseInt(txtAnio.getText()));
            ps.setString(4, txtIsbn.getText());
            ps.setString(5, cbGenero.getValue());

            ps.executeUpdate();

            lblAlerta.setText("Libro guardado correctamente.");

            limpiarCampos();
            cargarLibros();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void eliminarLibro() {

        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            String sql = "DELETE FROM libros WHERE id = ?";

            try {

                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, seleccionado.getId());

                ps.executeUpdate();

                lblAlerta.setText("Libro eliminado correctamente.");

                limpiarCampos();
                cargarLibros();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void editarLibro() {

        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {

            String sql = "UPDATE libros SET titulo = ?, autor = ?, anio = ?, isbn = ?, genero = ? WHERE id = ?";

            try {

                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, txtTitulo.getText());
                ps.setString(2, txtAutor.getText());
                ps.setInt(3, Integer.parseInt(txtAnio.getText()));
                ps.setString(4, txtIsbn.getText());
                ps.setString(5, cbGenero.getValue());
                ps.setInt(6, seleccionado.getId());

                ps.executeUpdate();

                lblAlerta.setText("Libro actualizado correctamente.");

                limpiarCampos();
                cargarLibros();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}