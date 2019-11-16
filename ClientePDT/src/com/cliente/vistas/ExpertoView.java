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

import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineFenomenoBean;
import com.entities.Fenomeno;
import com.exception.ServiciosException;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExpertoView {

	private JFrame frame;
	private JTextField textFieldCodigo;
	private JTextField textFieldDescripcion;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpertoView window = new ExpertoView();
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
	public ExpertoView() {
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
		panel.setLayout(null);
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 313, 645);
		frame.getContentPane().add(panel);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(ExpertoView.class.getResource("/com/cliente/images/sunny.png")));
		lblImagen.setBounds(21, 366, 269, 256);
		panel.add(lblImagen);
		
		JButton botonListarObservaciones = new JButton("Listar Observaciones");
		botonListarObservaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ObservacionesZonasView.main(null);
			}
			
		});
		botonListarObservaciones.setForeground(Color.WHITE);
		botonListarObservaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonListarObservaciones.setBackground(new Color(255, 51, 102));
		botonListarObservaciones.setBounds(34, 205, 241, 39);
		panel.add(botonListarObservaciones);
		
		JButton botonValidarObservacion = new JButton("Validar Observacion");
		botonValidarObservacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ValidarView.main(null);
			}
			
		});
		botonValidarObservacion.setForeground(Color.WHITE);
		botonValidarObservacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonValidarObservacion.setBackground(new Color(204, 102, 0));
		botonValidarObservacion.setBounds(34, 282, 241, 39);
		panel.add(botonValidarObservacion);
		
		JLabel lblEtiqueta = new JLabel("Experto");
		lblEtiqueta.setForeground(Color.WHITE);
		lblEtiqueta.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEtiqueta.setBounds(94, 47, 123, 47);
		panel.add(lblEtiqueta);
		
		JButton botonCrearFenomeno = new JButton("Crear Fenomeno");
		botonCrearFenomeno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PipelineFenomenoBean tablaFenomeno = new PipelineFenomenoBean();
					Fenomeno fem = new Fenomeno();
					
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
					
					fem.setNombre(textFieldNombre.getText());
					fem.setCodigo(textFieldCodigo.getText());
					fem.setDescripcion(textFieldDescripcion.getText());
					fem.setTelefono(textFieldTelefono.getSelectedText());
					tablaFenomeno.getQuery().altaFenomeno(fem);
					
					//Dejamos un mensaje y limpiamos todos los fields
					String uok = "Operación exitosa, el Fenomeno fue creado!";
					Inspirate uokFormat = new Inspirate(uok);
					JLabel messageUsuarioOk =  uokFormat.getMessageJLabelFormat();
					JOptionPane.showMessageDialog(null, messageUsuarioOk,"Atención", JOptionPane.INFORMATION_MESSAGE);
					for(Component c: componentes) {
						if(c instanceof JTextField) {
							((JTextField) c).setText("");
						}
					}
					
					
				} catch (NamingException | ServiciosException e1) {
					String em = e1.getMessage();
					Inspirate emFormat = new Inspirate(em);
					JLabel messageUserError = emFormat.getMessageJLabelFormat();
					messageUserError.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, messageUserError, "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				
			}
		});
		botonCrearFenomeno.setForeground(Color.WHITE);
		botonCrearFenomeno.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonCrearFenomeno.setBackground(new Color(102, 51, 204));
		botonCrearFenomeno.setBounds(34, 136, 241, 39);
		panel.add(botonCrearFenomeno);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(new Color(102, 51, 204));
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(400, 180, 73, 31);
		frame.getContentPane().add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setForeground(Color.DARK_GRAY);
		textFieldCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBorder(null);
		textFieldCodigo.setBounds(400, 225, 169, 31);
		frame.getContentPane().add(textFieldCodigo);
		
		JSeparator separatorCodigo = new JSeparator();
		separatorCodigo.setBackground(new Color(102, 51, 204));
		separatorCodigo.setBounds(400, 261, 183, 2);
		frame.getContentPane().add(separatorCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(new Color(102, 51, 204));
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(400, 311, 123, 31);
		frame.getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setForeground(Color.DARK_GRAY);
		textFieldDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBorder(null);
		textFieldDescripcion.setBounds(400, 350, 169, 31);
		frame.getContentPane().add(textFieldDescripcion);
		
		JSeparator separatorDescripcion = new JSeparator();
		separatorDescripcion.setBackground(new Color(102, 51, 204));
		separatorDescripcion.setBounds(400, 386, 183, 2);
		frame.getContentPane().add(separatorDescripcion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(102, 51, 204));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(750, 180, 73, 31);
		frame.getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.DARK_GRAY);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBorder(null);
		textFieldNombre.setBounds(750, 225, 169, 31);
		frame.getContentPane().add(textFieldNombre);
		
		JSeparator separatorNombre = new JSeparator();
		separatorNombre.setBackground(new Color(102, 51, 204));
		separatorNombre.setBounds(750, 261, 183, 2);
		frame.getContentPane().add(separatorNombre);
		
		JLabel lblTelefono = new JLabel("Telefono de emergencia");
		lblTelefono.setForeground(new Color(102, 51, 204));
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefono.setBounds(750, 311, 177, 31);
		frame.getContentPane().add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setForeground(Color.DARK_GRAY);
		textFieldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBorder(null);
		textFieldTelefono.setBounds(750, 350, 169, 31);
		frame.getContentPane().add(textFieldTelefono);
		
		JSeparator separatorTelefono = new JSeparator();
		separatorTelefono.setBackground(new Color(102, 51, 204));
		separatorTelefono.setBounds(750, 386, 183, 2);
		frame.getContentPane().add(separatorTelefono);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(null);
		panelTitulo.setBackground(new Color(153, 153, 255));
		panelTitulo.setBounds(312, 29, 331, 76);
		frame.getContentPane().add(panelTitulo);
		
		JLabel lblTitulo = new JLabel("Alta Fenomeno");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setBounds(54, 23, 225, 29);
		panelTitulo.add(lblTitulo);
		
		JLabel label = new JLabel("Salir");
		label.setForeground(new Color(102, 51, 204));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(902, 70, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.main(null);
				frame.dispose();
			}
		});
		label_1.setIcon(new ImageIcon(ExpertoView.class.getResource("/com/cliente/images/Salir.png")));
		label_1.setBounds(972, 35, 73, 70);
		frame.getContentPane().add(label_1);
	}
}
