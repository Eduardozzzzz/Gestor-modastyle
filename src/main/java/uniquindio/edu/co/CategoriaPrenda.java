package uniquindio.edu.co;

public enum CategoriaPrenda {
    CAMISETA(0),
    PANTALON(0),
    VESTIDO(10),
    CHAQUETA(15),
    CALZADO(5);
    private double sobreCargo;
    CategoriaPrenda(double sobreCargo) {
        this.sobreCargo = sobreCargo;
    }
    public double getSobreCargo() {
        return sobreCargo;
    };
}
