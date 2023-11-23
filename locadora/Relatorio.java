package locadora;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bd.AluguelDAO;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;


public class Relatorio {

	protected JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public Relatorio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Relatorio de Aluguel");
		frame.setResizable(false);
		frame.setBounds(100, 100, 929, 574);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 128, 0)));
		scrollPane.setBounds(0, 10, 915, 307);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		table.setModel(new DefaultTableModel(
			AluguelDAO.tabelaAluguel(),
			new Object[] {
				"Placa", "CPF", "Nome", "Idade", "Retirada", "Devolução", "Opcionais", "Valor Pago"
			}
		) {
			
			private static final long serialVersionUID = -8148025271635139713L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
		});
		
		JLabel valorTotal = new JLabel("Valor total R$: " + AluguelDAO.valorTotal());
		valorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		valorTotal.setBounds(10, 339, 223, 13);
		frame.getContentPane().add(valorTotal);
		table.getColumnModel().getColumn(0).setMinWidth(20);

       
		
	}
}
