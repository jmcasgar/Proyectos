package biblioteca;

import java.util.Scanner;

public class Biblioteca {

    static Scanner scanner = new Scanner(System.in);
    static String[][] libros = new String[100][5];
    static int numLibros = 0;

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarLibro();
                    break;
                case 2:
                    actualizarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    buscarLibro();
                    break;
                case 5:
                    ordenarLibros();
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("---- Menú ----");
        System.out.println("1. Registrar nuevo libro");
        System.out.println("2. Actualizar libro existente");
        System.out.println("3. Eliminar libro existente");
        System.out.println("4. Buscar libro");
        System.out.println("5. Ordenar libros");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarLibro() {
        System.out.println("\n--- Registrar nuevo libro ---");
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Autor: ");
        String autor = scanner.next();
        System.out.print("Materia: ");
        String materia = scanner.next();
        System.out.print("Número de páginas: ");
        String numPaginas = scanner.next();

        libros[numLibros][0] = codigo;
        libros[numLibros][1] = nombre;
        libros[numLibros][2] = autor;
        libros[numLibros][3] = materia;
        libros[numLibros][4] = numPaginas;

        numLibros++;

        System.out.println("Libro registrado exitosamente.\n");
    }

    public static void actualizarLibro() {
        System.out.println("\n--- Actualizar libro existente ---");
        System.out.print("Ingrese el código del libro a actualizar: ");
        String codigo = scanner.next();

        int indice = buscarLibroPorCodigo(codigo);

        if (indice == -1) {
            System.out.println("El libro no existe en la biblioteca.\n");
            return;
        }

        System.out.println("Ingrese los nuevos valores para el libro:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Autor: ");
        String autor = scanner.next();
        System.out.print("Materia: ");
        String materia = scanner.next();
        System.out.print("Número de páginas: ");
        String numPaginas = scanner.next();

        libros[indice][1] = nombre;
        libros[indice][2] = autor;
        libros[indice][3] = materia;
        libros[indice][4] = numPaginas;

        System.out.println("Libro actualizado exitosamente.\n");
    }

    public static void eliminarLibro() {
        System.out.println("\n--- Eliminar libro existente ---");
        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = scanner.next();

        int indice = buscarLibroPorCodigo(codigo);

        if (indice == -1) {
            System.out.println("El libro no existe en la biblioteca.\n");
            return;
        }

        // Mover todos los libros que están después del libro a eliminar una posición hacia atrás
        for (int i = indice; i < numLibros - 1; i++) {
            libros[i] = libros[i + 1];
        }

        // Decrementar el contador de numLibros
        numLibros--;

        System.out.println("Libro eliminado exitosamente.\n");
    }

    public static int buscarLibroPorCodigo(String codigo) {
        for (int i = 0; i < numLibros; i++) {
            if (libros[i][0].equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private static void ordenarLibros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void buscarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
