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
private void guardarArchivo() {

    if (listaProductos.isEmpty()) {
        mostrarAlerta("Lista vacía", Alert.AlertType.WARNING);
        return;
    }

    new Thread(() -> {
        try {
            util.ArchivoUtil.guardarArchivo(listaProductos);

            javafx.application.Platform.runLater(() -> {
                lblEstado.setText("Guardado correctamente");
                progressBar.setProgress(1);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }).start();
}
@FXML
private void cargarArchivo() {

    Thread hilo = new Thread(() -> {
        try {
            var lista = util.ArchivoUtil.leerArchivo();

            int total = lista.size();

            for (int i = 0; i < total; i++) {
                Producto p = lista.get(i);

                Thread.sleep(200);

                int index = i;

                javafx.application.Platform.runLater(() -> {
                    progressBar.setProgress((double) index / total);
                    lblEstado.setText("Cargando...");
                });
            }

            javafx.application.Platform.runLater(() -> {
                listaProductos.clear();
                listaProductos.addAll(lista);
                lblEstado.setText("Carga completa");
                progressBar.setProgress(1);
            });

        } catch (Exception e) {
            javafx.application.Platform.runLater(() -> {
                lblEstado.setText("No se encontró archivo");
            });
        }
    });

    hilo.setDaemon(true);
    hilo.start();
}

@FXML
private void salir() {

    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    confirm.setTitle("Salir");
    confirm.setHeaderText(null);
    confirm.setContentText("¿Seguro que deseas salir?");

    confirm.showAndWait().ifPresent(respuesta -> {
        if (respuesta == ButtonType.OK) {
            System.exit(0);
        }
    });
}

    @FXML
    public void initialize() {
        cargarArchivo();
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
