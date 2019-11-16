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
import com.cliente.utils.PipelineDepartamentoBean;
import com.cliente.utils.PipelineFenomenoBean;
import com.cliente.utils.PipelineLocalidadBean;
import com.cliente.utils.PipelineObservacionBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.Caracteristica;
import com.entities.Departamento;
import com.entities.Fenomeno;
import com.entities.Localidad;
import com.entities.Observacion;
import com.entities.Usuario;
import com.enumerados.NDepartamentos;
import com.enumerados.TipoDato;
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
	private JTextField comentarioField;
	private JTextField valorField;
	private String stringEmailLogin; 

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
	 */
	public VoluntarioView(String emailLogin) {
		initialize();
		
		this.stringEmailLogin = emailLogin;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1104, 664);
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
		
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
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
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(102, 51, 204));
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(402, 312, 102, 31);
		frame.getContentPane().add(lblFecha);
		
		fechaField = new JTextField();
		fechaField.setForeground(Color.DARK_GRAY);
		fechaField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fechaField.setColumns(10);
		fechaField.setBorder(null);
		fechaField.setBounds(402, 345, 169, 31);
		Calendar c = Calendar.getInstance();
		fechaField.setText(c.getTime().toString());
		frame.getContentPane().add(fechaField);
		
		JSeparator separatorFecha = new JSeparator();
		separatorFecha.setBackground(new Color(102, 51, 204));
		separatorFecha.setBounds(402, 378, 183, 2);
		frame.getContentPane().add(separatorFecha);
		
		JLabel lblFenomeno = new JLabel("Fenomeno Cateogira");
		lblFenomeno.setForeground(new Color(102, 51, 204));
		lblFenomeno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFenomeno.setBounds(402, 414, 183, 26);
		frame.getContentPane().add(lblFenomeno);
		
		JComboBox<String> comboBoxFenomeno = new JComboBox<String>();
		comboBoxFenomeno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					System.out.print("Tratando de recuperar fenomeno");
					PipelineFenomenoBean tablaFenomeno = new PipelineFenomenoBean();
					comboBoxFenomeno.removeAllItems();
					List<Fenomeno> fenomenos = tablaFenomeno.getQuery().obtenerTodos();
					for(Fenomeno f : fenomenos) {
						comboBoxFenomeno.addItem(f.getNombre());;
					}
				} catch (NamingException | ServiciosException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		comboBoxFenomeno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxFenomeno.setBackground(Color.WHITE);
		comboBoxFenomeno.setBounds(402, 451, 169, 34);
		frame.getContentPane().add(comboBoxFenomeno);
		
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
		
		JLabel lblTitulo = new JLabel("Alta Observacion");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(68, 25, 225, 29);
		panelTitulo.add(lblTitulo);
		
		JPanel panelCaracteristica = new JPanel();
		panelCaracteristica.setLayout(null);
		panelCaracteristica.setBackground(new Color(153, 153, 255));
		panelCaracteristica.setBounds(738, 188, 360, 83);
		frame.getContentPane().add(panelCaracteristica);
		
		JLabel lblCaracteristicaTitulo = new JLabel("Crear Caracteristica");
		lblCaracteristicaTitulo.setForeground(Color.WHITE);
		lblCaracteristicaTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCaracteristicaTitulo.setBounds(23, 22, 279, 29);
		panelCaracteristica.add(lblCaracteristicaTitulo);
		
		JLabel lblNombre = new JLabel("Comentario");
		lblNombre.setForeground(new Color(102, 51, 204));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(738, 312, 102, 31);
		frame.getContentPane().add(lblNombre);
		
		comentarioField = new JTextField();
		comentarioField.setForeground(Color.DARK_GRAY);
		comentarioField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comentarioField.setColumns(10);
		comentarioField.setBorder(null);
		comentarioField.setBounds(738, 343, 169, 31);
		frame.getContentPane().add(comentarioField);
		
		JSeparator separatroComentario = new JSeparator();
		separatroComentario.setBackground(new Color(102, 51, 204));
		separatroComentario.setBounds(738, 378, 183, 2);
		frame.getContentPane().add(separatroComentario);
		
		JLabel lblValor = new JLabel("Dato");
		lblValor.setForeground(new Color(102, 51, 204));
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(738, 414, 183, 26);
		frame.getContentPane().add(lblValor);
		
		JComboBox<TipoDato> comboBoxValor = new JComboBox<TipoDato>();
		comboBoxValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxValor.setBackground(Color.WHITE);
		comboBoxValor.setBounds(738, 451, 169, 34);
		for(TipoDato td: TipoDato.values()) {
			comboBoxValor.addItem(td);
		}
		frame.getContentPane().add(comboBoxValor);
		
		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setForeground(new Color(102, 51, 204));
		lblValor_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor_1.setBounds(738, 511, 102, 31);
		frame.getContentPane().add(lblValor_1);
		
		valorField = new JTextField();
		valorField.setForeground(Color.DARK_GRAY);
		valorField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valorField.setColumns(10);
		valorField.setBorder(null);
		valorField.setBounds(738, 541, 169, 31);
		frame.getContentPane().add(valorField);
		
		JSeparator separatorValor = new JSeparator();
		separatorValor.setBackground(new Color(102, 51, 204));
		separatorValor.setBounds(738, 583, 183, 2);
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
			
		JButton buttonCrearObservacion = new JButton("Crear Observación");
		buttonCrearObservacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try {
					
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
					
					//Creamos las conexiones a las tablas y los objetos de entidad
					PipelineObservacionBean tablaObs = new PipelineObservacionBean();
					Observacion obs = new Observacion();
					
					PipelineLocalidadBean tablaLocalidad = new PipelineLocalidadBean();
					Localidad lc = new Localidad();
					
					PipelineDepartamentoBean tablaDepartamento = new PipelineDepartamentoBean();
					Departamento dpto = new Departamento();
					
					PipelineFenomenoBean tablaFenomeno = new PipelineFenomenoBean();
					Fenomeno fem = new Fenomeno();
					
					//La pantalla de login nos retorna el email del usuario
					//Vamos a recuperar a ese usuario para insertarlo tambien como FK en observaciones
					PipelineUsuarioBean tablaUsuario = new PipelineUsuarioBean();
					Usuario usr = new Usuario();
					System.out.print("Con este email hiciste login: " + stringEmailLogin);
					List<Usuario> pkUsr = tablaUsuario.getQuery().obtenerPorUsername(stringEmailLogin);
					usr = tablaUsuario.getQuery().findForMerge(pkUsr.get(0).getId_usuario());		
							
					//Buscamos la localidad seleccionada (comboBox) en la tabla "LOCALIDADES" y recuperamos el resgistro.
					//Luego creamos un objeto de tipo Localidad.
					NDepartamentos dptoEnum = (NDepartamentos) comboBoxDepartamento.getSelectedItem();
					String localidadSeleccionada = (String) comboBoxLocalidad.getSelectedItem();
					List<Localidad> pkLocalidad = tablaLocalidad.getQuery().obtenerLocalidadesPorPk(dptoEnum, localidadSeleccionada );
					lc  = tablaLocalidad.getQuery().findForMerge(pkLocalidad.get(0).getId_localidad());
					
					//Buscamos el departamento seleccionado (comboBox) en la tabla "DEPARTAMENTOS" y recuperamos el resgistro.
					//Luego creamos un objeto de tipo Departamento.
					List<Departamento> dptoPk = tablaDepartamento.getQuery().obtenerPorNombre(dptoEnum);
					dpto = tablaDepartamento.getQuery().findForMerge(dptoPk.get(0).getId_departamento());
					
					//Buscamos el fenomeno seleccionado (comboBox) en la tabla "FENOMENOS" y recuperamos el resgistro.
					//Luego creamos un objeto de tipo Fenomeno.
					List<Fenomeno> femPK = tablaFenomeno.getQuery().obtenerPorNombre(comboBoxFenomeno.getSelectedItem().toString());
					fem = tablaFenomeno.getQuery().findForMerge(femPK.get(0).getId_fenomeno());
					
					//Creamos una caracteristica.
					Caracteristica cta = new Caracteristica();
					cta.setNombre(comentarioField.getText());
					cta.setTipoDato((TipoDato) comboBoxValor.getSelectedItem());
					cta.setEtiqueta(valorField.getText());
					
					//Preparamos el objeto Observacion para persistir posteriormente
					obs.setDescripcion(descripcionField.getText());
					obs.setDepartamento(dpto);
					obs.setLocalidad(lc);
					Calendar c = Calendar.getInstance();
					obs.setFechaHora(c.getTime());
					obs.setDescripcion(descripcionField.getText());
					obs.agregarCaracteristica(cta);
					obs.setCategoria(fem);
					obs.setUsr(usr);
					tablaObs.getQuery().altaObservacion(obs);
					
					//Dejamos un mensaje y limpiamos todos los fields
					String uok = "Operación exitosa, la observacion fue creada!";
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
					
					
					System.out.print(lc.getNombre() + " " + dpto.getNombre());

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
		buttonCrearObservacion.setBounds(36, 230, 241, 39);
		panel.add(buttonCrearObservacion);
		
	}
}
