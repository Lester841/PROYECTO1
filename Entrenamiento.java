import java.time.LocalDate;

public class Entrenamiento {
    private LocalDate fecha;
    private String tipo;
    private double valor;

    public Entrenamiento(LocalDate fecha, String tipo, double valor) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.valor = valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return fecha + " | " + tipo + " | Valor: " + valor;
    }
}
