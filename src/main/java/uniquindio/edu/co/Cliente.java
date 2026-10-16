package uniquindio.edu.co;

public class Cliente extends Persona{
    private String codigoAfiliacion;

    private CategoriaAfiliacion CategoriaAfiliacion;

    public Cliente(String nombre, String documento, String correo, String telefono, String codigoAfiliacion, CategoriaAfiliacion categoriaAfiliacion) {
        super(nombre, documento, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        CategoriaAfiliacion = categoriaAfiliacion;
    }
}
