package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> materias;

    public Alumno(String rut, String nombre, String apellido, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        materias = new ArrayList<>();
    }

    // Getters y Setters

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void addMateria(Materia materias) {
      this.materias.add(materias);
    }
    
    

	@Override
	public String toString() {
		return "\nDatos del Alumno: \n\n" + "\tRut: " + rut + "\n" + "\tNombre: " + nombre + "\n" + "\tApellido: "
				+ apellido + "\n" + "\tDireccion: " + direccion + "\n\n" + "\tMaterias: \n"
				+ materias.stream().map(Materia::toString).collect(Collectors.joining("\n"));
	}

}
