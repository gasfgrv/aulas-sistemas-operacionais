package gusto.fatec.so.sistemasarquivos.view;

import gusto.fatec.so.sistemasarquivos.controller.ArquivoDir;
import gusto.fatec.so.sistemasarquivos.controller.ArquivoDirImpl;

public class Principal {
	public static void main(String[] args) {
		// String caminho = "C:\\Windows";
		ArquivoDir arquivo = new ArquivoDirImpl();
		// arquivo.listarDiretorio(caminho);
		String caminho = "C:\\TEMP";
		// arquivo.escreveArquivo(caminho, "NovoArquivo.txt");
		arquivo.lerArquivo(caminho, "NovoArquivo.txt");
	}
}
