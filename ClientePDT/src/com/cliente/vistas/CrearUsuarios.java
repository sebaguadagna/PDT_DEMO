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
import javax.swing.SwingConstants;

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

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.UIManager;

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
		frame.setBounds(100, 100, 420, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblApellido = new JLabel("Apellido");

		JLabel lblRol = new JLabel("Rol");

		JLabel lblDireccion = new JLabel("Direccion");

		JComboBox<TUsuarios> cbRol = new JComboBox<TUsuarios>();
		for(TUsuarios t: TUsuarios.values()) {
			cbRol.addItem(t);
		}

		JLabel lblNewLabel = new JLabel("Email@");

		tfEmail = new JTextField();
		tfEmail.setColumns(10);

		JLabel lblTipoDocumento = new JLabel("Tipo Documento");

		JComboBox<CDocumento> cbTipoDocumento = new JComboBox<CDocumento>();
		for(CDocumento c: CDocumento.values()) {
			cbTipoDocumento.addItem(c);
		}

		JComboBox<EUsuario> cbEstado = new JComboBox<EUsuario>();
		for(EUsuario e: EUsuario.values()) {
			cbEstado.addItem(e);
		}

		JLabel lblNumdocuento = new JLabel("NumDocuento");

		tfDocumento = new JTextField();
		tfDocumento.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");

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

				//Verificamos que no queden campos vacios en el formulario.(mvi = mensajes vacios informar)
				Component[] componentes = frame.getContentPane().getComponents();
				String mvi = "No deben quedar campos vacios, por favor verifique que ingresó todos los datos solicitados";
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
				if(!tfEmail.getText().matches(Inspirate.EMAIL_PATTERN)) {
					JOptionPane.showMessageDialog(null, messageEmail,"Atención", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				//Antes de crear al usuario nos traemos las PK de las FK que tenemos que ingresar en la tabla usuario. 
				//Insertar un usuario es a traves del metodo find y necesita la PK del registro en tabla que queremos asociar.
				try {
					//Tabla ESTADO_USUARIOS get de la PK por item seleccionado en el combobox para el Estado
					int euPK;
					PipelineEstadoUsuarioBean estadoQueryTabla = new PipelineEstadoUsuarioBean();
					EUsuario euCB = (EUsuario) cbEstado.getSelectedItem();
					List<EstadoUsuario> eu = estadoQueryTabla.getQuery().obtenerPorEstado(euCB);
					euPK = eu.get(0).getId_estado_usuario();

					//Tabla TIPO_USUARIOS get de la PK por item seleccionado en el combobox para el ROL
					int tuPK;
					PipelineTipoUsuarioBean tipoQueryTabla = new PipelineTipoUsuarioBean();
					TUsuarios tuCB = (TUsuarios) cbRol.getSelectedItem();
					List<TipoUsuario> tu = tipoQueryTabla.getQuery().obtenerPorRol(tuCB);
					tuPK = tu.get(0).getId_tipo_usuario();

					//Tabla DOCUMENTO_CATEGORIAS get de la PK por item seleccionado en el combobox para el tipo de documento.
					int dcPK;
					PipelineDocumentoCategoriaBean documentoQueryTabla = new PipelineDocumentoCategoriaBean();
					CDocumento dcCB = (CDocumento) cbTipoDocumento.getSelectedItem();
					List<DocumentoCategoria> dc = documentoQueryTabla.getQuery().obtenerPorCategoria(dcCB);
					dcPK = dc.get(0).getId_docu_categoria();

					//Creamos el Usuario
					PipelineUsuarioBean userQueryTabla = new PipelineUsuarioBean();
					userQueryTabla.getQuery().altaUsuario(tfNombre.getText(), 
							tfApellido.getText(), tfDireccion.getText(), 
							dcPK, tfDocumento.getText(), tfEmail.getText(), euPK, tuPK, tfUsername.getText(), tfPassword.getText());

					//Dejamos un mensaje y limpiamos todos los fields
					String uok = "Operación exitosa, el usuario: "  + tfUsername.getText() + " fue creado!";
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
					messageVacio.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, messageUserError, "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}

			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				frame.dispose();
			}
		});

		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("CheckBoxMenuItem.acceleratorSelectionForeground"));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
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
												.addGroup(groupLayout.createSequentialGroup()
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
												.addComponent(cbRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbTipoDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnCancelar)
												.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
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
						.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRol)
								.addComponent(cbRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado)
								.addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
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
