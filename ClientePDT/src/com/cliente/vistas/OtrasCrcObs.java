package com.cliente.vistas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.cliente.utils.Inspirate;
import com.cliente.utils.PipelineCaracteristicaBean;
import com.cliente.utils.PipelineDetalleBean;
import com.cliente.utils.PipelineFenomenoBean;
import com.cliente.utils.PipelineObservacionBean;
import com.entities.Caracteristica;
import com.entities.Detalle;
import com.entities.Fenomeno;

import com.exception.ServiciosException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import javax.naming.NamingException;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class OtrasCrcObs extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldValor;
	private JTextField textFieldFecha;
	private JTextField textFieldIdObservacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtrasCrcObs frame = new OtrasCrcObs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws NamingException 
	 * @throws ServiciosException 
	 */
	public OtrasCrcObs() throws NamingException, ServiciosException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 478);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelValor = new JLabel("Valor");
		labelValor.setForeground(new Color(102, 51, 204));
		labelValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelValor.setBounds(310, 210, 198, 31);
		contentPane.add(labelValor);
		
		JComboBox<String> comboBoxCrc = new JComboBox<String>();
		comboBoxCrc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCrc.setBackground(Color.WHITE);
		comboBoxCrc.setBounds(30, 341, 169, 34);
		contentPane.add(comboBoxCrc);
		
		JLabel label_2 = new JLabel("Caracter\u00EDstica");
		label_2.setForeground(new Color(102, 51, 204));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(30, 304, 183, 26);
		contentPane.add(label_2);
		
		textFieldValor = new JTextField();
		textFieldValor.setForeground(Color.DARK_GRAY);
		textFieldValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldValor.setColumns(10);
		textFieldValor.setBorder(null);
		textFieldValor.setBounds(310, 240, 169, 31);
		contentPane.add(textFieldValor);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(102, 51, 204));
		separator.setBounds(310, 282, 183, 2);
		contentPane.add(separator);
		
		JLabel label_3 = new JLabel("Fecha");
		label_3.setForeground(new Color(102, 51, 204));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(311, 307, 102, 31);
		contentPane.add(label_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(102, 51, 204));
		separator_1.setBounds(311, 373, 183, 2);
		contentPane.add(separator_1);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setText("Fri Jul 10 18:06:28 UYT 2020");
		textFieldFecha.setForeground(Color.DARK_GRAY);
		textFieldFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldFecha.setColumns(10);
		textFieldFecha.setBorder(null);
		textFieldFecha.setBounds(310, 336, 184, 31);
		contentPane.add(textFieldFecha);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(0, -5, 559, 83);
		contentPane.add(panel);
		
		JLabel lblCaractersticaobservacin = new JLabel("Caracter\u00EDstica-Observaci\u00F3n");
		lblCaractersticaobservacin.setForeground(Color.WHITE);
		lblCaractersticaobservacin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCaractersticaobservacin.setBounds(99, 24, 337, 29);
		panel.add(lblCaractersticaobservacin);
		
		JLabel label_1 = new JLabel("Fen\u00F3meno Categor\u00EDa");
		label_1.setForeground(new Color(102, 51, 204));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(30, 213, 183, 26);
		contentPane.add(label_1);
		
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
		comboBoxFenomeno.setBounds(30, 250, 169, 34);
		contentPane.add(comboBoxFenomeno);
		
		JButton btnAsociar = new JButton("Asociar");
		btnAsociar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PipelineCaracteristicaBean daoCrc = new PipelineCaracteristicaBean();
					Caracteristica crc = new Caracteristica();
					
					PipelineDetalleBean daoDetalle = new PipelineDetalleBean();
					Detalle dtl = new Detalle();
					
					PipelineObservacionBean tablaObs = new PipelineObservacionBean();
					
					
					//Verificamos que no queden campos vacios en el formulario.(mvi = mensajes vacios informar)
					Component[] componentes = contentPane.getComponents();
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
					
					//Dao Caracteristica
					List<Caracteristica> crcFiltro = daoCrc.getQuery().obtenerCrsPKPorFenomeno(comboBoxFenomeno.getSelectedItem().toString(), 
							comboBoxCrc.getSelectedItem().toString());
					crc = crcFiltro.get(0);
					
					int pkObs = Integer.parseInt(textFieldIdObservacion.getText());
					//Dao Detalle
					dtl.setCrtca(crc);
					dtl.setObs(tablaObs.getQuery().findForMerge(pkObs));
					if(crc.getTipoDato().toString().equals("NUMERO")) {
						int vNum = Integer.parseInt(textFieldValor.getText());
						dtl.setValor_numerico(vNum);
						dtl.setValor_texto("Sin Datos");
					} else {
						dtl.setValor_texto(textFieldValor.getText());
						dtl.setValor_numerico(0);
					}
					Calendar c = Calendar.getInstance();
					dtl.setFechaHora(c);
					daoDetalle.getQuery().altaDetalle(dtl);
					
					for(Component tf: componentes) {
						if(tf instanceof JTextField) {
							((JTextField) tf).setText("");
						}
					};
					
					
				} catch (NamingException | ServiciosException e1) {
					String em = "Esta violando una clave unica, o el fenómeno seleccionado no se corresponde con la observación";
					Inspirate emFormat = new Inspirate(em);
					JLabel messageUserError = emFormat.getMessageJLabelFormat();
					messageUserError.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, messageUserError, "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				
				}
				
			}
		});
		btnAsociar.setForeground(Color.WHITE);
		btnAsociar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAsociar.setBackground(new Color(204, 51, 102));
		btnAsociar.setBounds(292, 103, 241, 39);
		contentPane.add(btnAsociar);
		
		JLabel lblIdObservaci = new JLabel("ID Observaci\u00F3n");
		lblIdObservaci.setForeground(new Color(102, 51, 204));
		lblIdObservaci.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdObservaci.setBounds(30, 106, 183, 31);
		contentPane.add(lblIdObservaci);
		
		textFieldIdObservacion = new JTextField();
		textFieldIdObservacion.setForeground(Color.DARK_GRAY);
		textFieldIdObservacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldIdObservacion.setColumns(10);
		textFieldIdObservacion.setBorder(null);
		textFieldIdObservacion.setBounds(30, 141, 169, 31);
		contentPane.add(textFieldIdObservacion);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(102, 51, 204));
		separator_2.setBounds(30, 183, 183, 2);
		contentPane.add(separator_2);
		PipelineFenomenoBean tablaFenomeno = new PipelineFenomenoBean();
		List<Fenomeno> fenomenos = tablaFenomeno.getQuery().obtenerTodos();
		for(Fenomeno f : fenomenos) {
			comboBoxFenomeno.addItem(f.getNombre().toString());
		};
		
		
		comboBoxCrc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PipelineCaracteristicaBean crcDao = new PipelineCaracteristicaBean();
					List<Caracteristica> crcTipoDeDato = crcDao.getQuery().obtenerCrsPKPorFenomeno(comboBoxFenomeno.getSelectedItem().toString(), 
							comboBoxCrc.getSelectedItem().toString());
					labelValor.setText("Valor: " + crcTipoDeDato.get(0).getTipoDato().toString());
				} catch (ServiciosException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
