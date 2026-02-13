import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1. Registrar incidencia ");
            System.out.println("2. Listar incidencias ");
            System.out.println("3. Buscar incidencias por la palabra clave ");
            System.out.println("0. Buscar incidencias por palabra clave ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 0:
                    
                    break;
                
                default:
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}
