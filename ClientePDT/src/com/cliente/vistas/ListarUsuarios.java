package com.cliente.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.cliente.utils.PipelineUsuarioBean;
import com.entities.Usuario;
import com.exception.ServiciosException;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class ListarUsuarios {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuarios window = new ListarUsuarios();
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
	public ListarUsuarios() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1180, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String columnas [] = {"ID_USUARIO", "ROL",
				"ESTADO", "USERNAME", "NOMBRE", "APELLIDO", "DIRECCIÓN", "DOC", "DOCUMENTO", "EMAIL", 
		"PASSWORD"};

		JScrollPane scrollPane = new JScrollPane();

		JButton btnListarUsuarios = new JButton("Listar Usuarios");
		btnListarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					PipelineUsuarioBean userTable = new PipelineUsuarioBean();
					DefaultTableModel model = new DefaultTableModel(null, columnas);
					for (Usuario u : userTable.getQuery().obtenerTodosLosUsuarios()) {
						model.addRow(new Object[]{u.getId_usuario(), u.getRol().getRol().toString(),
								u.getEstado().getEstado_valor().toString(), u.getUsername(), u.getNombre(), u.getApellido(), 
								u.getDireccion(), u.getDoc().getCategoria_nombre().toString(), u.getDocumento(), u.getEmail(),
								u.getPasswd()});
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(29)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1128, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(533, Short.MAX_VALUE)
						.addComponent(btnListarUsuarios)
						.addGap(511))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(14)
						.addComponent(btnListarUsuarios)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE))
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
