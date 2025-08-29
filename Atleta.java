import java.util.*;

public class Atleta {
    private String nombre;
    private int edad;
    private String disciplina;
    private String departamento;
    private List<Entrenamiento> entrenamientos;

    public Atleta(String nombre, int edad, String disciplina, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.disciplina = disciplina;
        this.departamento = departamento;
        this.entrenamientos = new ArrayList<>();
    }

    public void agregarEntrenamiento(Entrenamiento e) {
        entrenamientos.add(e);
    }

    public List<Entrenamiento> getHistorial() {
        return entrenamientos;
    }

    public double calcularPromedio() {
        return entrenamientos.stream().mapToDouble(Entrenamiento::getValor).average().orElse(0);
    }

    public double mejorMarca() {
        return entrenamientos.stream().mapToDouble(Entrenamiento::getValor).max().orElse(0);
    }

    public List<Entrenamiento> evolucion() {
        entrenamientos.sort(Comparator.comparing(Entrenamiento::getFecha));
        return entrenamientos;
    }

    @Override
    public String toString() {
        return nombre + " (" + disciplina + ", " + departamento + ")";
    }
}
