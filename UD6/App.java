package UD6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tamano = 0;
        String respuesta = null;
        do {
            try {
                System.out.println("Introduce el número de amigos q vienen a la fiesta [1..6]");
                tamano = teclado.nextInt();

            } catch (InputMismatchException e) {
            } finally {
                teclado.nextLine();
            }
        } while (tamano < 1 || tamano > 6);

        Amigo[] listado = new Amigo[tamano];
        System.out.println();
        System.out.println();
        System.out.println("*** Introducción de nombres ***");
        System.out.println();
        String frase;
        boolean asistencia;
        for (int i = 0; i < listado.length; i++) {
            listado[i] = new Amigo();

            System.out.println("Amigo "+(i+1));
            System.out.print("    ->Nombre: ");
            frase = teclado.nextLine();
            listado[i].setNombre(frase);
            System.out.print("    ->Teléfono: ");
            frase = teclado.nextLine();
            listado[i].setTelefono(frase);
            System.out.print("    ->Asistencia: ");
            asistencia = teclado.nextBoolean();
            teclado.nextLine();
            listado[i].setAsistencia(asistencia);
        }
        System.out.println();
        System.out.println();
        System.out.println("*** Listado de amigos ***");
        System.out.println();
        for (int i = 0; i < listado.length; i++) {
            System.out.println((i+1)+"->"+listado[i].toString());
        }

        
        teclado.close();


    }
}

class Amigo {
    private String nombre;
    private String telefono;
    private boolean asistencia;
    private static final int LONG_TELF = 9;

    // constructor con y sin parámetros
    public Amigo() {
        this.nombre = null;
        this.telefono = null;
        this.asistencia = false;
    }

    public Amigo(String nombre, String telefono, boolean asistencia) {
        this.nombre = nombre;
        this.setTelefono(telefono);
        this.asistencia = asistencia;
    }

    // getters y setters.
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        // comprobar antes de introducir q es teléfono válido.
        // tiene q tener 9 dígitos
        // cada dígito debe ser numérico.
        // si no es correcto telefono=null
        this.telefono = null;
        if (telefono != null) {
            if (telefono.length() == LONG_TELF) { // primer punto ok
                boolean correcto = true;
                int contador = 0;
                while (correcto && contador < LONG_TELF) {
                    if (telefono.charAt(contador) < 48 || telefono.charAt(contador) > 57) {
                        correcto = false;
                    } else {
                        contador++;
                    }
                }
                // valorar pq he salido del while
                if (correcto == true) {
                    this.telefono = telefono;
                }
            }
        }
    }

    public boolean isAsistencia() {
        return this.asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Amigo [nombre:" + nombre + ", telefono:" + telefono + ", asistencia:" + asistencia + "]";
    }

}