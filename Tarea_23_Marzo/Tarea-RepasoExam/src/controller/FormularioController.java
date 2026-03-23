package controller;

import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Producto;


public class FormularioController {
    
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;

    @FXML
    private void guardar() {

        if (txtNombre.getText().isEmpty() || 
            txtCategoria.getText().isEmpty() ||
            txtPrecio.getText().isEmpty() ||
            txtCantidad.getText().isEmpty())  {

            mostrarAlerta("campos Vacios", Alert.AlertType.WARNING);
            return;
            }

        try { 
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            Producto p = new Producto
            (txtNombre.getText(), txtCategoria.getText(),
            precio, cantidad);

            if (callback != null) {
                callback.accept(p);
            }
            mostrarAlerta("Producto guardado", Alert.AlertType.INFORMATION);

            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            mostrarAlerta("Precio o cantidad invalidos", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private Consumer<Producto> callback;

    public void setCallback(Consumer<Producto> callback){
        this.callback = callback;
    }
}
