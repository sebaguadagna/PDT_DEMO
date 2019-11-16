package com.cliente.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineEstadoUsuarioBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.EstadoUsuario;
import com.entities.Usuario;
import com.enumerados.EUsuario;
import com.exception.ServiciosException;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

public class ModUsuario {

	private JFrame frame;
	private JTextField emailField;
	private JTextField usuarioField;
	private JTextField estadoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModUsuario window = new ModUsuario();
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
	public ModUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 521, 274);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(60, 43, 185, 20);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				PipelineUsuarioBean usuarioTableQuery;
				try {
					usuarioTableQuery = new PipelineUsuarioBean();
					List<Usuario> usuario_filtro = usuarioTableQuery.getQuery().obtenerPorUsername(emailField.getText());
					if(!usuario_filtro.isEmpty()) {
						usuarioField.setText(usuario_filtro.get(0).getUsername());
						estadoField.setText(usuario_filtro.get(0).getEstado().getEstadoNombre().toString());
					    
					}else {
						JOptionPane.showMessageDialog(null, "No se ecuentra un usuario con ese correo", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (NamingException | ServiciosException e) {
					String em = e.getMessage();
					Inspirate emFormat = new Inspirate(em);
					JLabel messageUserError = emFormat.getMessageJLabelFormat();
					messageUserError.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, messageUserError, "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		botonBuscar.setBounds(296, 42, 121, 23);
		frame.getContentPane().add(botonBuscar);
		
		usuarioField = new JTextField();
		usuarioField.setEditable(false);
		usuarioField.setBounds(60, 113, 185, 20);
		frame.getContentPane().add(usuarioField);
		usuarioField.setColumns(10);
		
		JComboBox <EUsuario>estadoUsuarioComboBox = new JComboBox<EUsuario>();
		for(EUsuario e: EUsuario.values()) {
			estadoUsuarioComboBox.addItem(e);
		}
		estadoUsuarioComboBox.setBounds(60, 180, 143, 20);
		frame.getContentPane().add(estadoUsuarioComboBox);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(60, 18, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(60, 88, 67, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(60, 155, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		JLabel labelEstadoActual = new JLabel("Estado Actual");
		labelEstadoActual.setBounds(296, 88, 99, 14);
		frame.getContentPane().add(labelEstadoActual);
		
		estadoField = new JTextField();
		estadoField.setEditable(false);
		estadoField.setColumns(10);
		estadoField.setBounds(296, 113, 121, 20);
		frame.getContentPane().add(estadoField);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					PipelineUsuarioBean usuarioTableQuery;
					usuarioTableQuery = new PipelineUsuarioBean();
					List<Usuario> usuario_filtro = usuarioTableQuery.getQuery().obtenerPorUsername(emailField.getText());
					if(!usuario_filtro.isEmpty()) {
						usuarioField.setText(usuario_filtro.get(0).getUsername());
						estadoField.setText(usuario_filtro.get(0).getEstado().getEstadoNombre().toString());
						Long valor = usuario_filtro.get(0).getId_usuario();
						Usuario user_m = usuarioTableQuery.getQuery().findForMerge(valor);
						
						//Obtener PK de la categoria seleccionada para el estado del usuario.
						int euPK;
						PipelineEstadoUsuarioBean estadoQueryTabla = new PipelineEstadoUsuarioBean();
						EUsuario euCB = (EUsuario) estadoUsuarioComboBox.getSelectedItem();
						List<EstadoUsuario> eu = estadoQueryTabla.getQuery().obtenerPorEstado(euCB);
						euPK = eu.get(0).getId_estado_usuario();
						
						//Modificar el usuario
						usuarioTableQuery.getQuery().modificarUsuario(user_m, euPK);
						
					    
					}else {
						JOptionPane.showMessageDialog(null, "No se ecuentra un usuario con ese correo", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NamingException | ServiciosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		botonModificar.setBounds(296, 179, 121, 23);
		frame.getContentPane().add(botonModificar);
	}
}
