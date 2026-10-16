package uniquindio.edu.co;

public class Vendedor extends Persona{
    private double Salario;

    public Vendedor(String nombre, String documento, String correo, String telefono, double salario) {
        super(nombre, documento, correo, telefono);
        Salario = salario;

    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }
}
