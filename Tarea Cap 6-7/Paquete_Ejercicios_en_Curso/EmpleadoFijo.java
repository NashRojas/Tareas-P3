package Paquete_Ejercicios_en_Curso;

public class EmpleadoFijo extends Empleado {
    double salario;

    public EmpleadoFijo(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}