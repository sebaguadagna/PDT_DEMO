package com.cliente.vistas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cliente.utils.PipelineUsuarioBean;
import com.entities.Usuario;
import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearUsuarios {

	private JFrame frame;
	private JTextField tfEmail;
	private JTextField tfDocumento;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfDireccion;
	private JTextField tfApellido;
	private JTextField tfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuarios window = new CrearUsuarios();
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
	public CrearUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 501, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblRol = new JLabel("Rol");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		JComboBox<TUsuarios> cbRol = new JComboBox<TUsuarios>();
		TUsuarios rolUsuario [] = {TUsuarios.ADMINISTRADOR, TUsuarios.EXPERTO,
				TUsuarios.VOLUNTARIO};
		for(int i = 0; i<rolUsuario.length;i++) {
			cbRol.addItem(rolUsuario[i]);
		}
		
		JLabel lblNewLabel = new JLabel("Email@");
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		
		JComboBox<CDocumento> cbTipoDocumento = new JComboBox<CDocumento>();
		CDocumento tdUsuario [] = {CDocumento.CI, CDocumento.PASAPORTE,
				CDocumento.CARTA_CIUDADANIA, CDocumento.OTROS};
		for(int i=0;i<tdUsuario.length;i++) {
			cbTipoDocumento.addItem(tdUsuario[i]);
		}
		
		JLabel lblNumdocuento = new JLabel("NumDocuento");
		
		tfDocumento = new JTextField();
		tfDocumento.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		
		JRadioButton rdHabilitar = new JRadioButton("Habilitado");
		
		JLabel lblUsername = new JLabel("Username");
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Component[] componentes = frame.getContentPane().getComponents();
				
	
				for(Component c: componentes) {
					if(c instanceof JTextField && ((JTextField) c).getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "No deben quedar campos vacios, por favor verifique que ingreso todos los datos solicitados");
						return;
					}
				}
				
				
				try {
					PipelineUsuarioBean userBD = new PipelineUsuarioBean();
					Usuario user = new Usuario();
					user.setNombre(tfNombre.getText());
					user.setApellido(tfApellido.getText());
					user.setDireccion(tfDireccion.getText());
					user.setDoc((CDocumento) cbTipoDocumento.getSelectedItem());            
					user.setDocumento(tfDocumento.getText());
					user.setEmail(tfEmail.getText());
					if(rdHabilitar.isEnabled()) {
						user.setEstado(EUsuario.HABILITADO); 
					}
					else {
						user.setEstado(EUsuario.DESHABILITADO);
					}
					user.setRol((TUsuarios) cbRol.getSelectedItem());    //Campo Enumerado
					user.setUsername(tfUsername.getText());
					user.setPassword(tfPassword.getText());
					userBD.getQuery().altaUsuario(user);
					JOptionPane.showMessageDialog(null, "Operacion Exitosa, el usuario: " + user.getUsername() + " fue creado!");
					for(Component c: componentes) {
						if(c instanceof JTextField) {
							((JTextField) c).setText("");
						}
					}

					
				} catch (NamingException | ServiciosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblDireccion)
								.addComponent(lblApellido)
								.addComponent(lblNombre)
								.addComponent(lblUsername)
								.addComponent(lblEstado)
								.addComponent(lblRol)
								.addComponent(lblPassword)
								.addComponent(lblTipoDocumento)
								.addComponent(lblNumdocuento))
							.addGap(99))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(135, Short.MAX_VALUE)
							.addComponent(btnGuardar)
							.addGap(72)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdHabilitar)
						.addComponent(cbRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbTipoDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccion))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDocumento)
						.addComponent(cbTipoDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumdocuento)
						.addComponent(tfDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRol)
						.addComponent(cbRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdHabilitar, Alignment.LEADING)
						.addComponent(lblEstado, Alignment.LEADING))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPassword)
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnGuardar))
							.addGap(24))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(101))))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
