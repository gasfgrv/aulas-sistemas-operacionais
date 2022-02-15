package gusto.fatec.so.sistemasarquivos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import javax.swing.JOptionPane;

public class ArquivoDirImpl implements ArquivoDir {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArquivoDirImpl.class);

    @Override
    public void listarDiretorio(String caminho) {
        File dir = new File(caminho);

        if (dir.exists() && dir.isDirectory()) {
            File[] vetArq = dir.listFiles(); // retorna um array com todos os arquivos do diret�rio

            if (vetArq == null) {
                throw new NullPointerException();
            }

            for (File arquivo : vetArq) {
                if (arquivo.isDirectory()) {
                    String log = String.format("[%s]", arquivo.getName());
                    LOGGER.info(log);
                }
            }
            for (File arquivo : vetArq) {
                if (arquivo.isFile()) {
                    LOGGER.info(arquivo.getName());
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
                try (FileInputStream is = new FileInputStream(arq);
                     InputStreamReader isr = new InputStreamReader(is);
                     BufferedReader br = new BufferedReader(isr)) {

                    String linha = br.readLine();

                    while (linha != null) {
                        LOGGER.info(linha);
                        linha = br.readLine();
                    }
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
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
            StringBuilder txt = new StringBuilder();
            String linha = "";

            while (!linha.equals("fim")) {
                linha = JOptionPane.showInputDialog(null, "Digite algo");
                txt.append(linha);
                txt.append("\r\n");
            }

            try (FileWriter writer = new FileWriter(arq, arqExist);
                 PrintWriter printWriter = new PrintWriter(writer)) {
                printWriter.write(txt.toString());
                printWriter.flush();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

}
