package locadora;



import bd.MotosDAO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Motos {

	protected JFrame frame;
	private JTextField textMarca;
	private JTextField textDimensoes;
	private JTextField textMotor;
	private JTextField textTanque;
	private JTextField textConsumo;
	private JTextField textCusto;
	private JTextField textPlaca;
	private JTextField textRemove;
	
	/**
	 * Create the application.
	 */
	public Motos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("Cadastro de motos");
		frame.setResizable(false);
		frame.setBounds(100, 100, 814, 663);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setToolTipText("Podem ser classificados em três categorias: Econômico, Standard e Premium");
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setBounds(26, 25, 112, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox<Object> comboCategoria = new JComboBox<>();
		comboCategoria.setModel(new DefaultComboBoxModel<Object>(new String[] {"Economico", "Standard", "Premium"}));
		comboCategoria.setBounds(26, 49, 193, 27);
		frame.getContentPane().add(comboCategoria);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setToolTipText("Marca/Modelo/Ano");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(26, 148, 112, 27);
		frame.getContentPane().add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setText("");
		textMarca.setBounds(26, 173, 270, 27);
		frame.getContentPane().add(textMarca);
		textMarca.setColumns(10);
		
		
		
		JLabel lblDimenses = new JLabel("Dimensões:");
		lblDimenses.setToolTipText("Tamanho");
		lblDimenses.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDimenses.setBounds(26, 199, 112, 27);
		frame.getContentPane().add(lblDimenses);
		
		textDimensoes = new JTextField();
		textDimensoes.setText("");
		textDimensoes.setColumns(10);
		textDimensoes.setBounds(26, 225, 270, 27);
		frame.getContentPane().add(textDimensoes);
		
		JLabel lblTipoDoMotor = new JLabel("Tipo do motor:");
		lblTipoDoMotor.setToolTipText("");
		lblTipoDoMotor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDoMotor.setBounds(26, 259, 112, 27);
		frame.getContentPane().add(lblTipoDoMotor);
		
		textMotor = new JTextField();
		textMotor.setText("");
		textMotor.setColumns(10);
		textMotor.setBounds(26, 284, 270, 27);
		frame.getContentPane().add(textMotor);
		
		JLabel lblCapacidadeDoTanque = new JLabel("Capacidade do Tanque:");
		lblCapacidadeDoTanque.setToolTipText("");
		lblCapacidadeDoTanque.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidadeDoTanque.setBounds(26, 312, 178, 27);
		frame.getContentPane().add(lblCapacidadeDoTanque);
		
		textTanque = new JTextField();
		textTanque.setText("");
		textTanque.setColumns(10);
		textTanque.setBounds(26, 340, 270, 27);
		frame.getContentPane().add(textTanque);
		
		JLabel lblMdiaDeConsumo = new JLabel("Média de consumo:");
		lblMdiaDeConsumo.setToolTipText("km/l");
		lblMdiaDeConsumo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMdiaDeConsumo.setBounds(26, 372, 178, 27);
		frame.getContentPane().add(lblMdiaDeConsumo);
		
		textConsumo = new JTextField();
		textConsumo.setText("");
		textConsumo.setColumns(10);
		textConsumo.setBounds(26, 399, 270, 27);
		frame.getContentPane().add(textConsumo);
		
		JLabel lblMdiaDeConsumo_1 = new JLabel("Acessórios:");
		lblMdiaDeConsumo_1.setToolTipText("km/l");
		lblMdiaDeConsumo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMdiaDeConsumo_1.setBounds(26, 428, 178, 27);
		frame.getContentPane().add(lblMdiaDeConsumo_1);
		
		JComboBox<Object> comboAcessorio = new JComboBox<Object>();
		comboAcessorio.setModel(new DefaultComboBoxModel<Object>(new String[] {"Porta de energia DC", "Radio/CD Player", "Wind Shield"}));
		comboAcessorio.setBounds(26, 457, 193, 27);
		frame.getContentPane().add(comboAcessorio);
		
		JLabel lblMdiaDeConsumo_1_1 = new JLabel("Custo:");
		lblMdiaDeConsumo_1_1.setToolTipText("Valor por dia R$");
		lblMdiaDeConsumo_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMdiaDeConsumo_1_1.setBounds(26, 483, 178, 27);
		frame.getContentPane().add(lblMdiaDeConsumo_1_1);
		
		textCusto = new JTextField();
		textCusto.setToolTipText("por dia");
		textCusto.setText("");
		textCusto.setColumns(10);
		textCusto.setBounds(26, 507, 270, 27);
		frame.getContentPane().add(textCusto);
		
		JButton btnSubmeter = new JButton("Cadastrar");
		btnSubmeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotosDAO motos = new MotosDAO();
				
				if( !motos.verificaMoto(textPlaca.getText()) ) {
					if(motos.adicionarMotos( textPlaca.getText(), textMarca.getText(), comboCategoria.getSelectedItem().toString(),
											 textDimensoes.getText(), comboAcessorio.getSelectedItem().toString(), Integer.parseInt(textCusto.getText()), 
											 textMotor.getText(),Integer.parseInt(textTanque.getText()), Integer.parseInt(textConsumo.getText()))) {
						JOptionPane.showMessageDialog(frame,"Cadastro da moto feita!", null, JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Motos janelaMotos = new Motos();
						janelaMotos.frame.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Placa ja cadastrada!", null, JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		btnSubmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmeter.setBounds(66, 555, 178, 39);
		frame.getContentPane().add(btnSubmeter);
		
		textPlaca = new JTextField();
		textPlaca.setText("");
		textPlaca.setColumns(10);
		textPlaca.setBounds(26, 117, 270, 27);
		frame.getContentPane().add(textPlaca);
		
		JLabel lblPlacaRemove = new JLabel("Placa:");
		lblPlacaRemove.setToolTipText("Marca/Modelo/Ano");
		lblPlacaRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlacaRemove.setBounds(397, 483, 40, 27);
		frame.getContentPane().add(lblPlacaRemove);
		
		textRemove = new JTextField();
		textRemove.setBackground(new Color(255, 255, 255));
		textRemove.setText("");
		textRemove.setColumns(10);
		textRemove.setBounds(397, 507, 270, 27);
		frame.getContentPane().add(textRemove);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(255, 60, 65));
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRemover.setBounds(406, 555, 121, 39);
		frame.getContentPane().add(btnRemover);
		
		MotosDAO moto = new MotosDAO();
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!moto.verificaAluguelMoto(textRemove.getText())) {
					if(moto.remover(textRemove.getText())) {
						JOptionPane.showMessageDialog(frame,"Moto removida com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
						 frame.dispose();
						 Motos janelaMoto = new Motos();
						 janelaMoto.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Moto não cadastrada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Moto está alugada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 29, 372, 444);
		frame.getContentPane().add(scrollPane);
		
		
		JTextArea textArea = new JTextArea(moto.listaMotos());
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Motos Cadastradas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		JLabel lblPlacaRemove_1 = new JLabel("Placa:");
		lblPlacaRemove_1.setToolTipText("Marca/Modelo/Ano");
		lblPlacaRemove_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlacaRemove_1.setBounds(26, 86, 40, 27);
		frame.getContentPane().add(lblPlacaRemove_1);
		
		JButton btnEditarValor = new JButton("Editar Valor");
		btnEditarValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditarValor.setBounds(537, 555, 121, 39);
		frame.getContentPane().add(btnEditarValor);
		
		btnEditarValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!moto.verificaAluguelMoto(textRemove.getText())) {
					if(moto.verificaMoto(textRemove.getText())){
						String valor = JOptionPane.showInputDialog("Digite o novo valor: ");
						if(valor != null) {
							moto.updateValor(textRemove.getText(), valor);
							frame.dispose();
							Motos janelaMoto = new Motos();
							janelaMoto.frame.setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null,"Moto não cadastrada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Moto está alugada!", "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
	}
}
