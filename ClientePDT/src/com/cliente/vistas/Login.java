package com.cliente.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.cliente.utils.PipelineUsuarioBean;
import com.entities.Usuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Login {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1104, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1098, 635);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel jpanelLogin = new JPanel();
		jpanelLogin.setBorder(null);
		jpanelLogin.setBackground(Color.WHITE);
		jpanelLogin.setBounds(708, 69, 330, 496);
		panel.add(jpanelLogin);
		jpanelLogin.setLayout(null);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "deprecation", "null" })
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					PipelineUsuarioBean userEntity = new PipelineUsuarioBean();
					List<Usuario> userEmail = userEntity.getQuery().obtenerPorEmail(usernameField.getText());
					
					if(!userEmail.isEmpty()){
						if (userEmail.get(0).getPasswd().equals(passwordField.getText())) {
							
							String rol = userEmail.get(0).getRol().getRol().toString();
							System.out.print("ESTE ES EL CORREO: " + userEmail.get(0).getEmail());
							String email[]  = {userEmail.get(0).getEmail()};
							
							
							  if(rol.equals(TUsuarios.ADMINISTRADOR.toString())) { AdminView.main(null);
							  frame.dispose(); }
							  
							  if(rol.equals(TUsuarios.EXPERTO.toString())) { ExpertoView.main(email);
							  frame.dispose(); }
							  
							  if(rol.equals(TUsuarios.VOLUNTARIO.toString())) { VoluntarioView.main(email);
							  frame.dispose(); }

							 
							
						}else {
							System.out.print("La contraseÃ±a es incorrecta");
						}
					}else {
						System.out.print("No se encontro ningun usuario con esa direccion de correo");
						
					}
				} catch (NamingException | ServiciosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 51, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(50, 397, 241, 39);
		jpanelLogin.add(btnNewButton);
		
		usernameField = new JTextField();
		usernameField.setForeground(Color.DARK_GRAY);
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameField.setBounds(46, 154, 245, 31);
		usernameField.setBorder(null);
		jpanelLogin.add(usernameField);
		usernameField.setColumns(10);
		
		JSeparator separatorUsername = new JSeparator();
		separatorUsername.setBounds(36, 187, 270, 2);
		separatorUsername.setBackground(new Color(102, 51, 204));
		jpanelLogin.add(separatorUsername);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBorder(null);
		passwordField.setBounds(50, 270, 245, 31);
		jpanelLogin.add(passwordField);
		
		JSeparator separatorPassword = new JSeparator();
		separatorPassword.setBackground(new Color(102, 51, 204));
		separatorPassword.setBounds(35, 303, 270, 2);
		jpanelLogin.add(separatorPassword);
		
		JLabel lblSingin = new JLabel("INGRESAR");
		lblSingin.setForeground(new Color(102, 51, 204));
		lblSingin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSingin.setBounds(109, 37, 134, 22);
		jpanelLogin.add(lblSingin);
		
		JLabel lblEmail = new JLabel("eMail");
		lblEmail.setForeground(new Color(102, 51, 204));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(35, 129, 46, 14);
		jpanelLogin.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(102, 51, 204));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(32, 245, 73, 14);
		jpanelLogin.add(lblPassword);
		
		JLabel lblProyectoChaja = new JLabel("Proyecto Chaja");
		lblProyectoChaja.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProyectoChaja.setForeground(Color.WHITE);
		lblProyectoChaja.setBounds(91, 11, 259, 47);
		panel.add(lblProyectoChaja);
		
		JLabel lblNewLabel = new JLabel("Software de Observación Medioambiental");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(new Color(204, 102, 255));
		lblNewLabel.setBounds(91, 69, 513, 20);
		panel.add(lblNewLabel);
		
		JLabel lblRegistroDeObservaciones = new JLabel("Registro de observaciones en tiempo real:");
		lblRegistroDeObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRegistroDeObservaciones.setForeground(SystemColor.info);
		lblRegistroDeObservaciones.setBounds(91, 100, 513, 24);
		panel.add(lblRegistroDeObservaciones);
		
		JLabel lblBiomarcadores = new JLabel("Especies Nativas");
		lblBiomarcadores.setForeground(SystemColor.info);
		lblBiomarcadores.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBiomarcadores.setBounds(91, 145, 259, 24);
		panel.add(lblBiomarcadores);
		
		JLabel lblPlagas = new JLabel("Plagas");
		lblPlagas.setForeground(SystemColor.info);
		lblPlagas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlagas.setBounds(91, 170, 259, 24);
		panel.add(lblPlagas);
		
		JLabel lblIncendiosInundacionesSequias = new JLabel("Incendios, Inundaciones, Sequias, Precipitaciones");
		lblIncendiosInundacionesSequias.setForeground(SystemColor.info);
		lblIncendiosInundacionesSequias.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIncendiosInundacionesSequias.setBounds(91, 123, 700, 24);
		panel.add(lblIncendiosInundacionesSequias);
		
		JLabel labelBird = new JLabel("");
		labelBird.setIcon(new ImageIcon(Login.class.getResource("/com/cliente/images/Bird.png")));
		labelBird.setBounds(249, 310, 243, 234);
		panel.add(labelBird);
		
		JLabel labelTree = new JLabel("");
		labelTree.setIcon(new ImageIcon(Login.class.getResource("/com/cliente/images/Tree.png")));
		labelTree.setBounds(57, 279, 245, 265);
		panel.add(labelTree);
		
		JLabel labelSun = new JLabel("");
		labelSun.setIcon(new ImageIcon(Login.class.getResource("/com/cliente/images/sunny.png")));
		labelSun.setBounds(440, 110, 243, 271);
		panel.add(labelSun);
		
		JLabel labelGradient = new JLabel("");
		labelGradient.setBounds(0, 0, 1098, 636);
		panel.add(labelGradient);
		labelGradient.setVerticalAlignment(SwingConstants.TOP);
		labelGradient.setIcon(new ImageIcon(Login.class.getResource("/com/cliente/images/Purpink.jpg")));
	}
}
