package servicios;

import java.util.List;

public class PromedioServicioImp {

    // Método que calcula el promedio de una lista de notas
    public double calcularPromedio(List<Double> notas) {
        if (notas.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Double nota : notas) {
            sum += nota;
        }
        return sum / notas.size();
    }
}
