package Paquete_tarea_6_7;

public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double area(){
        return Math.PI * radio * radio;
    }

    public String getNombre(){
        return "Circulo";
    }
}
