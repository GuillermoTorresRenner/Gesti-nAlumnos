import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import modelos.*;
import servicios.*;



public class AlumnoServicioTest {

    private static AlumnoServicio alumnoServicio;
    private static AlumnoServicio alumnoServicioMock;
    private static Materia matematicas;
    private static Materia lenguaje;
    private static Alumno mapu;

    @BeforeAll
    public static void setup() {
		alumnoServicio = new AlumnoServicio();
		alumnoServicioMock=mock(AlumnoServicio.class);
		matematicas = new Materia(MateriaEnum.MATEMATICAS);
		lenguaje = new Materia(MateriaEnum.LENGUAJE);
		mapu = new Alumno("12.345.678-9", "Homero", "Simpson", "Avenida Siempreviva 743");


    }

    @DisplayName("Test para verificar la creación de un alumno")
    @Test
    public void crearAlumnoTest() {
    	        alumnoServicio.crearAlumno(mapu);
    	        assertEquals(mapu, alumnoServicio.listarAlumnos().get("12.345.678-9"));
    }

    @DisplayName("Test para verificar la agregación de una materia a un alumno")
    @Test
    public void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);
		alumnoServicio.agregarMateria("12.345.678-9", matematicas);
		alumnoServicio.agregarMateria("12.345.678-9", lenguaje);
		assertEquals(2, alumnoServicio.listarAlumnos().get("12.345.678-9").getMaterias().size());
		
    }

    @DisplayName("Test para verificar la funcionalidad de materiasPorAlumno (usando mock)")
    @Test
    public void materiasPorAlumnosTest() {
            when(alumnoServicioMock.materiasPorAlumno("12.345.678-9")).thenReturn(Arrays.asList(matematicas, lenguaje));
    	}
    
    
    @DisplayName("Test para verificar la funcionalidad de listarAlumnos")
    @Test
    public void listarAlumnosTest() {
            alumnoServicio.crearAlumno(mapu);
            assertEquals(1, alumnoServicio.listarAlumnos().size());
        }
    
    }
