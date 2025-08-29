import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GestorAtletas gestor = new GestorAtletas();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Sistema de Monitoreo de Atletas ===");
            System.out.println("1. Registrar Atleta");
            System.out.println("2. Registrar Entrenamiento");
            System.out.println("3. Mostrar historial de un Atleta");
            System.out.println("4. Calcular estadísticas");
            System.out.println("5. Guardar datos");
            System.out.println("6. Cargar datos");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("Disciplina: ");
                    String disciplina = sc.nextLine();
                    System.out.print("Departamento: ");
                    String depto = sc.nextLine();

                    Atleta atleta = new Atleta(nombre, edad, disciplina, depto);
                    gestor.registrarAtleta(atleta);
                }
                case 2 -> {
                    System.out.print("Nombre del atleta: ");
                    String nombre = sc.nextLine();
                    Atleta a = gestor.buscarAtleta(nombre);

                    if (a != null) {
                        System.out.print("Tipo de entrenamiento: ");
                        String tipo = sc.nextLine();
                        System.out.print("Valor de rendimiento: ");
                        double valor = sc.nextDouble(); sc.nextLine();
                        a.agregarEntrenamiento(new Entrenamiento(LocalDate.now(), tipo, valor));
                    } else {
                        System.out.println("Atleta no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Nombre del atleta: ");
                    String nombre = sc.nextLine();
                    Atleta a = gestor.buscarAtleta(nombre);
                    if (a != null) {
                        a.getHistorial().forEach(System.out::println);
                    } else {
                        System.out.println("Atleta no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("Nombre del atleta: ");
                    String nombre = sc.nextLine();
                    Atleta a = gestor.buscarAtleta(nombre);
                    if (a != null) {
                        System.out.println("Promedio: " + a.calcularPromedio());
                        System.out.println("Mejor marca: " + a.mejorMarca());
                        System.out.println("Evolución: ");
                        a.evolucion().forEach(System.out::println);
                    }
                }
                case 5 -> {
                    try {
                        gestor.guardarDatosJSON("atletas.json");
                        System.out.println("Datos guardados en atletas.json");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 6 -> {
                    try {
                        gestor.cargarDatosJSON("atletas.json");
                        System.out.println("Datos cargados.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } while (opcion != 0);
    }
}
