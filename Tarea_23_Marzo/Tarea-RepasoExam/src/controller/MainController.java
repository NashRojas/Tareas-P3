package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Producto;

public class MainController {
    
    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colNombre;
    
    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colCantidad;

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label lblEstado;

    private ObservableList<Producto> listaProductos;


    @FXML
    private void abrirFormulario(){
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/formulario.fxml"));
        Parent root = loader.load();

        FormularioController controller = loader.getController();
        
        controller.setCallback(producto -> {
            listaProductos.add(producto);
        });

        Stage stage = new Stage();
        stage.setTitle("Nuevo Producto");
        stage.setScene(new Scene(root));
        stage.show();
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }

    @FXML
private void eliminarProducto() {

    Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        mostrarAlerta("Seleccione un producto", Alert.AlertType.WARNING);
        return;
    }

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    confirm.setTitle("Confirmar");
    confirm.setHeaderText(null);
    confirm.setContentText("¿Eliminar producto?");

    confirm.showAndWait().ifPresent(respuesta -> {
        if (respuesta == ButtonType.OK) {
            listaProductos.remove(seleccionado);
        }
    });
}

private void mostrarAlerta(String msg, Alert.AlertType tipo) {
    Alert alert = new Alert(tipo);
    alert.setTitle("Mensaje");
    alert.setHeaderText(null);
    alert.setContentText(msg);
    alert.showAndWait();
}

    @FXML
    public void initialize() {
        listaProductos = FXCollections.observableArrayList();

        colNombre.setCellValueFactory(data -> data.getValue().nombreProperty());
        colCategoria.setCellValueFactory(data -> data.getValue().categoriaProperty());
        colPrecio.setCellValueFactory(data -> data.getValue().precioProperty().asObject());
        colCantidad.setCellValueFactory(data -> data.getValue().cantidadProperty().asObject());
        
        tablaProductos.setItems(listaProductos);

        lblEstado.setText("Aplicacion iniciada");

        listaProductos.add(new Producto("Laptop", "Electronica", 1200, 5));
    }
}
