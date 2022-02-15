package gusto.fatec.so.threads.aula2.view;

import gusto.fatec.so.threads.aula2.controller.ProgressBarController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Font;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Tela frame = new Tela();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Tela() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 132, 98, 49);
		contentPane.add(lblNewLabel);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 35, 188, 42);
		contentPane.add(progressBar);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(10, 228, 89, 23);
		contentPane.add(btnIniciar);

		ProgressBarController pbController = new ProgressBarController(lblNewLabel, progressBar, btnIniciar);
		btnIniciar.addActionListener(pbController);
	}

}
