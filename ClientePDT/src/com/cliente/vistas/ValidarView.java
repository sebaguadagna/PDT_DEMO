package com.cliente.vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineObservacionBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.Observacion;
import com.exception.ServiciosException;

import javax.naming.NamingException;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ValidarView {

	private JFrame frame;
	private JTextField textFieldFenomeno;
	private JTextField textFieldDescripcion;
	private String emailExpertoLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String emailLogin = args[0];
					ValidarView window = new ValidarView(emailLogin);
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
	public ValidarView(String email) {
		initialize();
		this.emailExpertoLogin = email;
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
		
		JLabel lblFenomeno = new JLabel("Fen�meno");
		lblFenomeno.setBounds(35, 105, 67, 14);
		frame.getContentPane().add(lblFenomeno);
		
		textFieldFenomeno = new JTextField();
		textFieldFenomeno.setEditable(false);
		textFieldFenomeno.setColumns(10);
		textFieldFenomeno.setBounds(35, 130, 184, 20);
		frame.getContentPane().add(textFieldFenomeno);
		
		JLabel lblID = new JLabel("ID Observaci�n");
		lblID.setBounds(35, 31, 121, 14);
		frame.getContentPane().add(lblID);
		
		JTextField  textFieldID = new JTextField();
		textFieldID.setBounds(34, 56, 185, 20);
		frame.getContentPane().add(textFieldID);
		
		JButton button = new JButton("Buscar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					PipelineObservacionBean tablaObservacion = new PipelineObservacionBean();
					List<Observacion> obs = tablaObservacion.getQuery().obtenerPorPK(Integer.parseInt(textFieldID.getText()));
					textFieldDescripcion.setText(obs.get(0).getDescripcion());
					textFieldFenomeno.setText(obs.get(0).getCategoria().getNombre());
					
				} catch (NamingException | ServiciosException e1) {

					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(313, 55, 121, 23);
		frame.getContentPane().add(button);
		
		JLabel lblDescripcion = new JLabel("Descripci�n");
		lblDescripcion.setBounds(289, 105, 105, 14);
		frame.getContentPane().add(lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(286, 130, 184, 20);
		frame.getContentPane().add(textFieldDescripcion);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				
					
					//Modificamos El resgistro
					PipelineUsuarioBean usrDao = new PipelineUsuarioBean();
					PipelineObservacionBean tablaObservacion = new PipelineObservacionBean();
					Observacion o = new Observacion();
					int valor =  Integer.parseInt(textFieldID.getText());
					o = tablaObservacion.getQuery().findForMerge(valor);
					o.setValidarExperto(true);
					o.setUsr_experto(usrDao.getQuery().findForMerge(usrDao.getQuery().obtenerPorEmail(emailExpertoLogin).get(0).getId_usuario()));
					tablaObservacion.getQuery().modificarObservacion(o);
					

					//Dejamos un mensaje y limpiamos todos los fields
					Component[] componentes = frame.getContentPane().getComponents();
					String uok = "Operaci�n exitosa, la observaci�n fue validada!";
					Inspirate uokFormat = new Inspirate(uok);
					JLabel messageOk =  uokFormat.getMessageJLabelFormat();
					JOptionPane.showMessageDialog(null, messageOk,"Atenci�n", JOptionPane.INFORMATION_MESSAGE);
					for(Component tf: componentes) {
						if(tf instanceof JTextField) {
							((JTextField) tf).setText("");
						}
					}
					
				} catch (NamingException | ServiciosException  e1) {

					String em = e1.getMessage();
					Inspirate emFormat = new Inspirate(em);
					JLabel messageUserError = emFormat.getMessageJLabelFormat();
					messageUserError.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, messageUserError, "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		btnValidar.setBounds(179, 182, 121, 23);
		frame.getContentPane().add(btnValidar);
	}
}
