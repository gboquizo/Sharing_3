package reentregaadivinalo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;

import reentregaadivinalo.utiles.MiTeclado;

/**
 * Reentrega el Adivinalo. Asegúrate de que tenga las siguientes clases:
 * TestAdivinalo (main) Adivinalo MiTeclado (con deseaContinuar y pedirEntero al
 * menos) Recuerda:
 * 
 * Comunicar al usuario si: Ha superado el record actual Parte de ningún record
 * previo Guardar en fichero sólo si se actualiza el record Utilizar ARM
 * Utilizar flujos con bufers Utilizar System.out.format() ó System.out.printf()
 * usando %d %n
 * 
 * @author Guillermo Boquizo Sánchez
 * @author Javir Ponferrada López
 * @version 2.0
 */
public class TestAdivinalo {

	private static int recordEstablecido = Integer.MAX_VALUE;
	private static int record;
	private static final File file = new File("record.txt");

	public static void main(String[] args) throws IOException {

		if (file.exists()) {
			recordEstablecido = leer();
			System.out.println("Tu récord actual es de: " + recordEstablecido);
			adivinalo();
			actualizarRecord(record);
		}
		

	}

	private static void escribir() throws IOException {

		try (DataOutputStream escribir = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("record.txt")))) {
			escribir.writeInt(record);
		} catch (Exception e) {
			System.err.println("Ha habido un error al escribir el nuevo record.");
		}
	}

	private static int leer() throws IOException {
		int record = Integer.MAX_VALUE;
		try (DataInputStream leer = new DataInputStream(new BufferedInputStream(new FileInputStream("record.txt")))) {
			record = leer.readInt();
		} catch (FileNotFoundException | SecurityException e) {
			System.out.println("No existe ningún record.");
		}
		return record;
	}

	private static void adivinalo() throws IOException {
		do {
			try {
				Adivinalo adivinalo = new Adivinalo();
				int intentos = adivinalo.jugar();
				actualizarRecord(intentos);
				escribir();

			} catch (InputMismatchException e) {
				System.out.println("Introduzca un entero válido");
			}

		} while (MiTeclado.deseaContinuar("¿Desea continuar? (s/n)"));
	}

	private static void actualizarRecord(int intentosPartidas) {
		if (intentosPartidas < recordEstablecido) {
			if (record == Integer.MAX_VALUE)
				System.out.printf("Has conseguido el primer record (%d)", intentosPartidas);
		} else {
			System.out.printf("Has conseguido un nuevo record. \n\tRecord actual: %d, \n\tRecord anterior: %d\n",
					intentosPartidas, record);
		}

		record = intentosPartidas;

	}
}