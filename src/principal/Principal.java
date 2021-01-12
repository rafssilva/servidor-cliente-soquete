package principal;

// Socket: ponto de comunicação que conecta duas máquinas,
// permitindo a troca de mensagens entre as mesmas.
// Requer um Servidor para receber a conexão e um Cliente para conectar-se.
public class Principal {

	public static void main(String[] args) {

		final int porta = 8080;

		new Thread(new Servidor(porta)).start();
		new Thread(new Cliente(porta)).start();
	}
}