package locadora;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import bd.AluguelDAO;
import bd.MotosDAO;
import bd.ClientesDAO;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
 
public class Aluguel {

	protected JFrame frame;

	/**
	 * Create the application.
	 */
	public Aluguel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Sistema de Aluguel");
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.setResizable(false);
		frame.setBounds(100, 100, 929, 574);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		AluguelDAO aluga = new AluguelDAO();
		textArea.setText(aluga.motosDisponivel());
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(0, 106, 392, 199);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Motos Disponveis:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(new Color(0, 255, 0));
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 915, 105);
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de Aluguel");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panel.add(lblNewLabel_1, "name_427437925385500");
		
		JTextArea textAreaAlugadas = new JTextArea();
		textAreaAlugadas.setText(aluga.motosAlugadas());
		textAreaAlugadas.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane(textAreaAlugadas);
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane_1.setBounds(0, 315, 392, 199);
		frame.getContentPane().add(scrollPane_1);
		
		JLabel lblMotosAlugadas = new JLabel("Motos Alugadas:");
		lblMotosAlugadas.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setColumnHeaderView(lblMotosAlugadas);
		
		
		
		JLabel placaText = new JLabel("Placa:");
		placaText.setFont(new Font("Tahoma", Font.BOLD, 13));
		placaText.setBounds(406, 123, 45, 13);
		frame.getContentPane().add(placaText);
		
		JEditorPane placa = new JEditorPane();
		placa.setToolTipText("placa da moto");
		placa.setBounds(454, 117, 340, 19);
		frame.getContentPane().add(placa);
		
		JLabel cpfText = new JLabel("CPF:");
		cpfText.setFont(new Font("Tahoma", Font.BOLD, 13));
		cpfText.setBounds(406, 163, 30, 13);
		frame.getContentPane().add(cpfText);
		
		JEditorPane cpf = new JEditorPane();
		cpf.setToolTipText("CPF");
		cpf.setBounds(454, 157, 340, 19);
		frame.getContentPane().add(cpf);
		
		JEditorPane retirada = new JEditorPane();
		retirada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		retirada.setToolTipText("dd/mm/aaaa");
		retirada.setBounds(529, 195, 181, 19);
		frame.getContentPane().add(retirada);
		
		JLabel lblData = new JLabel("Data de Retirada:");
		lblData.setToolTipText("dd/mm/aaaa");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(402, 201, 117, 13);
		frame.getContentPane().add(lblData);
		
		JLabel lblDataDeDevoluo = new JLabel("Data de Devolução:");
		lblDataDeDevoluo.setToolTipText("dd/mm/aaaa");
		lblDataDeDevoluo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeDevoluo.setBounds(402, 241, 127, 13);
		frame.getContentPane().add(lblDataDeDevoluo);
		
		JEditorPane devoluçao = new JEditorPane();
		devoluçao.setToolTipText("dd/mm/aaaa");
		devoluçao.setBounds(529, 235, 181, 19);
		frame.getContentPane().add(devoluçao);
		
		JLabel lblOpcionais = new JLabel("Opcionais:");
		lblOpcionais.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOpcionais.setBounds(402, 279, 72, 13);
		frame.getContentPane().add(lblOpcionais);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Sem Acessório", "Combustível pré-pago", "Aluguel da Jaqueta", "Seguro"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(402, 302, 141, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnAlugar = new JButton("Alugar");
		btnAlugar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAlugar.setBounds(454, 469, 154, 45);
		frame.getContentPane().add(btnAlugar);
		
		JButton btnRemove = new JButton("Retirar Aluguel");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemove.setBounds(641, 469, 153, 45);
		frame.getContentPane().add(btnRemove);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverAluguel janelaRemove = new RemoverAluguel(frame);
				janelaRemove.frame.setVisible(true);
				
			}
		});
		
		
		btnAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesDAO cliente = new ClientesDAO();
				AluguelDAO aluga = new AluguelDAO();
				MotosDAO moto = new MotosDAO();

				if(AluguelDAO.isDataValida(devoluçao.getText())) {
					if(AluguelDAO.isDataValida(retirada.getText())) {
						if( cliente.verificaCpf(cpf.getText())) {
							if(moto.verificaMoto(placa.getText())) {
								if( !aluga.verificaAluguel(placa.getText())) {
									if(Integer.parseInt(cliente.getIdade( cpf.getText())) >=18) {
										int valor = aluga.valorMoto(placa.getText(), comboBox.getSelectedItem().toString(),retirada.getText(),devoluçao.getText());
										if(aluga.adicionarAluguel( placa.getText(), cpf.getText(), cliente.getNome( cpf.getText()), 
																   Integer.parseInt(cliente.getIdade( cpf.getText())), retirada.getText(),
																   devoluçao.getText(),comboBox.getSelectedItem().toString(), valor)) {
											frame.dispose();
											Aluguel janelaAluguel  = new Aluguel();
											janelaAluguel.frame.setVisible(true);
										}
									}else {
										JOptionPane.showMessageDialog(null,"Menor de Idade!", "Erro", JOptionPane.INFORMATION_MESSAGE);
									}
								}else {
									JOptionPane.showMessageDialog(null,"Moto ja está alugada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null,"Moto não cadastrada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null,"CPF não cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
		
						}
					}else {
						JOptionPane.showMessageDialog(null,"Data de retirada no formato errado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Data de devolução no formato errado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		
		
			
		
		
	}
}
