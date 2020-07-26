package com.cliente.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineEstadoUsuarioBean;
import com.cliente.utils.PipelineTipoUsuarioBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.EstadoUsuario;
import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
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
import java.awt.Component;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModUsuario {

	private JFrame frame;
	private JTextField emailFieldBuscar;
	private JTextField textFieldUsuario;
	private JTextField estadoFieldEstadoActual;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldDireccion;
	private JTextField textFieldPassword;
	private JTextField textFieldTipoDeDocumento;
	private JTextField textFieldDocumento;
	private JTextField textFieldRolDeUsuario;
	private boolean enableFieldToMod;
	private Usuario usuarioModificar;

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
		enableFieldToMod = false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 709, 474);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setEditable(false);
		textFieldUsuario.setBounds(40, 160, 185, 20);
		frame.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JComboBox <EUsuario>ComboBoxEstadoUsuario = new JComboBox<EUsuario>();
		for(EUsuario e: EUsuario.values()) {
			ComboBoxEstadoUsuario.addItem(e);
		}
		ComboBoxEstadoUsuario.setBounds(259, 387, 185, 20);
		frame.getContentPane().add(ComboBoxEstadoUsuario);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(40, 135, 67, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel labelEstadoActual = new JLabel("Estado Actual");
		labelEstadoActual.setBounds(259, 300, 99, 14);
		frame.getContentPane().add(labelEstadoActual);
		
		estadoFieldEstadoActual = new JTextField();
		estadoFieldEstadoActual.setEditable(false);
		estadoFieldEstadoActual.setColumns(10);
		estadoFieldEstadoActual.setBounds(259, 325, 185, 20);
		frame.getContentPane().add(estadoFieldEstadoActual);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setBounds(40, 191, 46, 14);
		frame.getContentPane().add(labelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(40, 213, 185, 20);
		frame.getContentPane().add(textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(40, 244, 46, 14);
		frame.getContentPane().add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(40, 269, 185, 20);
		frame.getContentPane().add(textFieldApellido);
	
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(40, 300, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(40, 325, 185, 20);
		frame.getContentPane().add(textFieldEmail);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(40, 365, 132, 14);
		frame.getContentPane().add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(40, 387, 185, 20);
		frame.getContentPane().add(textFieldDireccion);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(259, 135, 67, 14);
		frame.getContentPane().add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setEditable(false);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(259, 160, 185, 20);
		frame.getContentPane().add(textFieldPassword);
		
	
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento");
		lblTipoDeDocumento.setBounds(259, 191, 121, 14);
		frame.getContentPane().add(lblTipoDeDocumento);
		
		textFieldTipoDeDocumento = new JTextField();
		textFieldTipoDeDocumento.setEditable(false);
		textFieldTipoDeDocumento.setColumns(10);
		textFieldTipoDeDocumento.setBounds(259, 213, 185, 20);
		frame.getContentPane().add(textFieldTipoDeDocumento);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setEditable(false);
		textFieldDocumento.setColumns(10);
		textFieldDocumento.setBounds(259, 269, 185, 20);
		frame.getContentPane().add(textFieldDocumento);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(259, 244, 121, 14);
		frame.getContentPane().add(lblDocumento);
		
		textFieldRolDeUsuario = new JTextField();
		textFieldRolDeUsuario.setEditable(false);
		textFieldRolDeUsuario.setColumns(10);
		textFieldRolDeUsuario.setBounds(477, 160, 185, 20);
		frame.getContentPane().add(textFieldRolDeUsuario);
		
		JLabel lblSeleccionarNuevoRol = new JLabel("Seleccionar Nuevo Rol");
		lblSeleccionarNuevoRol.setBounds(477, 191, 149, 14);
		frame.getContentPane().add(lblSeleccionarNuevoRol);
		
		JComboBox<TUsuarios> comboBoxSeleccionarNuevoRol = new JComboBox<TUsuarios>();
		comboBoxSeleccionarNuevoRol.setBounds(477, 213, 185, 20);
		for(TUsuarios e: TUsuarios.values()) {
			comboBoxSeleccionarNuevoRol.addItem(e);
		}
		frame.getContentPane().add(comboBoxSeleccionarNuevoRol);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 712, 113);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmailBuscar = new JLabel("Buscar por Email");
		lblEmailBuscar.setForeground(Color.WHITE);
		lblEmailBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailBuscar.setBounds(48, 24, 182, 23);
		panel.add(lblEmailBuscar);
		
		emailFieldBuscar = new JTextField();
		emailFieldBuscar.setBounds(45, 60, 185, 20);
		panel.add(emailFieldBuscar);
		emailFieldBuscar.setColumns(10);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setForeground(Color.WHITE);
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonBuscar.setBackground(new Color(153, 0, 102));
		botonBuscar.setBounds(276, 59, 121, 23);
		panel.add(botonBuscar);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.setForeground(Color.WHITE);
		botonModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonModificar.setBackground(new Color(102, 204, 153));
		botonModificar.setBounds(276, 20, 121, 23);
		panel.add(botonModificar);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (enableFieldToMod) {
						PipelineUsuarioBean usuarioDao = new PipelineUsuarioBean();
						usuarioModificar.setNombre(textFieldNombre.getText());
						usuarioModificar.setApellido(textFieldApellido.getText());
						usuarioModificar.setEmail(textFieldEmail.getText());
						usuarioModificar.setDocumento(textFieldDocumento.getText());
						usuarioModificar.setPasswd(textFieldPassword.getText());
						usuarioModificar.setUsername(textFieldUsuario.getText());
						
						
						//Obtener PK de la categoria  del ESTADO del USUARIO
						int euPK;
						PipelineEstadoUsuarioBean estadoQueryTabla = new PipelineEstadoUsuarioBean();
						EUsuario euCB = (EUsuario) ComboBoxEstadoUsuario.getSelectedItem();
						List<EstadoUsuario> eu = estadoQueryTabla.getQuery().obtenerPorEstado(euCB);
						euPK = eu.get(0).getId_estado_usuario();
						
						//Obtener PK del ROL de usuario seleccionado
						int tuPK;
						PipelineTipoUsuarioBean tipoQueryTabla = new PipelineTipoUsuarioBean();
						TUsuarios tuCB = (TUsuarios) comboBoxSeleccionarNuevoRol.getSelectedItem();
						List<TipoUsuario> tu = tipoQueryTabla.getQuery().obtenerPorRol(tuCB);
						tuPK = tu.get(0).getId_tipo_usuario();
						
						
						usuarioDao.getQuery().modificarUsuario(usuarioModificar, euPK, tuPK);
						
						//Limpiamos los campos y dejamos un mensaje.
						String uok = "Operacion exitosa, el usuario";
						Inspirate uokFormat = new Inspirate(uok);
						JLabel messageUsuarioOk =  uokFormat.getMessageJLabelFormat();
						JOptionPane.showMessageDialog(null, messageUsuarioOk,"Atencion", JOptionPane.INFORMATION_MESSAGE);
						Component[] componentes = frame.getContentPane().getComponents();
						for(Component c: componentes) {
							if(c instanceof JTextField) {
								((JTextField) c).setText("");
							}
						}
						
						//Deshabilitamos los campos JtextField nuevamente;
						textFieldUsuario.setEditable(false);
						textFieldNombre.setEditable(false);
						textFieldApellido.setEditable(false);
						textFieldEmail.setEditable(false);
						textFieldDireccion.setEditable(false);
						textFieldDocumento.setEditable(false);
						textFieldPassword.setEditable(false);
						
						//Dejamos el booleano que verifica si hay datos en false
						enableFieldToMod = false;
					}else {
						String errorNoHayValores = "No se modifico ningun valor";
						Inspirate err = new Inspirate(errorNoHayValores);
						JLabel messageUsuarioOk =  err.getMessageJLabelFormat();
						JOptionPane.showMessageDialog(null, messageUsuarioOk,"Atencion", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				} catch (NamingException | ServiciosException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGuardarCambios.setForeground(Color.WHITE);
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarCambios.setBackground(new Color(204, 51, 0));
		btnGuardarCambios.setBounds(473, 59, 153, 23);
		panel.add(btnGuardarCambios);
		
		JLabel lblModificarEstado = new JLabel("Modificar Estado");
		lblModificarEstado.setBounds(259, 365, 110, 14);
		frame.getContentPane().add(lblModificarEstado);
		
		JLabel lblModificarRol = new JLabel("Modificar Rol");
		lblModificarRol.setBounds(479, 135, 110, 14);
		frame.getContentPane().add(lblModificarRol);
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(enableFieldToMod) {
					textFieldUsuario.setEditable(true);
					textFieldNombre.setEditable(true);
					textFieldApellido.setEditable(true);
					textFieldEmail.setEditable(true);
					textFieldDireccion.setEditable(true);
					textFieldDocumento.setEditable(true);
					textFieldPassword.setEditable(true);
				}else {
					String noHayDatos = "No hay datos para modificar";
					Inspirate uokFormat = new Inspirate(noHayDatos);
					JLabel messageNoHayDatos =  uokFormat.getMessageJLabelFormat();
					JOptionPane.showMessageDialog(null, messageNoHayDatos,"Atencion", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			
		});
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				PipelineUsuarioBean usuarioTableQuery;
				try {
					usuarioTableQuery = new PipelineUsuarioBean();
					List<Usuario> usuario_filtro = usuarioTableQuery.getQuery().obtenerPorEmail(emailFieldBuscar.getText());
					if(!usuario_filtro.isEmpty()) {
						enableFieldToMod = true;
						usuarioModificar = usuario_filtro.get(0);
						System.out.print("ESTE ES MI NOMBRE " + usuarioModificar.getNombre());
						textFieldUsuario.setText(usuario_filtro.get(0).getUsername());
						textFieldNombre.setText(usuario_filtro.get(0).getNombre());
						textFieldApellido.setText(usuario_filtro.get(0).getApellido());
						textFieldEmail.setText(usuario_filtro.get(0).getEmail());
						textFieldDireccion.setText(usuario_filtro.get(0).getDireccion());
						textFieldTipoDeDocumento.setText(usuario_filtro.get(0).getDoc().getCategoria_nombre().toString());
						textFieldDocumento.setText(usuario_filtro.get(0).getDocumento());
						textFieldPassword.setText(usuario_filtro.get(0).getPasswd());
						textFieldRolDeUsuario.setText(usuario_filtro.get(0).getRol().getRol().toString());
						estadoFieldEstadoActual.setText(usuario_filtro.get(0).getEstado().getEstado_valor().toString());
						
					    
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
	}
}
