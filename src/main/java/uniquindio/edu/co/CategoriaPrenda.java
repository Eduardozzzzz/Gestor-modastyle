package uniquindio.edu.co;

public enum CategoriaPrenda {
    CAMISETA(0),
    PANTALON(0),
    VESTIDO(0.10),
    CHAQUETA(0.15),
    CALZADO(0.05);
    private double sobreCargo;
    CategoriaPrenda(double sobreCargo) {
        this.sobreCargo = sobreCargo;
    }
    public double getSobreCargo() {
        return sobreCargo;
    };
}
