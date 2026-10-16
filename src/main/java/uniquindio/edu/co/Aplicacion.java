package uniquindio.edu.co;
public class Aplicacion {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("ModaStyle", 123, "Armenia", null, null, null, null);
        System.out.println("ModaStyle: " + empresa.getNombre());
    }
}
