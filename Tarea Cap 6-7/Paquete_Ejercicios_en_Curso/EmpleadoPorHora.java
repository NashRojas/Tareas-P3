package Paquete_Ejercicios_en_Curso;

public class EmpleadoPorHora extends Empleado {
    int horas;
    double pagoHora;

    public EmpleadoPorHora(int horas, double pagoHora) {
        this.horas = horas;
        this.pagoHora = pagoHora;
    }

    @Override
    public double calcularSalario() {
        return horas * pagoHora;
    }
}
