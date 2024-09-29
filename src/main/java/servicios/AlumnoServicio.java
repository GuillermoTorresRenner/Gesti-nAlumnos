package servicios;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlumnoServicio {

	private Map<String, Alumno> listaAlumnos = new HashMap<>();

	//Metodo para crear alumno
	public void crearAlumno(Alumno alumno) {
		System.out.println(alumno);
		listaAlumnos.put(alumno.getRut(), alumno);
	}

	public void agregarMateria(String rut, Materia materia) {
		listaAlumnos.get(rut).addMateria(materia);
		
	}

	//Método para  las materias de un alumno por su rut
	public List<Materia> materiasPorAlumno(String rut) {
		Alumno alumnoBuscado = listaAlumnos.get(rut);
		return alumnoBuscado.getMaterias();

	}

	
	//Método para listar todos los alumnos
	public Map<String, Alumno> listarAlumnos() {
		return listaAlumnos;
	}

		//Método para encontrar un alumno por su rut
		public Alumno encontrarAlumnoPorRut(String rut) {
			Alumno alumnoEncotrado =listaAlumnos.get(rut);
			return (alumnoEncotrado != null) ? alumnoEncotrado : null;

		}

		public void agregarNota(String rutAlumno, int materiaIndex  , double nota) {
		           listaAlumnos.get(rutAlumno).getMaterias().get(materiaIndex).addNota(nota);			
        }
			 
			
		}




