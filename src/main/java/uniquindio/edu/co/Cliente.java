package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    private String codigoAfiliacion;

    private CategoriaAfiliacion CategoriaAfiliacion;

    private List<Venta> listaVentas;

    public Cliente(String nombre, String documento, String correo, String telefono, String codigoAfiliacion, CategoriaAfiliacion categoriaAfiliacion) {
        super(nombre, documento, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        CategoriaAfiliacion = categoriaAfiliacion;
        this.listaVentas = new ArrayList<>();
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaAfiliacion getCategoriaAfiliacion() {
        return CategoriaAfiliacion;
    }

    public void setCategoriaAfiliacion(CategoriaAfiliacion categoriaAfiliacion) {
        CategoriaAfiliacion = categoriaAfiliacion;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public String toString(){
        return getDocumento() + " - " + getNombre() + " " + CategoriaAfiliacion;
    }

}
