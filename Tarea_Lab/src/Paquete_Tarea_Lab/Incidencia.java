package Paquete_Tarea_Lab;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Incidencia {
    
    private int id;
    private String descripcion;
    private Date fechaRegistro;
    private String nivelPrioridad;


    public Incidencia(int id, String descripcion,String fechaTexto, String nivelPrioridad) throws DescripcionInvalidaException, PrioridadInvalidaException, FechaInvalidaException{
        this.id = id;

        if (descripcion == null){
            throw new DescripcionInvalidaException("La descripcion no puede ser null");
        }
        descripcion = descripcion.trim();
        if (descripcion.isEmpty()){
            throw new DescripcionInvalidaException("La descripcion no puede estar vacia");
        }
        if (descripcion.length() < 10){
            throw new DescripcionInvalidaException("La descripcion debe tener como minimo 10 caracteres....");
        }
        this.descripcion = descripcion;

        if (nivelPrioridad == null){
            throw new PrioridadInvalidaException("La prioridad no puede ser null");
        }
        nivelPrioridad = nivelPrioridad.trim().toUpperCase();
        if (!nivelPrioridad.equals("ALTA")&&
            !nivelPrioridad.equals("MEDIA")&&
            !nivelPrioridad.equals("BAJA")){
                throw new PrioridadInvalidaException("Prioridad invalida, solo ALTA, MEDIA, BAJA");
            }
        this.nivelPrioridad = nivelPrioridad;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date fecha;
        try {
            fecha = sdf.parse(fechaTexto);
        } catch (ParseException e){
        throw new FechaInvalidaException("Formato de fecha invalido, utiliza dd/MM/yyyy");
        }
        
        Date hoy = new Date();
        if (fecha.after(hoy)){
            throw new FechaInvalidaException("La fecha no puede ser a futuro");
        }
        this.fechaRegistro = fecha;
}
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fechaRegistro);
        return  "ID: " + id + "\nDescripcion: " + descripcion + "\nFecha: " + fechaFormateada + "\nPrioridad: " + nivelPrioridad;
    }

    public int getId(){
        return id;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Date getFechaRegistro(){
        return fechaRegistro;
    }
    public String getNivelPrioridad(){
        return nivelPrioridad;
    }
}
