package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import trabalho1.Gerenciador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtUsuario = new JLabel("Usuario");
		txtUsuario.setBounds(24, 28, 46, 14);
		contentPane.add(txtUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(24, 43, 139, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel txtSenha = new JLabel("Senha");
		txtSenha.setBounds(24, 74, 46, 14);
		contentPane.add(txtSenha);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(24, 90, 139, 20);
		contentPane.add(textSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String nome = textUsuario.getText();
				 String senha = textSenha.getText();
				
				if(Gerenciador.login(nome, senha) == -1)
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
				else {
					new MenuEstudante().setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		btnEntrar.setBounds(84, 155, 89, 23);
		contentPane.add(btnEntrar);
	}
}