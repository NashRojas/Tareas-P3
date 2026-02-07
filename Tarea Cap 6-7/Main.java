import java.util.Scanner;
import Paquete_Ejercicios_en_Curso.*;
import Paquete_tarea_6_7.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2. Polimorfismo con Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4. Arrays y Referencias");
            System.out.println("5. Figuras Geometricas");
            System.out.println("6. Gestion de productos");
            System.out.println("7. Inventario con arrays");
            System.out.println("8. Copia de arrays");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    CuentaBancaria cuenta = new CuentaBancaria("001", 1000);
                    cuenta.depositar(200);
                    cuenta.retirar(100);
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    pausa();
                    break;

                case 2:
                    Empleado e1 = new EmpleadoFijo(15000);
                    Empleado e2 = new EmpleadoPorHora(160, 100);

                    System.out.println("Empleado fijo: " + e1.calcularSalario());
                    System.out.println("Empleado por hora: " + e2.calcularSalario());
                    pausa();
                    break;

                case 3:
                    A obj = new B();
                    System.out.println("Valor de x: " + obj.x);
                    pausa();
                    break;
                    /*
                    El objeto creado es de tipo B, pero la referencia es de tipo A.
                    En Java, los atributos no son polimorficos
                    Por eso se accede al atributo x de la clase A y no al de la clase B en este caso.
                    */
                case 4:
                    int[] a1 = {1, 2, 3};
                    int[] a2 = a1;

                    a2[0] = 9;

                    for (int i : a1) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    pausa();
                    break;
                case 5:
                    Figura[] figuras = new Figura[3];
                    figuras[0] = new Cuadrado(4);
                    figuras[1] = new Rectangulo(3, 5);
                    figuras[2] = new Circulo(2);

                    for (Figura f : figuras) {
                        System.out.println("Area del " + f.getNombre() + ": "  + f.area());
                    }
                    pausa();
                    break;

                case 6:
                    Producto p = new Producto("Laptop", 50000, 5);
                    p.vender(2);

                    System.out.println("Producto: " + p.getNombre());
                    System.out.println("Precio: " + p.getPrecio());
                    System.out.println("Stock: " + p.getStock());
                    pausa();
                    break;
                
                case 7:
                    Producto[] inventario = new Producto[3];

                    inventario[0] = new Producto("Laptop", 50000, 2);
                    inventario[1] = new Producto("Mouse", 800, 0);
                    inventario[2] = new Producto("Teclado", 2000, 5);

                    double total = 0;

                    for (Producto prod : inventario) {
                        total += prod.getPrecio() * prod.getStock();
                    }

                    System.out.println("Valor total del inventario: " + total);

                    System.out.println("Productos con stock disponible:");
                    for (Producto prod : inventario) {
                        if (prod.getStock() > 0) {
                            System.out.println(prod.getNombre());
                        }
                    }
                    pausa();
                    break;

                case 8:
                    int[] original = {1, 2, 3};
                    int[] copia = original.clone();

                    copia[0] = 99;

                    System.out.println("Array original:");
                    for (int n : original)  {
                        System.out.print(n + " ");
                    }

                    System.out.println("\n Array copia:");
                    for (int n : copia) {
                        System.out.print(n + " ");
                    }
                    pausa();
                    break;
                default:
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }


// Hice esta funcion para mejorar la interaccion del usuario con el menu
public static void pausa() {
    try {
        System.out.println("\nPresione cualquier tecla para continuar...");
        System.in.read();
        System.in.read(); // limpia el buffer
    } catch (Exception e) {
    }
}
}

/* https://github.com/NashRojas/Ejercicios_Clase_P3.git */