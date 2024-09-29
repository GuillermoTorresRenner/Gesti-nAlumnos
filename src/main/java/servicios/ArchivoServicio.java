package servicios;

import modelos.Alumno;
import modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
	private List<Alumno> alumnosACargar;
	private BufferedWriter writer;
	private FileWriter fileWriter;

	private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();


	public void exportarDatos(Map<String, Alumno> alumnos,String path) {
		try {
			alumnosACargar = new ArrayList<>(alumnos.values());
			fileWriter = new FileWriter(path+"/promedio.txt");
			writer = new BufferedWriter(fileWriter);
			for (Alumno alumno : alumnosACargar) {
				writer.write("Alumno : " + alumno.getRut() + " - "+alumno.getNombre()+"\n");
				for (Materia materia : alumno.getMaterias()) {
					writer.write("\tMateria : "+materia.getNombre() + " - Promedio: " + promedioServicioImp.calcularPromedio(materia.getNotas()) + "\n ");
					writer.write("\n");

				}
			}
			writer.close();



		} catch (IOException e) {
			// TODO: handle exception
		}

	}
}
