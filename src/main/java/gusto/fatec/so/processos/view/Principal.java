package gusto.fatec.so.processos.view;

import gusto.fatec.so.processos.controller.OpController;

public class Principal {

	public static void main(String[] args) {
		OpController opController = new OpController();
		opController.preencheString();
		opController.preencheBuffer();
		String frase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla tortor nisl, tincidunt vel orci vitae, "
				+ "tincidunt tristique sem. Nam in tempus diam. ";
		opController.quebraFrase(frase);
	}

}