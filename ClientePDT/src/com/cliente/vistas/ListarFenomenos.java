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
import com.cliente.utils.PipelineFenomenoBean;
import com.entities.Fenomeno;
import com.exception.ServiciosException;

public class ListarFenomenos {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFenomenos window = new ListarFenomenos();
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
	public ListarFenomenos() {
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
		
		String columnas [] = {"ID", "CÓDIGO",
				"NOMBRE", "DESCRIPCIÓN", "TELÉFONO"};

		JScrollPane scrollPane = new JScrollPane();

		JButton btnListarUsuarios = new JButton("Listar Fenómenos");
		
		btnListarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					PipelineFenomenoBean femDao = new PipelineFenomenoBean();
					DefaultTableModel model = new DefaultTableModel(null, columnas);
					
					for (Fenomeno fm : femDao.getQuery().obtenerTodos()) {
						model.addRow(new Object[]{fm.getId_fenomeno(),fm.getCodigo(),fm.getNombre(),fm.getDescripcion(),fm.getTelefono()});
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnListarUsuarios)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(btnListarUsuarios)
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