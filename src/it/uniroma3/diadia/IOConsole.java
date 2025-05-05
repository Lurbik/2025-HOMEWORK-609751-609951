package it.uniroma3.diadia;
import java.util.Scanner;


/**
 * Classe che si occupa del disaccoppiamento di input e output
 *
 * @author  docente di POO 
 *         
 *          
 * @version base
 */


public class IOConsole implements IO {
	public void mostraMessaggio(String msg) {
	System.out.println(msg);
	}

	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
