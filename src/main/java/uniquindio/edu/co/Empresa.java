package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private int nit;
    private String direccion;

    private List<Sucursal> listaSucursales;
    private List<Prenda> listaPrendas;
    private List<Cliente> listaClientes;
    private List<Vendedor> listaVendedores;

    public Empresa(String nombre, int nit, String direccion, List<Sucursal> listaSucursales, List<Prenda> listaPrendas, List<Cliente> listaClientes, List<Vendedor> listaVendedores) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listaSucursales = new ArrayList<>();
        this.listaPrendas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaVendedores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public List<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(List<Prenda> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    //Metodos de empresa
}
