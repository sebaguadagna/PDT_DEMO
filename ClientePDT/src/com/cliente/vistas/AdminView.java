package com.cliente.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cliente.utils.ColorArrowUI;
import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineDocumentoCategoriaBean;
import com.cliente.utils.PipelineEstadoUsuarioBean;
import com.cliente.utils.PipelineTipoUsuarioBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.DocumentoCategoria;
import com.entities.EstadoUsuario;
import com.entities.TipoUsuario;
import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.naming.NamingException;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AdminView {

	private JFrame frame;
	private JTextField nameField;
	private JTextField apellidoField;
	private JTextField documentoField;
	private JTextField emailField;
	private JTextField userNameField;
	private JTextField passwordField;
	private JTextField direccionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1104, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 313, 645);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JComboBox<EUsuario> comboBoxEstado = new JComboBox<EUsuario>();
		comboBoxEstado.setBackground(new Color(255, 255, 255));
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxEstado.setUI(ColorArrowUI.createUI(comboBoxEstado));
		for(EUsuario e: EUsuario.values()) {
			comboBoxEstado.addItem(e);
		}
		comboBoxEstado.setBounds(740, 352, 169, 34);
		frame.getContentPane().add(comboBoxEstado);
		
		
		JComboBox<TUsuarios> comboBoxRol = new JComboBox<TUsuarios>();
		comboBoxRol.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxRol.setUI(ColorArrowUI.createUI(comboBoxRol));
		comboBoxRol.setBackground(new Color(255, 255, 255));
		comboBoxRol.setBounds(740, 527, 169, 34);
		for(TUsuarios t: TUsuarios.values()) {
			comboBoxRol.addItem(t);
		}
		frame.getContentPane().add(comboBoxRol);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminView.class.getResource("/com/cliente/images/Bird.png")));
		lblNewLabel.setBounds(34, 369, 269, 256);
		panel.add(lblNewLabel);
		
		JButton listarUsuarioBoton = new JButton("Listar Usuario");
		listarUsuarioBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListarUsuarios.main(null);
			}
		});
		listarUsuarioBoton.setBounds(34, 205, 241, 39);
		panel.add(listarUsuarioBoton);
		listarUsuarioBoton.setForeground(Color.WHITE);
		listarUsuarioBoton.setFont(new Font("Tahoma", Font.BOLD, 13));
		listarUsuarioBoton.setBackground(new Color(255, 51, 102));
		
		
		JButton ModificarUsuario = new JButton("Modificar Usuario");
		ModificarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModUsuario.main(null);
			}
		});
		ModificarUsuario.setForeground(Color.WHITE);
		ModificarUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		ModificarUsuario.setBackground(new Color(204, 102, 0));
		ModificarUsuario.setBounds(34, 282, 241, 39);
		panel.add(ModificarUsuario);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAdmin.setBounds(94, 47, 123, 47);
		panel.add(lblAdmin);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 255));
		panel_1.setBounds(312, 28, 331, 68);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGestionDeUsuario = new JLabel("Alta de Usuario");
		lblGestionDeUsuario.setBounds(25, 11, 225, 29);
		lblGestionDeUsuario.setForeground(Color.WHITE);
		lblGestionDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblGestionDeUsuario);
		
		JComboBox <CDocumento> comboBoxTipoDocumento = new JComboBox<CDocumento>();
		comboBoxTipoDocumento.setBackground(new Color(255, 255, 255));
		comboBoxTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTipoDocumento.setUI(ColorArrowUI.createUI(comboBoxTipoDocumento));
		for(CDocumento c: CDocumento.values()) {
			comboBoxTipoDocumento.addItem(c);
		}
		comboBoxTipoDocumento.setBounds(400, 352, 169, 34);
		frame.getContentPane().add(comboBoxTipoDocumento);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(740, 415, 73, 14);
		frame.getContentPane().add(lblPassword);
		lblPassword.setForeground(new Color(102, 51, 204));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmail = new JLabel("eMail");
		lblEmail.setBounds(740, 130, 46, 14);
		frame.getContentPane().add(lblEmail);
		lblEmail.setForeground(new Color(102, 51, 204));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(400, 130, 73, 14);
		frame.getContentPane().add(lblNombre);
		lblNombre.setForeground(new Color(102, 51, 204));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(740, 228, 81, 14);
		frame.getContentPane().add(lblUsername);
		lblUsername.setForeground(new Color(102, 51, 204));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblDireccion = new JLabel("Dirección");
		lblDireccion.setForeground(new Color(102, 51, 204));
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccion.setBounds(400, 498, 73, 14);
		frame.getContentPane().add(lblDireccion);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(new Color(102, 51, 204));
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstado.setBounds(740, 321, 81, 14);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setForeground(new Color(102, 51, 204));
		lblTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDocumento.setBounds(400, 315, 138, 26);
		frame.getContentPane().add(lblTipoDocumento);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setForeground(new Color(102, 51, 204));
		lblRol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRol.setBounds(740, 490, 58, 22);
		frame.getContentPane().add(lblRol);
		
		JLabel lblNumDocumento = new JLabel("Num. Documento");
		lblNumDocumento.setForeground(new Color(102, 51, 204));
		lblNumDocumento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumDocumento.setBounds(400, 409, 138, 26);
		frame.getContentPane().add(lblNumDocumento);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(102, 51, 204));
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(400, 218, 73, 34);
		frame.getContentPane().add(lblApellido);
		
		nameField = new JTextField();
		nameField.setForeground(Color.DARK_GRAY);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameField.setBounds(400, 150, 169, 31);
		nameField.setBorder(null);
		nameField.setColumns(10);
		frame.getContentPane().add(nameField);
		
		JSeparator separatorName = new JSeparator();
		separatorName.setBackground(new Color(102, 51, 204));
		separatorName.setBounds(400, 190, 183, 2);
		frame.getContentPane().add(separatorName);
		
		apellidoField = new JTextField();
		apellidoField.setForeground(Color.DARK_GRAY);
		apellidoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		apellidoField.setColumns(10);
		apellidoField.setBorder(null);
		apellidoField.setBounds(400, 245, 169, 31);
		frame.getContentPane().add(apellidoField);
		
		JSeparator separatorApellido = new JSeparator();
		separatorApellido.setBackground(new Color(102, 51, 204));
		separatorApellido.setBounds(400, 286, 183, 2);
		frame.getContentPane().add(separatorApellido);
		
		documentoField = new JTextField();
		documentoField.setForeground(Color.DARK_GRAY);
		documentoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		documentoField.setColumns(10);
		documentoField.setBorder(null);
		documentoField.setBounds(400, 446, 169, 31);
		frame.getContentPane().add(documentoField);
		
		JSeparator separatorDocumento = new JSeparator();
		separatorDocumento.setBackground(new Color(102, 51, 204));
		separatorDocumento.setBounds(400, 479, 183, 2);
		frame.getContentPane().add(separatorDocumento);
		
		emailField = new JTextField();
		emailField.setForeground(Color.DARK_GRAY);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailField.setColumns(10);
		emailField.setBorder(null);
		emailField.setBounds(740, 150, 169, 31);
		frame.getContentPane().add(emailField);
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setBackground(new Color(102, 51, 204));
		separatorEmail.setBounds(740, 190, 183, 2);
		frame.getContentPane().add(separatorEmail);
		
		userNameField = new JTextField();
		userNameField.setForeground(Color.DARK_GRAY);
		userNameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userNameField.setColumns(10);
		userNameField.setBorder(null);
		userNameField.setBounds(740, 253, 169, 31);
		frame.getContentPane().add(userNameField);
		
		JSeparator separatorUserName = new JSeparator();
		separatorUserName.setBackground(new Color(102, 51, 204));
		separatorUserName.setBounds(740, 286, 183, 2);
		frame.getContentPane().add(separatorUserName);
		
		passwordField = new JTextField();
		passwordField.setForeground(Color.DARK_GRAY);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBounds(740, 446, 169, 31);
		frame.getContentPane().add(passwordField);
		
		JSeparator separatorPassword = new JSeparator();
		separatorPassword.setBackground(new Color(102, 51, 204));
		separatorPassword.setBounds(740, 477, 183, 2);
		frame.getContentPane().add(separatorPassword);
		
		direccionField = new JTextField();
		direccionField.setForeground(Color.DARK_GRAY);
		direccionField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		direccionField.setColumns(10);
		direccionField.setBorder(null);
		direccionField.setBounds(400, 523, 169, 31);
		frame.getContentPane().add(direccionField);
		
		JSeparator separatorDireccion = new JSeparator();
		separatorDireccion.setBackground(new Color(102, 51, 204));
		separatorDireccion.setBounds(400, 559, 183, 2);
		frame.getContentPane().add(separatorDireccion);
		
		
		JButton crearUsuarioBoton = new JButton("Crear Usuario");
		crearUsuarioBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Verificamos que no queden campos vacios en el formulario.(mvi = mensajes vacios informar)
				Component[] componentes = frame.getContentPane().getComponents();
				String mvi = "No deben quedar campos vacíos, por favor verifique que ingresó todos los datos solicitados";
				Inspirate mFormat = new Inspirate(mvi);
				JLabel messageVacio = mFormat.getMessageJLabelFormat();
				messageVacio.setHorizontalAlignment(SwingConstants.CENTER);
				for(Component c: componentes) {
					if(c instanceof JTextField && ((JTextField) c).getText().length() == 0) {
						JOptionPane.showMessageDialog(null, messageVacio,"Atención", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				
				//Verificamos que el emal esten el formato correcto (mei = mensaje email incorrecto)
				String mei = "Por favor verifique que el formato del email es el correcto";
				Inspirate meiFormat = new Inspirate(mei);
				JLabel messageEmail = meiFormat.getMessageJLabelFormat();
				messageEmail.setHorizontalAlignment(SwingConstants.CENTER);
				if(!emailField.getText().matches(Inspirate.EMAIL_PATTERN)) {
					JOptionPane.showMessageDialog(null, messageEmail,"AtenciÃ³n", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				
				try {
					//Tabla ESTADO_USUARIOS get de la PK por item seleccionado en el combobox para el Estado
					int euPK;
					PipelineEstadoUsuarioBean estadoQueryTabla = new PipelineEstadoUsuarioBean();
					EUsuario euCB = (EUsuario) comboBoxEstado.getSelectedItem();
					List<EstadoUsuario> eu = estadoQueryTabla.getQuery().obtenerPorEstado(euCB);
					euPK = eu.get(0).getId_estado_usuario();
					
					//Tabla TIPO_USUARIOS get de la PK por item seleccionado en el combobox para el ROL
					int tuPK;
					PipelineTipoUsuarioBean tipoQueryTabla = new PipelineTipoUsuarioBean();
					TUsuarios tuCB = (TUsuarios) comboBoxRol.getSelectedItem();
					List<TipoUsuario> tu = tipoQueryTabla.getQuery().obtenerPorRol(tuCB);
					tuPK = tu.get(0).getId_tipo_usuario();
					
					//Tabla DOCUMENTO_CATEGORIAS get de la PK por item seleccionado en el combobox para el tipo de documento.
					int dcPK;
					PipelineDocumentoCategoriaBean documentoQueryTabla = new PipelineDocumentoCategoriaBean();
					CDocumento dcCB = (CDocumento) comboBoxTipoDocumento.getSelectedItem();
					List<DocumentoCategoria> dc = documentoQueryTabla.getQuery().obtenerPorCategoria(dcCB);
					dcPK = dc.get(0).getId_docu_categoria();

					//Creamos el Usuario
					PipelineUsuarioBean userQueryTabla = new PipelineUsuarioBean();
					userQueryTabla.getQuery().altaUsuario(nameField.getText(),apellidoField.getText(), direccionField.getText(), dcPK, 
							documentoField.getText(), emailField.getText(), euPK, tuPK, userNameField.getText(), passwordField.getText());
					
					//Dejamos un mensaje y limpiamos todos los fields
					String uok = "Operación exitosa, el usuario: "  + userNameField.getText() + " fue creado!";
					Inspirate uokFormat = new Inspirate(uok);
					JLabel messageUsuarioOk =  uokFormat.getMessageJLabelFormat();
					JOptionPane.showMessageDialog(null, messageUsuarioOk,"Atención", JOptionPane.INFORMATION_MESSAGE);
					for(Component c: componentes) {
						if(c instanceof JTextField) {
							((JTextField) c).setText("");
						}
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
		crearUsuarioBoton.setForeground(Color.WHITE);
		crearUsuarioBoton.setFont(new Font("Tahoma", Font.BOLD, 13));
		crearUsuarioBoton.setBackground(new Color(102, 51, 204));
		crearUsuarioBoton.setBounds(34, 136, 241, 39);
		panel.add(crearUsuarioBoton);
		
		JLabel lblInconSalir = new JLabel("");
		lblInconSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		lblInconSalir.setIcon(new ImageIcon(AdminView.class.getResource("/com/cliente/images/Salir.png")));
		lblInconSalir.setBounds(1000, 28, 73, 70);
		frame.getContentPane().add(lblInconSalir);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setForeground(new Color(102, 51, 204));
		lblSalir.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalir.setBounds(944, 56, 46, 14);
		frame.getContentPane().add(lblSalir);
		
		
		
		
		
	}
}
