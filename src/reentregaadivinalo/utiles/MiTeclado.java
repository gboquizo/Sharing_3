package reentregaadivinalo.utiles;

import java.util.Scanner;

/**
 * Clase teclado
 *
 * @author Guillermo Boquizo Sánchez
 * @version 2.0
 */
public class MiTeclado {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Pide al usuario un entero positivo.
	 * @param msj mensaje a mostrar
	 * @return numero Número introducido
	 */
	public static int leerEnteroPositivo(String msj) {
		System.out.println(msj);
		int numero = 0;
		do {
			try {
				numero = scanner.nextInt();
				if(numero < 0){
					System.out.println("El número tiene que ser positivo. Vuelve a introducirlo: ");
				}
			} catch (Exception e) {
				System.err.println("Introduce un número entero positivo: ");
				scanner.nextLine();
			}
		} while (numero < 0);
		return numero;
	}
	
	/**
	 * Pregunta al usuario que si quiere continuar con la ejecución
	 * @param msj Mensaje a mostrar
	 * @return true si desea continuar, false si no lo desea
	 */
	public static boolean deseaContinuar(String msj){
		char respuesta;
		do{
			System.out.print(msj);
			respuesta = scanner.next().charAt(0);	
		}while(respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N');	
		
		if(respuesta == 'S' || respuesta == 's')
			return true;
			return false;
	}
}