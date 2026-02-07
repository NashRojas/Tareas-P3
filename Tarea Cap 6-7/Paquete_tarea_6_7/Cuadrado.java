package Paquete_tarea_6_7;

public class Cuadrado extends Figura {
    
    private double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double area(){
        return lado * lado;
    }

    public String getNombre(){
        return "Cuadrado";
    }
}
