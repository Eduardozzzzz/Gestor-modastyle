package uniquindio.edu.co;

public class DetalleVenta {
    private RegistroInventario registro;
    private int cantidad;
    private double precioUnitarioFinal;
    private double subTotal;

    public DetalleVenta(RegistroInventario registro, int cantidad, double descuento) {
        this.registro = registro;
        this.cantidad = cantidad;
        this.precioUnitarioFinal = registro.getPrenda().calcularPrecioConRecargo()*(1-descuento/100.0);
        this.subTotal = this.precioUnitarioFinal * cantidad;
    }

    public RegistroInventario getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroInventario registro) {
        this.registro = registro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public void setPrecioUnitarioFinal(double precioUnitarioFinal) {
        this.precioUnitarioFinal = precioUnitarioFinal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
