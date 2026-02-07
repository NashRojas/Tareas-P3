package Paquete_tarea_6_7;

public class Inventario {
    
    public static void ejecutar(){
        Producto[] inventario = new Producto[3];

        inventario[0] = new Producto("Laptop", 50000, 2);
        inventario[1] = new Producto("Mouse", 800, 0);
        inventario[2] = new Producto("Teclado", 2000, 5);

        double total = 0;

        for (Producto p : inventario) {
            total += p.getPrecio() * p.getStock();
        }

        System.out.println("Valor total del inventario: " + total);

        System.out.println("Productos con stock disponible: ");
        for (Producto p : inventario) {
            if (p.getStock() > 0) {
                System.out.println(p.getNombre());
            }
        }
    }
}
