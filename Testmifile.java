/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jayma
 */
package archivo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Testmifile {

    static MiFile mf = new MiFile();
    static Scanner lea = new Scanner(System.in);

    public static void main(String args[]) {
        int opcion = 0;
        do {
            System.out.println("\nMENU\n");
            System.out.println("1- Set el archivo / folder.");
            System.out.println("2- Ver información.");
            System.out.println("3- Crear un archivo.");
            System.out.println("4- Crear un folder.");
            System.out.println("5- Borrar.");
            System.out.println("6- CMD - DIR.");
            System.out.println("7- Tree.");
            System.out.println("8- Escribir reemplazando contenido.");
            System.out.println("9- Escribir agregando contenido.");
            System.out.println("10- Leer archivo.");
            System.out.println("11- Salir.");
            System.out.println("Escoja una opción");
            try {
                opcion = lea.nextInt();
                lea.nextLine(); // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        set();
                        break;

                    case 2:
                        mf.Info();
                        break;

                    case 3:
                        mf.crearFile();
                        break;

                    case 4:
                        mf.crearFolder();
                        break;

                    case 5:
                        mf.Borrar();
                        break;

                    case 6:
                        mf.dir();
                        break;

                    case 7:
                        mf.tree();
                        break;

                    case 8:
                        if (mf == null) {
                            System.out.println("No se ha establecido un archivo. Por favor, seleccione un archivo primero.");
                        } else {
                            System.out.println("Ingrese el contenido a escribir:");
                            String contenidoReemplazo = lea.nextLine();
                            mf.escribirReemplazar(contenidoReemplazo);
                        }
                        break;

                    case 9:
                        if (mf == null) {
                            System.out.println("No se ha establecido un archivo. Por favor, seleccione un archivo primero.");
                        } else {
                            System.out.println("Ingrese el contenido a agregar:");
                            String contenidoAgregar = lea.nextLine();
                            mf.escribirAgregar(contenidoAgregar);
                        }
                        break;

                    case 10:
                        if (mf == null) {
                            System.out.println("No se ha establecido un archivo. Por favor, seleccione un archivo primero.");
                        } else {
                            mf.leerArchivo();
                        }
                        break;

                    case 11:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                lea.nextLine();
                System.out.println("PORFAVOR ESCOGER LA OPCIÓN CORRECTA");

            } catch (NullPointerException e) {
                System.out.println("SE DEBE ESCOGER LA OPCION 1 POR LO MENOS UNA VEZ");

            } catch (IOException e) {
                System.out.println("Error :" + e.getMessage());

            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }

        } while (opcion != 11);

    }

    private static void set() {
        System.out.println("Dirección: ");
        mf.setFile(lea.next());
    }
}

