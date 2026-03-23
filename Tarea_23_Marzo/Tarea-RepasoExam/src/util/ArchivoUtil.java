package util;

import java.io.*;
import java.util.*;

import model.Producto;

public class ArchivoUtil {
    
    private static final String ARCHIVO = "inventario.txt";
    
    public static List<Producto> leerArchivo() throws IOException {
        List<Producto> lista = new ArrayList<>();
        File file = new File(ARCHIVO);

        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            Producto p = new Producto(
                datos[0],
                datos[1],
                Double.parseDouble(datos[2]),
                Integer.parseInt(datos[3])
            );

            lista.add(p);
        }

        br.close();
        return lista;
    }
    public static void guardarArchivo(List<Producto> productos) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO));
        
        for (Producto p : productos) {
            bw.write(p.toString());
            bw.newLine();
        }
        bw.close();
    }
}
