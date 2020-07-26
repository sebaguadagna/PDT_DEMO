package com.cliente.vistas;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cliente.utils.PipelineCaracteristicaBean;
import com.cliente.utils.PipelineFenomenoBean;
import com.entities.Caracteristica;
import com.entities.Fenomeno;
import com.enumerados.TipoDato;
import com.exception.ServiciosException;

import javax.naming.NamingException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCaracteristica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEtiqueta;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCaracteristica frame = new AgregarCaracteristica();
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
	public AgregarCaracteristica() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 583);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBoxFenomeno = new JComboBox<String>();
		comboBoxFenomeno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					System.out.print("Tratando de recuperar fenómeno");
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
		comboBoxFenomeno.setBounds(23, 147, 169, 34);
		contentPane.add(comboBoxFenomeno);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(10, 11, 370, 76);
		contentPane.add(panel);
		
		JLabel lblSeleccionarFenomeno = new JLabel("Seleccionar Fenómeno");
		lblSeleccionarFenomeno.setForeground(Color.WHITE);
		lblSeleccionarFenomeno.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSeleccionarFenomeno.setBounds(56, 22, 284, 29);
		panel.add(lblSeleccionarFenomeno);
		
		JLabel lblCategoriafenomeno = new JLabel("Categoría-Fenómeno");
		lblCategoriafenomeno.setForeground(new Color(102, 51, 204));
		lblCategoriafenomeno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoriafenomeno.setBounds(23, 98, 169, 31);
		contentPane.add(lblCategoriafenomeno);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 153, 255));
		panel_1.setBounds(10, 223, 370, 76);
		contentPane.add(panel_1);
		
		JLabel lblAsociarCaracteristica = new JLabel("Asociar Características");
		lblAsociarCaracteristica.setForeground(Color.WHITE);
		lblAsociarCaracteristica.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAsociarCaracteristica.setBounds(56, 22, 284, 29);
		panel_1.add(lblAsociarCaracteristica);
		
		
		JComboBox<TipoDato> comboBoxValor = new JComboBox<TipoDato>();
		comboBoxValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxValor.setBackground(Color.WHITE);
		comboBoxValor.setBounds(23, 357, 169, 34);
		for(TipoDato td: TipoDato.values()) {
			comboBoxValor.addItem(td);
		}
		contentPane.add(comboBoxValor);
		
		JLabel lblTipoDeDato = new JLabel("Tipo de Dato");
		lblTipoDeDato.setForeground(new Color(102, 51, 204));
		lblTipoDeDato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeDato.setBounds(23, 315, 169, 31);
		contentPane.add(lblTipoDeDato);
		
		textFieldEtiqueta = new JTextField();
		textFieldEtiqueta.setForeground(Color.DARK_GRAY);
		textFieldEtiqueta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEtiqueta.setColumns(10);
		textFieldEtiqueta.setBorder(null);
		textFieldEtiqueta.setBounds(23, 465, 169, 31);
		contentPane.add(textFieldEtiqueta);
		
		JLabel lblEtiqueta = new JLabel("Etiqueta");
		lblEtiqueta.setForeground(new Color(102, 51, 204));
		lblEtiqueta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEtiqueta.setBounds(23, 427, 128, 31);
		contentPane.add(lblEtiqueta);
		
		JSeparator separatorEtiqueta = new JSeparator();
		separatorEtiqueta.setBackground(new Color(102, 51, 204));
		separatorEtiqueta.setBounds(23, 507, 183, 2);
		contentPane.add(separatorEtiqueta);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 0, 102));
		panel_2.setBounds(460, 0, 292, 551);
		contentPane.add(panel_2);
		
		JButton btnSalvarAsociasion = new JButton("Salvar Asociación");
		btnSalvarAsociasion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					PipelineCaracteristicaBean pcra = new PipelineCaracteristicaBean();
					PipelineFenomenoBean feno = new PipelineFenomenoBean();
					
					List<Fenomeno> fenNombre = feno.getQuery().obtenerPorNombre(comboBoxFenomeno.getSelectedItem().toString());
					int pk_fem = fenNombre.get(0).getId_fenomeno();
					Fenomeno f = feno.getQuery().findForMerge(pk_fem);
					Caracteristica cra = new Caracteristica();
					cra.setEtiqueta(textFieldEtiqueta.getText().toUpperCase());
					cra.setNombre(textFieldNombre.getText().toUpperCase());
					TipoDato tp = (TipoDato) comboBoxValor.getSelectedItem();
					cra.setTipoDato(tp);
					cra.setFenomeno(f);
					pcra.getQuery().altaCaracteristica(cra);
					
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
		btnSalvarAsociasion.setForeground(Color.WHITE);
		btnSalvarAsociasion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalvarAsociasion.setBackground(new Color(255, 51, 102));
		btnSalvarAsociasion.setBounds(21, 96, 241, 39);
		panel_2.add(btnSalvarAsociasion);
		
		JLabel lblCaracteristicafenomeno = new JLabel("Características-Fenómeno");
		lblCaracteristicafenomeno.setForeground(Color.WHITE);
		lblCaracteristicafenomeno.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCaracteristicafenomeno.setBounds(21, 38, 247, 47);
		panel_2.add(lblCaracteristicafenomeno);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AgregarCaracteristica.class.getResource("/com/cliente/images/molino.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(11, 267, 251, 284);
		panel_2.add(lblNewLabel);
		
		JButton btnListarCaracteristicas = new JButton("Listar Características");
		btnListarCaracteristicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCaracteristicas.main(null);
			}
		});
		btnListarCaracteristicas.setForeground(Color.WHITE);
		btnListarCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListarCaracteristicas.setBackground(new Color(102, 153, 255));
		btnListarCaracteristicas.setBounds(21, 157, 241, 39);
		panel_2.add(btnListarCaracteristicas);
		
		JButton btnEliminarCaracteristicas = new JButton("Eliminar Características");
		btnEliminarCaracteristicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarCaracteristica.main(null);
			}
		});
		btnEliminarCaracteristicas.setForeground(Color.WHITE);
		btnEliminarCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminarCaracteristicas.setBackground(new Color(204, 0, 0));
		btnEliminarCaracteristicas.setBounds(21, 219, 241, 39);
		panel_2.add(btnEliminarCaracteristicas);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(102, 51, 204));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(235, 427, 128, 31);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setForeground(Color.DARK_GRAY);
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBorder(null);
		textFieldNombre.setBounds(235, 465, 169, 31);
		contentPane.add(textFieldNombre);
		
		JSeparator separatorNombre = new JSeparator();
		separatorNombre.setBackground(new Color(102, 51, 204));
		separatorNombre.setBounds(236, 507, 183, 2);
		contentPane.add(separatorNombre);
		
	}
}
