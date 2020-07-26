package com.cliente.vistas;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineCaracteristicaBean;
import com.cliente.utils.PipelineDetalleBean;
import com.cliente.utils.PipelineFenomenoBean;
import com.cliente.utils.PipelineLocalidadBean;
import com.cliente.utils.PipelineObservacionBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.Caracteristica;
import com.entities.Detalle;
import com.entities.Fenomeno;
import com.entities.Localidad;
import com.entities.Observacion;
import com.entities.Usuario;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VoluntarioView {

	private JFrame frame;
	private JTextField descripcionField;
	private JTextField fechaField;
	private JTextField valorFieldValor;
	private String stringEmailLogin; 
	private JTextField textFieldYear;
	private String[] emailMisObservacionesView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String emailLogin = args[0];
					VoluntarioView window = new VoluntarioView(emailLogin);
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ServiciosException 
	 * @throws NamingException 
	 */
	public VoluntarioView(String emailLogin) throws NamingException, ServiciosException {
		initialize();
		
		this.stringEmailLogin = emailLogin;
		emailMisObservacionesView = new String[1];
		emailMisObservacionesView[0] = emailLogin;
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NamingException 
	 * @throws ServiciosException 
	 */
	private void initialize() throws NamingException, ServiciosException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1161, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 313, 645);
		frame.getContentPane().add(panel);
		
		
		JLabel lblVoluntario = new JLabel("Voluntario");
		lblVoluntario.setForeground(Color.WHITE);
		lblVoluntario.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVoluntario.setBounds(64, 48, 170, 47);
		panel.add(lblVoluntario);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VoluntarioView.class.getResource("/com/cliente/images/Tree.png")));
		label_1.setBounds(23, 369, 269, 256);
		panel.add(label_1);
		
		
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setForeground(new Color(102, 51, 204));
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(402, 203, 102, 31);
		frame.getContentPane().add(lblDescripcion);
		
		descripcionField = new JTextField();
		descripcionField.setForeground(Color.DARK_GRAY);
		descripcionField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descripcionField.setColumns(10);
		descripcionField.setBorder(null);
		descripcionField.setBounds(402, 238, 169, 31);
		frame.getContentPane().add(descripcionField);
		
		JSeparator separatorDescripcion = new JSeparator();
		separatorDescripcion.setBackground(new Color(102, 51, 204));
		separatorDescripcion.setBounds(402, 280, 183, 2);
		frame.getContentPane().add(separatorDescripcion);
		
		JLabel lblFecha = new JLabel("Fecha Creación Observación");
		lblFecha.setForeground(new Color(102, 51, 204));
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(402, 312, 240, 31);
		frame.getContentPane().add(lblFecha);
		
		fechaField = new JTextField();
		fechaField.setBackground(Color.WHITE);
		fechaField.setEditable(false);
		fechaField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fechaField.setColumns(10);
		fechaField.setBorder(null);
		fechaField.setBounds(402, 345, 183, 31);
		Calendar c = Calendar.getInstance();
		fechaField.setText(c.getTime().toString());
		frame.getContentPane().add(fechaField);
		
		JSeparator separatorFecha = new JSeparator();
		separatorFecha.setBackground(new Color(102, 51, 204));
		separatorFecha.setBounds(402, 378, 183, 2);
		frame.getContentPane().add(separatorFecha);
		
		JLabel lblFenomeno = new JLabel("Fenómeno Categoría");
		lblFenomeno.setForeground(new Color(102, 51, 204));
		lblFenomeno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFenomeno.setBounds(402, 414, 183, 26);
		frame.getContentPane().add(lblFenomeno);
		
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(102, 51, 204));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(737, 414, 198, 31);
		frame.getContentPane().add(lblValor);
		
		JComboBox<String> comboBoxCrc = new JComboBox<String>();
		comboBoxCrc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCrc.setBackground(Color.WHITE);
		comboBoxCrc.setBounds(737, 342, 169, 34);
		frame.getContentPane().add(comboBoxCrc);
		
		
		JComboBox<String> comboBoxFenomeno = new JComboBox<String>();
		comboBoxFenomeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PipelineCaracteristicaBean crcDao = new PipelineCaracteristicaBean();
					comboBoxCrc.removeAllItems();
					List<Caracteristica> crcList = crcDao.getQuery().obtenerCrsPorFenomeno(comboBoxFenomeno.getSelectedItem().toString());
					for(Caracteristica c : crcList) {
						comboBoxCrc.addItem(c.getNombre());
					}
					
				} catch (NamingException | ServiciosException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		comboBoxFenomeno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxFenomeno.setBackground(Color.WHITE);
		comboBoxFenomeno.setBounds(402, 451, 169, 34);
		System.out.print("Tratando de recuperar fenomeno");
		PipelineFenomenoBean tablaFenomeno = new PipelineFenomenoBean();
		List<Fenomeno> fenomenos = tablaFenomeno.getQuery().obtenerTodos();
		for(Fenomeno f : fenomenos) {
			comboBoxFenomeno.addItem(f.getNombre().toString());
		}
		frame.getContentPane().add(comboBoxFenomeno);
		
		
		comboBoxCrc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PipelineCaracteristicaBean crcDao = new PipelineCaracteristicaBean();
					List<Caracteristica> crcTipoDeDato = crcDao.getQuery().obtenerCrsPKPorFenomeno(comboBoxFenomeno.getSelectedItem().toString(), 
							comboBoxCrc.getSelectedItem().toString());
					lblValor.setText("Valor: " + crcTipoDeDato.get(0).getTipoDato().toString());
				} catch (ServiciosException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setForeground(new Color(102, 51, 204));
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDepartamento.setBounds(402, 511, 183, 26);
		frame.getContentPane().add(lblDepartamento);
		
		JComboBox<String> comboBoxLocalidad = new JComboBox<String>();
		comboBoxLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxLocalidad.setBackground(Color.WHITE);
		comboBoxLocalidad.setBounds(737, 98, 169, 34);
		frame.getContentPane().add(comboBoxLocalidad);
		
		JComboBox<NDepartamentos> comboBoxDepartamento = new JComboBox<NDepartamentos>();
		comboBoxDepartamento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					PipelineLocalidadBean localidadTabla = new PipelineLocalidadBean();
					NDepartamentos departamento = (NDepartamentos) comboBoxDepartamento.getSelectedItem();
					List<Localidad> l = localidadTabla.getQuery().obtenerLocalidadesPorDepartamento(departamento);
					comboBoxLocalidad.removeAllItems();
					System.out.print("Hola");
					for(Localidad lo : l) {
						comboBoxLocalidad.addItem(lo.getNombre());
					}
				} catch (NamingException | ServiciosException t) {
					t.printStackTrace();
				}
			}
			
		});
		
		comboBoxDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxDepartamento.setBackground(Color.WHITE);
		comboBoxDepartamento.setBounds(402, 551, 169, 34);
		for(NDepartamentos d: NDepartamentos.values()) {
			comboBoxDepartamento.addItem(d);
		}
		frame.getContentPane().add(comboBoxDepartamento);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(new Color(102, 51, 204));
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLocalidad.setBounds(738, 61, 183, 26);
		frame.getContentPane().add(lblLocalidad);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(new Color(153, 153, 255));
		panelTitulo.setBounds(311, 61, 331, 83);
		frame.getContentPane().add(panelTitulo);
		
		JLabel lblTitulo = new JLabel("Alta Observaci\u00F3n");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(68, 25, 225, 29);
		panelTitulo.add(lblTitulo);
		
		JPanel panelCaracteristica = new JPanel();
		panelCaracteristica.setLayout(null);
		panelCaracteristica.setBackground(new Color(153, 153, 255));
		panelCaracteristica.setBounds(738, 188, 360, 83);
		frame.getContentPane().add(panelCaracteristica);
		
		JLabel lblCaracteristicaTitulo = new JLabel("Caracter\u00EDstica-Fen\u00F3meno");
		lblCaracteristicaTitulo.setForeground(Color.WHITE);
		lblCaracteristicaTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCaracteristicaTitulo.setBounds(23, 22, 337, 29);
		panelCaracteristica.add(lblCaracteristicaTitulo);
		
		JLabel lblCaracteristica = new JLabel("Caracter\u00EDstica");
		lblCaracteristica.setForeground(new Color(102, 51, 204));
		lblCaracteristica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaracteristica.setBounds(738, 299, 183, 26);
		frame.getContentPane().add(lblCaracteristica);
		
		
		valorFieldValor = new JTextField();
		valorFieldValor.setForeground(Color.DARK_GRAY);
		valorFieldValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valorFieldValor.setColumns(10);
		valorFieldValor.setBorder(null);
		valorFieldValor.setBounds(737, 444, 169, 31);
		frame.getContentPane().add(valorFieldValor);
		
		JSeparator separatorValor = new JSeparator();
		separatorValor.setBackground(new Color(102, 51, 204));
		separatorValor.setBounds(737, 486, 183, 2);
		frame.getContentPane().add(separatorValor);
		
		JLabel label = new JLabel("Salir");
		label.setForeground(new Color(102, 51, 204));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(959, 45, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login.main(null);
				frame.dispose();
			}
		});
		label_2.setIcon(new ImageIcon(VoluntarioView.class.getResource("/com/cliente/images/Salir.png")));
		label_2.setBounds(1015, 17, 73, 70);
		frame.getContentPane().add(label_2);
			
		JButton buttonCrearObservacion = new JButton("Crear Observaci\u00F3n");
		buttonCrearObservacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try {
					
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
					
					//Creamos las conexiones a las tablas y los objetos de entidad
					PipelineObservacionBean tablaObs = new PipelineObservacionBean();
					Observacion obs = new Observacion();
					
					PipelineLocalidadBean tablaLocalidad = new PipelineLocalidadBean();
					Localidad lc = new Localidad();
					
					PipelineFenomenoBean tablaFenomeno = new PipelineFenomenoBean();
					Fenomeno fem = new Fenomeno();
					
					PipelineCaracteristicaBean daoCrc = new PipelineCaracteristicaBean();
					Caracteristica crc = new Caracteristica();
					
					PipelineDetalleBean daoDetalle = new PipelineDetalleBean();
					Detalle dtl = new Detalle();
					
					//La pantalla de login nos retorna el email del usuario
					//Vamos a recuperar a ese usuario para insertarlo tambien como FK en observaciones
					PipelineUsuarioBean tablaUsuario = new PipelineUsuarioBean();
					Usuario usr = new Usuario();
					List<Usuario> pkUsr = tablaUsuario.getQuery().obtenerPorEmail(stringEmailLogin);
					usr = tablaUsuario.getQuery().findForMerge(pkUsr.get(0).getId_usuario());		
							
					//Buscamos la localidad seleccionada (comboBox) en la tabla "LOCALIDADES" y recuperamos el resgistro.
					//Luego creamos un objeto de tipo Localidad.
					NDepartamentos dptoEnum = (NDepartamentos) comboBoxDepartamento.getSelectedItem();
					String localidadSeleccionada = (String) comboBoxLocalidad.getSelectedItem();
					List<Localidad> pkLocalidad = tablaLocalidad.getQuery().obtenerLocalidadesPorPk(dptoEnum, localidadSeleccionada );
					lc  = tablaLocalidad.getQuery().findForMerge(pkLocalidad.get(0).getId_localidad());
				
					
					//Buscamos el fenomeno seleccionado (comboBox) en la tabla "FENOMENOS" y recuperamos el resgistro.
					//Luego creamos un objeto de tipo Fenomeno.
					List<Fenomeno> femPK = tablaFenomeno.getQuery().obtenerPorNombre(comboBoxFenomeno.getSelectedItem().toString());
					fem = tablaFenomeno.getQuery().findForMerge(femPK.get(0).getId_fenomeno());
					
					//Trabajamos con el DAO de observaciones
					obs.setLocalidad(lc);
					Calendar c = Calendar.getInstance();
					obs.setFechaHora(c);
					obs.setDescripcion(descripcionField.getText());
					obs.setCategoria(fem);
					obs.setUsr_voluntario(usr);
					int pkObs = tablaObs.getQuery().altaObservacion(obs);
					
					//Dao Caracteristica
					List<Caracteristica> crcFiltro = daoCrc.getQuery().obtenerCrsPKPorFenomeno(comboBoxFenomeno.getSelectedItem().toString(), 
							comboBoxCrc.getSelectedItem().toString());
					crc = crcFiltro.get(0);
								
					//Dao Detalle
					dtl.setCrtca(crc);
					dtl.setObs(tablaObs.getQuery().findForMerge(pkObs));
					if(crc.getTipoDato().toString().equals("NUMERO")) {
						int vNum = Integer.parseInt(valorFieldValor.getText());
						dtl.setValor_numerico(vNum);
						dtl.setValor_texto("Sin Datos");
					} else {
						dtl.setValor_texto(valorFieldValor.getText());
						dtl.setValor_numerico(0);
					}
					dtl.setFechaHora(c);
					daoDetalle.getQuery().altaDetalle(dtl);
					
					
					//Dejamos un mensaje y limpiamos todos los fields
					String uok = "Operación exitosa, la observación fue creada!";
					Inspirate uokFormat = new Inspirate(uok);
					JLabel messageUsuarioOk =  uokFormat.getMessageJLabelFormat();
					JOptionPane.showMessageDialog(null, messageUsuarioOk,"Atención", JOptionPane.INFORMATION_MESSAGE);
					for(Component tf: componentes) {
						if(tf instanceof JTextField) {
							((JTextField) tf).setText("");
						}
					}
					Calendar c2 = Calendar.getInstance();
					fechaField.setText(c2.getTime().toString());
					

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
		buttonCrearObservacion.setForeground(Color.WHITE);
		buttonCrearObservacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonCrearObservacion.setBackground(new Color(204, 51, 102));
		buttonCrearObservacion.setBounds(43, 136, 241, 39);
		panel.add(buttonCrearObservacion);
		
		JButton btnListarMisObservaciones = new JButton("Listar Mis Observaciones");
		btnListarMisObservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarMisObservaciones.main(emailMisObservacionesView);
			}
		});
		btnListarMisObservaciones.setForeground(Color.WHITE);
		btnListarMisObservaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListarMisObservaciones.setBackground(new Color(51, 153, 0));
		btnListarMisObservaciones.setBounds(43, 201, 241, 39);
		panel.add(btnListarMisObservaciones);
		
		JButton buttonAgregarOtraCrc = new JButton("Asociar Otra Caracter\u00EDstica");
		buttonAgregarOtraCrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtrasCrcObs.main(null);
			}
		});
		buttonAgregarOtraCrc.setForeground(Color.WHITE);
		buttonAgregarOtraCrc.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonAgregarOtraCrc.setBackground(new Color(51, 51, 255));
		buttonAgregarOtraCrc.setBounds(43, 257, 241, 39);
		panel.add(buttonAgregarOtraCrc);
		
		JLabel labelFechaCra = new JLabel("Fecha");
		labelFechaCra.setForeground(new Color(102, 51, 204));
		labelFechaCra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelFechaCra.setBounds(738, 511, 102, 31);
		frame.getContentPane().add(labelFechaCra);
	
		
		JSeparator separatorFechaCra = new JSeparator();
		separatorFechaCra.setBackground(new Color(102, 51, 204));
		separatorFechaCra.setBounds(738, 577, 183, 2);
		frame.getContentPane().add(separatorFechaCra);
		
		textFieldYear = new JTextField();
		textFieldYear.setForeground(Color.DARK_GRAY);
		textFieldYear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldYear.setColumns(10);
		textFieldYear.setBorder(null);
		textFieldYear.setBounds(737, 540, 184, 31);
		Calendar crc = Calendar.getInstance();
		textFieldYear.setText(crc.getTime().toString());
		frame.getContentPane().add(textFieldYear);
		
		
		
	}
}
