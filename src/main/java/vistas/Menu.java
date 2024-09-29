package vistas;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;
import utilidades.AlumnoDTO;

public class Menu extends MenuTemplate {

	private AlumnoServicio alumnoServicio = new AlumnoServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();


	@Override
	public void exportarDatos() {
		// archivoServicio.exportarDatos(alumnoServicio.listarAlumnos());
	}

	@Override
	public void crearAlumno() {
		System.out.println("--- Crear Alumno ---");
		System.out.print("Ingresa RUT: ");
		String rut = scanner.next();
		System.out.print("Ingresa nombre: ");
		String nombre = scanner.next();
		System.out.print("Ingresa apellido: ");
		String apellido = scanner.next();
		System.out.print("Ingresa dirección: ");
		String direccion = scanner.next();
		Alumno alumno= new Alumno(rut, nombre, apellido, direccion);
		alumnoServicio.crearAlumno(alumno);
		System.out.println("\n--- ¡Alumno agregado! ---\n");
	}

	@Override
	public void agregarMateria() {
		System.out.print("Ingresa rut del Alumno: ");
		String rut = scanner.next();
		Alumno alumno = alumnoServicio.encontrarAlumnoPorRut(rut);
		if (alumno == null) {
			System.out.println("Alumno no encontrado.");
			return;
		}
		System.out.println("1. MATEMATICAS\n2. LENGUAJE\n3. CIENCIA\n4. HISTORIA");
		System.out.print("Selecciona una Materia: ");
		int opcionMateria = scanner.nextInt();
		MateriaEnum materiaEnum = MateriaEnum.values()[opcionMateria - 1];
		Materia materia = new Materia(materiaEnum);
		alumnoServicio.agregarMateria(rut,materia);
		System.out.println("--- ¡Materia agregada! ---");

	}
	@Override
	public void agregarNotaPasoUno() {
		System.out.print("Ingresa rut del Alumno: ");
		String rut = scanner.next();
		Alumno alumno = alumnoServicio.encontrarAlumnoPorRut(rut);
		if (alumno == null) {
			System.out.println("Alumno no encontrado.");
			return;
		}
		System.out.println("El alumno tiene las siguientes materias:");
		for (int i = 0; i < alumnoServicio.materiasPorAlumno(rut).size(); i++) {
			System.out.println(i + 1 + ". " + alumnoServicio.materiasPorAlumno(rut).get(i).getNombre());
		}
	    System.out.print("Selecciona una Materia: ");
	    int materiaIndex = scanner.nextInt();
	    materiaIndex--;
	    if (materiaIndex < 0 || materiaIndex >= alumnoServicio.materiasPorAlumno(rut).size()) {
	    	            System.out.println("Materia no encontrada.");
	    	            return;
	    }
	    String nombreMatera = alumnoServicio.materiasPorAlumno(rut).get(materiaIndex).getNombre().toString();
	    System.out.print("Ingresa nota: ");
	    double nota = scanner.nextDouble();
		alumnoServicio.agregarNota(rut, materiaIndex, nota);
		System.out.println("--- ¡Nota agregada a "+nombreMatera+"! ---");

	}
	@Override
	public void listarAlumnos() {
		System.out.println("----Listado de Alumnos----\nDatos Alumnos: \n");
		AlumnoDTO alumnoDto = new AlumnoDTO();
		System.out.println(alumnoDto.consoleFormatter(alumnoServicio.listarAlumnos()));

	}

	@Override
	public void terminarPrograma() {
		System.out.println("Saliendo del sistema...");
		System.exit(0);
	}
}
