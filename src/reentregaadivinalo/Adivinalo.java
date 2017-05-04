package reentregaadivinalo;

import java.util.InputMismatchException;

import reentregaadivinalo.utiles.MiTeclado;

/**
 * Reentrega el Adivinalo. Aseg�rate de que tenga las siguientes clases:
 * TestAdivinalo (main) Adivinalo MiTeclado (con deseaContinuar y pedirEntero al
 * menos) Recuerda:
 * 
 * Comunicar al usuario si: Ha superado el record actual Parte de ning�n record
 * previo Guardar en fichero s�lo si se actualiza el record Utilizar ARM
 * Utilizar flujos con bufers Utilizar System.out.format() � System.out.printf()
 * usando %d %n
 * 
 * @author Guillermo Boquizo S�nchez
 * @version 2.0
 */
public class Adivinalo {
	private int aleatorio;
	private int numero;
	private int contador;

	public Adivinalo() {
		super();
		this.aleatorio = generarAleatorio();
		this.contador = 0;
	}

	
	/**
	 * M�todo que se encarga de gestionar la partida hasta que se acierte el n�mero aleatorio
	 * @return contador contador de intentos realizados por el usuario
	 * @throws InputMismatchException
	 */
	int jugar() throws InputMismatchException {
		
		contador = 0;
		
		aleatorio = generarAleatorio();

		do {
			pedirEnteroPositivo();

			mostrarSiAdivinado();

			contador++;

			System.out.println("N�mero de intentos: " + contador);

		} while (!igualar());
		return contador;
	}

	/**
	 * M�todo que comprueba si el usuario logra igualar su n�mero con el del adivino
	 * @return
	 */
	private boolean igualar() {
		return aleatorio == numero;
	}
	
	/**
	 * M�todo que pide un entero positivo por teclado
	 */
	private void pedirEnteroPositivo() {
		numero = MiTeclado.leerEnteroPositivo("Introduce el numero con el jugar�s la partida, entre 1 y 100: ");

	}
	/**
	 * Genera un n�mero aleatorio
	 * @return un n�mero aleatorio entre 0 y 100
	 */
	private int generarAleatorio() {
		return (int) (Math.random() * 100) + 1;
		
	}
	
	/**
	 * M�todo que se encarga de realizar las comprobaciones y mostrarlas entre el aleatorio y el n�mero introducido
	 */
	private void mostrarSiAdivinado() {
		if (numero < aleatorio)
			System.out.println("El n�mero esperado es mayor");
		else if (numero > aleatorio)
			System.out.println("El n�mero esperado es menor");
		else if (aleatorio == numero)
			System.out.println(
					"Enhorabuena, " + numero + " y " + aleatorio + " coinciden. Lo has adivinado y has ganado.");
	}

}
