package locadora;


import bd.ClientesDAO;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Clientes {

	protected JFrame frame;
	private JTextField txtNome;
	private JTextField textCPF;
	private JTextField textIdade;
	private JTextField textRemover;

	/**
	 * Create the application.
	 */
	public Clientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Cadastro de Clientes");
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setResizable(false);
		frame.setBounds(100, 100, 827, 498);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastro.setBounds(137, 378, 174, 35);
		frame.getContentPane().add(btnCadastro);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("nome completo");
		txtNome.setBounds(111, 173, 252, 28);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().add(txtNome);
		
		JLabel Nome = new JLabel("Nome: ");
		Nome.setBounds(58, 169, 58, 33);
		Nome.setFont(new Font("Tahoma", Font.BOLD, 14));
		Nome.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Nome);
		
		JLabel lblNewLabel = new JLabel("Área do Cliente");
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setBounds(0, 0, 803, 104);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(445, 326, 58, 33);
		frame.getContentPane().add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("digite o CPF");
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textCPF.setColumns(15);
		textCPF.setBounds(111, 245, 252, 28);
		frame.getContentPane().add(textCPF);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdade.setBounds(58, 321, 48, 32);
		frame.getContentPane().add(lblIdade);
		
		textIdade = new JTextField();
		textIdade.setToolTipText("digite a idade");
		textIdade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textIdade.setColumns(15);
		textIdade.setBounds(111, 325, 252, 28);
		frame.getContentPane().add(textIdade);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 803, 104);
		frame.getContentPane().add(panel);
		
		textRemover = new JTextField();
		textRemover.setBackground(new Color(255, 60, 65));
		textRemover.setToolTipText("digite o CPF");
		textRemover.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textRemover.setColumns(15);
		textRemover.setBounds(504, 330, 252, 28);
		frame.getContentPane().add(textRemover);
		
		JLabel lblCpf_1 = new JLabel("CPF:");
		lblCpf_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf_1.setBounds(58, 241, 58, 33);
		frame.getContentPane().add(lblCpf_1);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(255, 60, 65));
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBounds(534, 378, 174, 35);
		frame.getContentPane().add(btnRemover);
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesDAO cliente = new ClientesDAO();
				if(!cliente.verificaAluguelCpf(textRemover.getText())) {
					if( cliente.remover(textRemover.getText()) ) {
						JOptionPane.showMessageDialog(frame,"CPF removido com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
						 frame.dispose();
						 Clientes janelaCliente = new Clientes();
						 janelaCliente.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"CPF não está na base de dados!", "Erro", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"CPF com aluguel ativo!", "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 143, 362, 164);
		frame.getContentPane().add(scrollPane);
		
		ClientesDAO cliente = new ClientesDAO();
		JTextArea textArea = new JTextArea(cliente.listaCliente());
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes Cadastrados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesDAO cliente = new ClientesDAO();
				if(!cliente.verificaAluguelCpf(textCPF.getText())) {
					if(cliente.adicionarCliente(txtNome.getText(), textCPF.getText(), Integer.parseInt(textIdade.getText()))) {
						JOptionPane.showMessageDialog(frame,"Cadastro feito!", null, JOptionPane.INFORMATION_MESSAGE);
						 frame.dispose();
						 Clientes janelaCliente = new Clientes();
						 janelaCliente.frame.setVisible(true);
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"CPF ja cadastrado!", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
