package model;

import javafx.beans.property.*;


public class Producto {
    
    private StringProperty nombre;
    private StringProperty categoria;
    private DoubleProperty precio;
    private IntegerProperty cantidad;

    public Producto(String nombre, String categoria, double precio, int cantidad ) {
        this.nombre = new SimpleStringProperty(nombre);
        this.categoria = new SimpleStringProperty(categoria);
        this.precio = new SimpleDoubleProperty(precio);
        this.cantidad = new SimpleIntegerProperty(cantidad);
    }


    public String getNombre() { 
        return nombre.get();
    }
    public String getCategoria() { 
        return categoria.get(); 
    }

    public double getPrecio() {
        return precio.get();
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty categoriaProperty() {
        return categoria;
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public IntegerProperty cantidadProperty() {
        return cantidad;
    }

    @Override
    public String toString() {
        return getNombre() + "," + getCategoria() + "," + getPrecio() + "," + getCantidad();
    }
}
