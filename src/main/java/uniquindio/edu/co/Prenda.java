package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Prenda {
    private String nombre;
    private String codigo;
    private String marca;
    private double precioUnitario;

    private List<RegistroInventario> listaRegistroInventarios;

    private CategoriaPrenda categoria;

    public Prenda(String nombre, String codigo, String marca, double precioUnitario, CategoriaPrenda categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;

        listaRegistroInventarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public List<RegistroInventario> getListaRegistroInventarios() {
        return listaRegistroInventarios;
    }

    public void setListaRegistroInventarios(List<RegistroInventario> listaRegistroInventarios) {
        this.listaRegistroInventarios = listaRegistroInventarios;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public double calcularPrecioConRecargo(){
        return precioUnitario*(1+ categoria.getSobreCargo());
    }

    public String toString(){
        return codigo + " - " + nombre + " " + marca + " $" + precioUnitario + " " + categoria;
    }
}
