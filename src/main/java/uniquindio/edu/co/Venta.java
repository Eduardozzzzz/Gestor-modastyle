package uniquindio.edu.co;

import java.time.LocalDate;

public class Venta {
    private String codigo;
    private LocalDate fecha;

    public Venta(String codigo, LocalDate fecha) {
        this.codigo = codigo;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
