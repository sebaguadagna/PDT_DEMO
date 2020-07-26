package com.cliente.vistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.cliente.utils.PipelineFenomenoBean;
import com.entities.Fenomeno;
import com.exception.ServiciosException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class EliminarFenomeno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIdFenomeno;
	private JTextField textFieldCodigo;
	private JTextField textFieldDescripcion;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private Fenomeno fenomenoEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarFenomeno frame = new EliminarFenomeno();
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
	public EliminarFenomeno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 479, 113);
		contentPane.add(panel);
		
		JLabel lblBuscarPorId = new JLabel("Buscar por Id Fen\u00F3meno");
		lblBuscarPorId.setForeground(Color.WHITE);
		lblBuscarPorId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarPorId.setBounds(48, 24, 182, 29);
		panel.add(lblBuscarPorId);
		
		JLabel lbllAlert = new JLabel("");
		lbllAlert.setForeground(new Color(204, 0, 0));
		lbllAlert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbllAlert.setBounds(48, 91, 284, 14);
		panel.add(lbllAlert);
		
		
		textFieldIdFenomeno = new JTextField();
		textFieldIdFenomeno.setColumns(10);
		textFieldIdFenomeno.setBounds(45, 60, 185, 20);
		textFieldIdFenomeno.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				 if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					 textFieldIdFenomeno.setEditable(true);
					 lbllAlert.setText("");
		            } else {
		            	textFieldIdFenomeno.setEditable(false);
		            	lbllAlert.setText("Ingresar únicamente dígitos numéricos");
		            	
		            }
				
			}
		});
		panel.add(textFieldIdFenomeno);
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					PipelineFenomenoBean fenomenoDao = new PipelineFenomenoBean();
					if(textFieldIdFenomeno.getText().length()!=0) {
						
						int pkFEM = Integer.parseInt(textFieldIdFenomeno.getText());
						fenomenoEliminar = fenomenoDao.getQuery().findForMerge(pkFEM);
						textFieldCodigo.setText(fenomenoEliminar.getCodigo());
						textFieldNombre.setText(fenomenoEliminar.getNombre());
						textFieldDescripcion.setText(fenomenoEliminar.getDescripcion());
						textFieldTelefono.setText(fenomenoEliminar.getTelefono());
						
					}else {
						JOptionPane.showMessageDialog(null, "Favor ingresar un valor en el campo de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} catch (NamingException | ServiciosException e1) {
					
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
					PipelineFenomenoBean femDaoEliminar = new PipelineFenomenoBean();
					femDaoEliminar.getQuery().bajaFenomeno(fenomenoEliminar.getId_fenomeno());
				} catch (NamingException | ServiciosException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		buttonEliminar.setForeground(Color.WHITE);
		buttonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonEliminar.setBackground(new Color(102, 204, 153));
		buttonEliminar.setBounds(276, 20, 121, 23);
		panel.add(buttonEliminar);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.setBounds(37, 162, 185, 20);
		contentPane.add(textFieldCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(37, 137, 136, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setBounds(37, 193, 136, 14);
		contentPane.add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(37, 215, 185, 20);
		contentPane.add(textFieldDescripcion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(256, 137, 67, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(256, 162, 185, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono de Emergencia");
		lblTelefono.setBounds(256, 193, 165, 14);
		contentPane.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(256, 215, 185, 20);
		contentPane.add(textFieldTelefono);
	}
}
