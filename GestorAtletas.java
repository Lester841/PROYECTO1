import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorAtletas {
    private List<Atleta> atletas;

    public GestorAtletas() {
        this.atletas = new ArrayList<>();
    }

    public void registrarAtleta(Atleta a) {
        atletas.add(a);
    }

    public Atleta buscarAtleta(String nombre) {
        for (Atleta a : atletas) {
            if (a.toString().contains(nombre)) {
                return a;
            }
        }
        return null;
    }

    public void mostrarTodos() {
        atletas.forEach(System.out::println);
    }

    public void guardarDatosJSON(String ruta) throws IOException {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(atletas, writer);
        }
    }

    public void cargarDatosJSON(String ruta) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(ruta)) {
            atletas = gson.fromJson(reader, new TypeToken<List<Atleta>>() {}.getType());
        }
    }
}
