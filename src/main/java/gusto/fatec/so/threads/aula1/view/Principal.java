package gusto.fatec.so.threads.aula1.view;

import gusto.fatec.so.threads.aula1.controller.BolinhaController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Font;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Principal frame = new Principal();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblBolinha1 = new JLabel(".");
		lblBolinha1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblBolinha1.setBounds(58, 64, 68, 74);
		contentPane.add(lblBolinha1);

		JLabel lblBolinha2 = new JLabel(".");
		lblBolinha2.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblBolinha2.setBounds(313, 64, 68, 74);
		contentPane.add(lblBolinha2);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(0, 0, 89, 23);
		contentPane.add(btnIniciar);
		
		BolinhaController bolinhaController = new BolinhaController(lblBolinha1, lblBolinha2, btnIniciar);
		btnIniciar.addActionListener(bolinhaController);
	}

}
