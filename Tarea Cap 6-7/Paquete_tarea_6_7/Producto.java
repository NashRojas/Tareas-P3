package Paquete_tarea_6_7;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;

        if (precio >= 0) {
            this.precio = precio;
        } else {
            this.precio = precio;
        }

        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = stock;
        }
    }
    
    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getStock(){
        return stock;
    }

    public void vender(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            stock -= cantidad;
        }
    }
}
