package vistas;

import java.util.Scanner;

public abstract class MenuTemplate {

    protected Scanner scanner = new Scanner(System.in);

    public abstract void exportarDatos();
    public abstract void crearAlumno();
    public abstract void agregarMateria();
    public abstract void agregarNotaPasoUno();
    public abstract void listarAlumnos();
    public abstract void terminarPrograma();

    public final void iniciarMenu() {
        int opcion;
        do {
        	System.out.println("----------------------------------------------------------------------");
            System.out.println("\n1. Crear Alumnos\n2. Listar Alumnos\n3. Agregar Materias\n4. Agregar Notas\n5. Exportar Datos\n6. Salir");
            System.out.print("\nSelección: ");
        	System.out.println("\n----------------------------------------------------------------------");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
                case 3:
                    agregarMateria();
                    break;
                case 4:
                    agregarNotaPasoUno();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }
}
