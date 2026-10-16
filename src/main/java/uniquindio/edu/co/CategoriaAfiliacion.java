package uniquindio.edu.co;

public enum CategoriaAfiliacion{
    BRONCE(5),
    PLATA(10),
    ORO(15);
    private double descuento;

    CategoriaAfiliacion(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}
