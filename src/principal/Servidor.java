package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor implements Runnable {

	private final int porta;

	public Servidor(final int porta) {
		this.porta = porta;
	}

	private void iniciarServidor() {

		try {

			final ServerSocket servidor = new ServerSocket(porta);

			System.out.println("Servidor iniciado na porta " + porta);

			// Necessário utilizar várias threads,
			// pois o accept() bloqueia toda a execução enquanto aguarda um Cliente
			// conectar-se.
			final Socket cliente = servidor.accept();

			System.out.println("Cliente conectado do IP " + cliente.getInetAddress().getHostAddress());

			final Scanner entrada = new Scanner(cliente.getInputStream());

			while (entrada.hasNextLine())
				System.out.println(entrada.nextLine());

			entrada.close();
			servidor.close();

		} catch (IOException excecao) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, excecao);
		}
	}

	@Override
	public void run() {
		iniciarServidor();
	}
}