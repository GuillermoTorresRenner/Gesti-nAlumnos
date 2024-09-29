package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;

public  class AlumnoDTO {

	public String consoleFormatter(Map<String, Alumno> alumnos) {
		List<String> alumnosFormateados = new ArrayList<>();

		for (Map.Entry<String, Alumno> entry : alumnos.entrySet()) {
			Alumno alumno = entry.getValue();
			String datosAlumno = "\tRUT: " + alumno.getRut() + "\n\tNombre: " + alumno.getNombre() + "\n\tApellido: "
					+ alumno.getApellido() + "\n\tDirección: " + alumno.getDireccion() + "\n\tMaterias:\n";
			String materias = "";
			for (Materia materia : alumno.getMaterias()) {
				materias += "\t\t" + materia.getNombre() + "\n" + "\t\t\tNotas:\n\t\t\t" + materia.getNotas() + "\n";
			}
			alumnosFormateados.add(datosAlumno + materias);
		}

		return String.join("\n", alumnosFormateados);
	}

}
