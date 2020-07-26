package com.cliente.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineCaracteristicaBean;
import com.entities.Caracteristica;
import com.exception.ServiciosException;

import java.awt.Color;
import java.awt.Component;

import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EliminarCaracteristica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBuscar;
	private Caracteristica eliminarCra;
	private JTextField textFieldTipoDeDato;
	private JTextField textFieldId;
	private JTextField textFieldEtiqueta;
	private JTextField textFieldNombre;
	private JTextField textFieldFenomenoNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarCaracteristica frame = new EliminarCaracteristica();
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
	public EliminarCaracteristica() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 481, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 479, 113);
		contentPane.add(panel);
		
		JLabel lblBuscarPorId = new JLabel("Buscar por Id Característica");
		lblBuscarPorId.setForeground(Color.WHITE);
		lblBuscarPorId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarPorId.setBounds(48, 24, 218, 25);
		panel.add(lblBuscarPorId);
		
		JLabel lbllAlert = new JLabel("");
		lbllAlert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbllAlert.setForeground(new Color(204, 0, 0));
		lbllAlert.setBounds(48, 91, 284, 14);
		panel.add(lbllAlert);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setColumns(10);
		textFieldBuscar.setBounds(45, 60, 185, 20);
		textFieldBuscar.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				 if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					 textFieldBuscar.setEditable(true);
					 lbllAlert.setText("");
		            } else {
		            	textFieldBuscar.setEditable(false);
		            	lbllAlert.setText("Ingresar únicamente dígitos numéricos");
		            	
		            }
				
			}
		});
		panel.add(textFieldBuscar);
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PipelineCaracteristicaBean cra = new PipelineCaracteristicaBean(); 
						if(textFieldBuscar.getText().length()!=0) {
						  int pkCRA = Integer.parseInt(textFieldBuscar.getText());
						  eliminarCra = cra.getQuery().findForMerge(pkCRA);
						  textFieldId.setText(String.valueOf(eliminarCra.getId_caracteristica()));
						  textFieldNombre.setText(eliminarCra.getNombre());
						  textFieldEtiqueta.setText(eliminarCra.getEtiqueta());
						  textFieldTipoDeDato.setText(eliminarCra.getTipoDato().toString());
						  textFieldFenomenoNombre.setText(eliminarCra.getFenomeno().getNombre());
						}else {
							JOptionPane.showMessageDialog(null, "Favor ingresar un valor en el campo de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);

						}
					 
				 	
				} catch (NamingException | ServiciosException | NullPointerException e1) {
					String em = "No se encontró ninguna característica con ese ID";
					Inspirate emFormat = new Inspirate(em);
					JLabel messageUserError = emFormat.getMessageJLabelFormat();
					messageUserError.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, messageUserError, "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				
			}
		});
		buttonBuscar.setForeground(Color.WHITE);
		buttonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonBuscar.setBackground(new Color(153, 0, 102));
		buttonBuscar.setBounds(276, 59, 121, 23);
		panel.add(buttonBuscar);
		
		JButton buttonEliminar = new JButton("Eliminar");
		buttonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PipelineCaracteristicaBean craDao = new PipelineCaracteristicaBean();
					craDao.getQuery().bajaCaracteristica(eliminarCra);
					Component[] componentes = contentPane.getComponents();
					for(Component c: componentes) {
						if(c instanceof JTextField) {
							((JTextField) c).setText("");
						}
					}
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonEliminar.setForeground(Color.WHITE);
		buttonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonEliminar.setBackground(new Color(102, 204, 153));
		buttonEliminar.setBounds(276, 20, 121, 23);
		panel.add(buttonEliminar);
		
		textFieldTipoDeDato = new JTextField();
		textFieldTipoDeDato.setEditable(false);
		textFieldTipoDeDato.setColumns(10);
		textFieldTipoDeDato.setBounds(27, 161, 185, 20);
		contentPane.add(textFieldTipoDeDato);
		
		JLabel labelTipoDeDato = new JLabel("Tipo de Dato");
		labelTipoDeDato.setBounds(27, 136, 136, 14);
		contentPane.add(labelTipoDeDato);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(27, 192, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setColumns(10);
		textFieldId.setBounds(27, 214, 185, 20);
		contentPane.add(textFieldId);
		
		JLabel labelEtiqueta = new JLabel("Etiqueta");
		labelEtiqueta.setBounds(246, 136, 67, 14);
		contentPane.add(labelEtiqueta);
		
		textFieldEtiqueta = new JTextField();
		textFieldEtiqueta.setEditable(false);
		textFieldEtiqueta.setColumns(10);
		textFieldEtiqueta.setBounds(246, 161, 185, 20);
		contentPane.add(textFieldEtiqueta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(246, 192, 121, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(246, 214, 185, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblFenomeno = new JLabel("Fen\u00F3meno");
		lblFenomeno.setBounds(27, 259, 121, 14);
		contentPane.add(lblFenomeno);
		
		textFieldFenomenoNombre = new JTextField();
		textFieldFenomenoNombre.setEditable(false);
		textFieldFenomenoNombre.setColumns(10);
		textFieldFenomenoNombre.setBounds(27, 284, 185, 20);
		contentPane.add(textFieldFenomenoNombre);
		
		
	}
}
