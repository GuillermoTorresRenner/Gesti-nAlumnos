package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ArchivoServicio {

    public void exportarDatos(Map<String, Alumno> alumnos) {
        try (FileWriter writer = new FileWriter("promedios.txt")) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre() + "\n");
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = materia.getNotas().stream().mapToDouble(Double::doubleValue).average().orElse(0);
                    writer.write("Materia: " + materia.getNombre() + " - Promedio: " + promedio + "\n");
                }
            }
            System.out.println("Datos exportados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }
    }
}
