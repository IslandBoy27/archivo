/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Jayma
 */
package archivo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class MiFile {

    private File mf = null;

    public void setFile(String dir) {
        mf = new File(dir);
    }

    public void Info() {
        if (mf.exists()) {
            System.out.print("\nSI EXISTE:\n -----------");
            System.out.println("Nombre: " + mf.getName());
            System.out.println("Path: " + mf.getPath());
            System.out.println("Absoluta: " + mf.getAbsolutePath());
            System.out.println("Padre: " + mf.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: " + mf.length());
            if (mf.isFile()) {
                System.out.println("ES UN ARCHIVO");
            } else if (mf.isDirectory()) {
                System.out.print("ES UN FOLDER");
                System.out.print("ULTIMA MODIFICACIÓN: " + new Date(mf.lastModified()));
            } else {
                System.out.print("Aun no existe");
            }
        }
    }

    public void crearFile() throws IOException {
        if (mf.createNewFile()) {
            System.out.println("CREADO EXITOSAMENTE");
        } else {
            System.out.println("NO SE PUDO CREAR");
        }
    }

    public void crearFolder() {
        if (mf.mkdirs()) {
            System.out.println("CREADO EXITOSAMENTE");
        } else {
            System.out.println("NO SE PUDO CREAR");
        }
    }

    private boolean antidoto(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                antidoto(child);
            }
        }
        return file.delete();
    }

    public void Borrar() {
        if (antidoto(mf)) {
            System.out.println("SE BORRO");
        } else {
            System.out.println("NO SE BORRO");
        }
    }

    public void dir() {
        if (mf.isDirectory()) {
            System.out.println("DIRECTORIO DE: " + mf.getAbsolutePath());
            System.out.println("");
            int cfiles = 0, cdirs = 0, tbytes = 0;

            for (File child : mf.listFiles()) {
                if (!child.isHidden()) {
                    // Fecha Última modificación
                    Date ultima = new Date(child.lastModified());
                    System.out.print(ultima + "\t");
                    // Si es File o Folder
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        // Si es un archivo
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("     \t" + child.length() + "\t");
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles + " archivos\t" + tbytes + " bytes" + "\n" + cdirs + " dirs");
        }
    }

    public void tree() {
        tree(mf, "-");
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            // Recorrer el contenido
            for (File child : dir.listFiles()) {
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }

    // Método para reemplazar todo el contenido del archivo
    public void escribirReemplazar(String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mf))) {
            writer.write(contenido);
            System.out.println("Contenido reemplazado exitosamente.");
        }
    }

    // Método para agregar contenido al archivo sin borrar el contenido anterior
   public void escribirAgregar(String contenido) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(mf, true))) {
        writer.newLine(); // Agrega un salto de línea antes del nuevo contenido
        writer.write(contenido);
        System.out.println("Contenido agregado exitosamente.");
    }
}


    // Método para leer el contenido del archivo
    public void leerArchivo() throws IOException {
        if (mf != null && mf.exists() && mf.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(mf))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } else {
            System.out.println("El archivo no existe o no es un archivo válido.");
        }
    }

}
