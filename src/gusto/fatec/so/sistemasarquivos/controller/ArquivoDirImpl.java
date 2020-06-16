package gusto.fatec.so.sistemasarquivos.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivoDirImpl implements ArquivoDir {

	@Override
	public void listarDiretorio(String caminho) {
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File[] vetArq = dir.listFiles(); // retorna um array com todos os arquivos do diret�rio
			for (File arquivo : vetArq) {
				if (arquivo.isDirectory()) {
					System.out.println("[" + arquivo.getName() + "]");
				}
			}
			for (File arquivo : vetArq) {
				if (arquivo.isFile()) {
					System.out.println(arquivo.getName());
				}
			}
		}
	}

	@Override
	public void lerArquivo(String caminho, String arquivo) {
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, arquivo);
			if (arq.exists() && arq.isFile()) {
				try {
					FileInputStream is = new FileInputStream(arq);
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String linha = br.readLine();
					while (linha != null) {
						System.out.println(linha);
						linha = br.readLine();
					}
					br.close();
					isr.close();
					is.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void escreveArquivo(String caminho, String arquivo) {
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, arquivo);
			boolean arqExist = arq.exists();
			StringBuffer txt = new StringBuffer();
			String linha = "";
			while (!linha.equals("fim")) {
				linha = JOptionPane.showInputDialog(null, "Digite algo");
				txt.append(linha);
				txt.append("\r\n");
			}

			try {
				FileWriter writer = new FileWriter(arq, arqExist);
				PrintWriter printWriter = new PrintWriter(writer);
				printWriter.write(txt.toString());
				printWriter.flush();
				printWriter.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
