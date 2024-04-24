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
                System.out.println("Introduce num ENTERO entre [1..6]");
                tamano = teclado.nextInt();
                
            } catch (InputMismatchException e) {   
                teclado.nextLine();
            }
            } while (tamano<1 || tamano>6);
        


        // do {
        //     System.out.println("Introduce num ENTERO entre [1..6]");
        //     respuesta = teclado.nextLine();
        //     if (respuesta.length()==1){
        //     tamano = respuesta.charAt(0)-48;
        //     }
        //     System.out.println(tamano);

        // } while (tamano<1 || tamano>6);
        
    }
}