import java.util.Scanner;
import Paquete_Tarea_Lab.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Incidencia> lista = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("");
            System.out.println("============================================================");
            System.out.println(" 1) Registrar incidencia ");
            System.out.println(" 2) Listar incidencias ");
            System.out.println(" 3) Buscar incidencias por la palabra clave ");
            System.out.println(" 0) Salir ");
            System.out.println("============================================================");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarIncidencia(sc, lista);
                    break;
                case 2:
                    listarIncidencias(lista);
                    break;
                case 3:
                    buscarIncidencias(sc, lista);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema....");
                    break;
                
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
        sc.close();
    }

    private static void registrarIncidencia(Scanner sc, List<Incidencia> lista) {

    try {
        System.out.println("Descripcion: ");
        String descripcion = sc.nextLine();


        System.out.println("Nivel de prioridad (ALTA, MEDIA, BAJA): ");
        String nivelPrioridad = sc.nextLine();


        System.out.println("Fecha (dd/MM/yyyy) ");
        String fecha = sc.nextLine();


        int id = lista.size() + 1;

        Incidencia nueva = new Incidencia(id, descripcion, nivelPrioridad, fecha);

        lista.add(nueva);
        System.out.println("Incidencia registrada correctamente");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void listarIncidencias(List<Incidencia> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay incidencias registradas. ");
            return;
        }
        for (Incidencia i : lista) {
            System.out.println(i);
            System.out.println("=================================================");
        }
    }

    private static void buscarIncidencias(Scanner sc, List<Incidencia> lista) {

        System.out.println("Ingrese palabra clave: ");
        String palabra = sc.nextLine().trim().toLowerCase();

        boolean encontrada = false;

        for (Incidencia i : lista) {
            if (i.getDescripcion().toLowerCase().contains(palabra)) {
                System.out.println(i);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontraron coincidencias.");
        }
    }


}
