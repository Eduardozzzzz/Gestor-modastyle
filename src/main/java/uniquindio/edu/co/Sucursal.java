package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String nombre;
    private String codigo;
    private String direccion;
    private String ciudad;

    private List<RegistroInventario> listaRegistroInventarios;
    private List<Vendedor> listaVendedores;
    private List<Venta> listaVentas;

    public Sucursal(String nombre, String codigo, String direccion, String ciudad, List<RegistroInventario>  listaRegistroInventarios, List<Vendedor> listaVendedores,  List<Venta> listaVentas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.listaRegistroInventarios = new ArrayList<>();
        this.listaVendedores = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<RegistroInventario> getListaRegistroInventarios() {
        return listaRegistroInventarios;
    }

    public void setListaRegistroInventarios(List<RegistroInventario> listaRegistroInventarios) {
        this.listaRegistroInventarios = listaRegistroInventarios;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}
