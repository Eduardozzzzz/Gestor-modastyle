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

    public boolean registrarPrenda(Prenda prenda) {
        for (Prenda p : listaPrendas) {
            if (p.getCodigo().equals(prenda.getCodigo())) {
                return false;
            }
        }
        listaPrendas.add(prenda);
        return true;
    }

    public boolean registrarCliente(Cliente cliente) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(cliente.getDocumento())) {
                return false;
            }
        }
        for (Vendedor v : listaVendedores) {
            if (v.getDocumento().equals(cliente.getDocumento())) {
                return false;
            }
        }
        listaClientes.add(cliente);
        return true;
    }

    public boolean registrarVendedor(Vendedor vendedor) {
        for (Vendedor v : listaVendedores) {
            if (v.getDocumento().equals(vendedor.getDocumento())) {
                return false;
            }
        }
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(vendedor.getDocumento())) {
                return false;
            }
        }
        listaVendedores.add(vendedor);
        vendedor.getSucursal().getListaVendedores().add(vendedor);
        return true;
    }

    public boolean registrarSucursal(Sucursal sucursal) {
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo().equals(sucursal.getCodigo())) {
                return false;
            }
        }
        listaSucursales.add(sucursal);
        return true;
    }

    public boolean registrarExistencia(RegistroInventario registro) {
        String talla = registro.getTalla();
        if (registro.getPrenda().getCategoria() == CategoriaPrenda.CALZADO) {
            try {
                int numero = Integer.parseInt(talla);
                if (numero < 35 || numero > 44) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            boolean valida = false;
            for (Tallas t : Tallas.values()) {
                if (t.name().equals(talla)) {
                    valida = true;
                }
            }
            if (!valida) {
                return false;
            }
        }
        for (RegistroInventario r : registro.getSucursal().getListaRegistroInventarios()) {
            if (r.getPrenda().getCodigo().equals(registro.getPrenda().getCodigo())
                    && r.getTalla().equals(registro.getTalla())
                    && r.getColor().equalsIgnoreCase(registro.getColor())) {
                return false;
            }
        }
        registro.getSucursal().getListaRegistroInventarios().add(registro);
        registro.getPrenda().getListaRegistroInventarios().add(registro);
        return true;
    }

    public List<RegistroInventario> consultarDisponibles(String codigoSucursal) {
        List<RegistroInventario> resultado = new ArrayList<>();
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo().equals(codigoSucursal)) {
                for (RegistroInventario r : s.getListaRegistroInventarios()) {
                    if (r.getCantidadDisponible() > 0) {
                        resultado.add(r);
                    }
                }
            }
        }
        return resultado;
    }

    public double calcularPrecioFinal(Prenda prenda, Cliente cliente) {
        double conRecargo = prenda.calcularPrecioConRecargo();
        double descuento = cliente.getCategoriaAfiliacion().getDescuento();
        return conRecargo * (1 - descuento / 100.0);
    }

    public boolean confirmarVenta(Venta venta) {
        for (DetalleVenta d : venta.getDetalles()) {
            if (!d.getRegistro().getSucursal().getCodigo().equals(venta.getSucursal().getCodigo())) {
                return false;
            }
        }
        for (int i = 0; i < venta.getDetalles().size(); i++) {
            RegistroInventario reg = venta.getDetalles().get(i).getRegistro();
            int totalPedido = 0;
            for (DetalleVenta d : venta.getDetalles()) {
                if (d.getRegistro() == reg) {
                    totalPedido += d.getCantidad();
                }
            }
            if (totalPedido > reg.getCantidadDisponible()) {
                return false;
            }
        }
        for (DetalleVenta d : venta.getDetalles()) {
            RegistroInventario reg = d.getRegistro();
            reg.setCantidadDisponible(reg.getCantidadDisponible() - d.getCantidad());
            reg.getListaDetalles().add(d);
        }
        venta.getSucursal().getListaVentas().add(venta);
        venta.getVendedor().getListaVentas().add(venta);
        venta.getCliente().getListaVentas().add(venta);
        return true;
    }

    public List<RegistroInventario> consultarAgotados() {
        List<RegistroInventario> resultado = new ArrayList<>();
        for (Sucursal s : listaSucursales) {
            for (RegistroInventario r : s.getListaRegistroInventarios()) {
                if (r.getCantidadDisponible() == 0) {
                    resultado.add(r);
                }
            }
        }
        return resultado;
    }

    public List<Venta> ventasPorVendedor(String documento) {
        for (Vendedor v : listaVendedores) {
            if (v.getDocumento().equals(documento)) {
                return v.getListaVentas();
            }
        }
        return new ArrayList<>();
    }

    public List<Venta> comprasPorCliente(String documento) {
        for (Cliente c : listaClientes) {
            if (c.getDocumento().equals(documento)) {
                return c.getListaVentas();
            }
        }
        return new ArrayList<>();
    }

    public double ingresosPorSucursal(String codigoSucursal) {
        double total = 0;
        for (Sucursal s : listaSucursales) {
            if (s.getCodigo().equals(codigoSucursal)) {
                for (Venta v : s.getListaVentas()) {
                    total += v.calcularTotal();
                }
            }
        }
        return total;
    }

    public String prendaMasVendida() {
        String codigoTop = null;
        int maximo = 0;
        for (Prenda p : listaPrendas) {
            int suma = 0;
            for (RegistroInventario r : p.getListaRegistroInventarios()) {
                for (DetalleVenta d : r.getListaDetalles()) {
                    suma += d.getCantidad();
                }
            }
            if (suma > maximo) {
                maximo = suma;
                codigoTop = p.getCodigo();
            }
        }
        return codigoTop;
    }
}
