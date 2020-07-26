package com.cliente.vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.cliente.utils.PipelineObservacionBean;
import com.entities.Observacion;
import com.enumerados.CZonas;
import com.exception.ServiciosException;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ObservacionesZonasView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObservacionesZonasView window = new ObservacionesZonasView();
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
	public ObservacionesZonasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1205, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String columnas [] = {"ID", "DESCRIPCIÓN",
				"FECHAHORA", "CATEGORÍA", "LOCALIDAD", "DEPARTAMENTO", "USUARIO", "VALIDADO"};

		JScrollPane scrollPane = new JScrollPane();

		JButton btnListarUsuarios = new JButton("Listar Observaciones");
		JComboBox<CZonas> comboBox = new JComboBox<CZonas>();
		for(CZonas c: CZonas.values()) {
			comboBox.addItem(c);
		}
		btnListarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
		
					DefaultTableModel model = new DefaultTableModel(null, columnas);
					
					PipelineObservacionBean obsTabla = new PipelineObservacionBean();
					
					for (Observacion o : obsTabla.getQuery().obtenerPorZona((CZonas) comboBox.getSelectedItem())) {
						model.addRow(new Object[]{o.getId_observacion(), o.getDescripcion(), o.getFechaHora().getTime().toString(), o.getCategoria().getNombre(),
								 o.getLocalidad().getNombre(), o.getLocalidad().getDepartamento().getNombre(), o.getUsr_voluntario().getEmail(), o.isValidarExperto()});
					}
					
					table.setModel(model);
					
					//Centramos el texto de las celdas
					DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
					tcr.setHorizontalAlignment(SwingConstants.CENTER);
					for(int i=0; i<table.getColumnCount();i++) {
						table.getColumnModel().getColumn(i).setCellRenderer(tcr);

					}
					
				} catch (NamingException | ServiciosException e) {
					e.printStackTrace();
				}
			}
		});
		
	
		
		JLabel lblSeleccionarZona = new JLabel("Seleccionar Zona");
		lblSeleccionarZona.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnListarUsuarios)
							.addGap(62)
							.addComponent(lblSeleccionarZona, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListarUsuarios)
						.addComponent(lblSeleccionarZona)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean t = table.isEditing();
				if(!t){
					JOptionPane.showMessageDialog(null, "Esta tabla no es editable");
				}
				
			}
		});
		table.setFont(new Font("Dialog", Font.PLAIN, 13));
		table.setForeground(Color.RED);
		table.setRowSelectionAllowed(false);
		
		//Se deshabilita la edicion de celdas en la tabla
		table.setDefaultEditor(Object.class, null); 
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				columnas));

		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
