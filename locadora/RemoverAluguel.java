package locadora;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bd.AluguelDAO;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;

public class RemoverAluguel extends Aluguel{

	JFrame frame;
	JFrame framePai;
	private JTextField textPlaca;
	


	/**
	 * Create the application.
	 */
	/**
	 * @wbp.parser.constructor
	 */
	public RemoverAluguel() {
		this(null);
		initialize();
	}
	public RemoverAluguel(JFrame framePai) {
		this.framePai = framePai;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Remoção do Sistema");
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 424, 268);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remoção do Sistema de Aluguel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(48, 39, 291, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPlaca = new JLabel("Placa: ");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlaca.setBounds(93, 95, 40, 13);
		frame.getContentPane().add(lblPlaca);
		
		textPlaca = new JTextField();
		textPlaca.setColumns(10);
		textPlaca.setBounds(137, 93, 131, 19);
		frame.getContentPane().add(textPlaca);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRemover.setBounds(147, 137, 110, 35);
		frame.getContentPane().add(btnRemover);
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AluguelDAO aluguel = new AluguelDAO();
				if(aluguel.remover(textPlaca.getText())) {
					JOptionPane.showMessageDialog(frame,"Remoção feita com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					framePai.dispose();
					Aluguel janelaAluguel  = new Aluguel();
					janelaAluguel.frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frame,"Erro na remoção!\nTente novamente.", "Erro", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					RemoverAluguel janelaRemover = new RemoverAluguel();
					janelaRemover.frame.setVisible(true);
				}
			}
		});
	}

}
