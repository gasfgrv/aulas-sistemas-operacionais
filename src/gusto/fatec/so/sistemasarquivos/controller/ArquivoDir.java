package gusto.fatec.so.sistemasarquivos.controller;

public interface ArquivoDir {
	public void listarDiretorio(String caminho);

	public void lerArquivo(String caminho, String arquivo);

	public void escreveArquivo(String caminho, String arquivo);
}
