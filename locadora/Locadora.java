package locadora;

import javax.swing.*;
import java.awt.*;
import bd.MotosDAO;
import bd.ClientesDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.LineBorder;

public class Locadora {

	private JFrame frame;

	public static void main(String[] args) {
		
            
                Locadora window = new Locadora();
                window.frame.setVisible(true);
            
        
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Locadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Locadora de Motos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setResizable(false);
		frame.setSize(743, 563);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setForeground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 729, 124);
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Sistema de Locação");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnCadastroMotos = new JButton("Motos");
		btnCadastroMotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Motos janelaMotos = new Motos();
				janelaMotos.frame.setVisible(true);
			}
		});
		btnCadastroMotos.setForeground(new Color(0, 0, 128));
		btnCadastroMotos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastroMotos.setBackground(new Color(255, 255, 255));
		btnCadastroMotos.setBounds(509, 251, 153, 30);
		frame.getContentPane().add(btnCadastroMotos);
		
		JButton btnCadastroCliente = new JButton("Clientes");
		btnCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes janelaCliente = new Clientes();
				janelaCliente.frame.setVisible(true);
			}
		});
		btnCadastroCliente.setForeground(new Color(0, 0, 128));
		btnCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastroCliente.setBackground(new Color(255, 255, 255));
		btnCadastroCliente.setBounds(509, 188, 153, 30);
		frame.getContentPane().add(btnCadastroCliente);
		
		JButton btnAluguelDeMotos = new JButton("Aluguel de Motos");
		btnAluguelDeMotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluguel janelaAluguel  = new Aluguel();
				janelaAluguel.frame.setVisible(true);
			}
		});
		btnAluguelDeMotos.setForeground(new Color(0, 0, 128));
		btnAluguelDeMotos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAluguelDeMotos.setBackground(new Color(255, 255, 255));
		btnAluguelDeMotos.setBounds(509, 309, 153, 30);
		frame.getContentPane().add(btnAluguelDeMotos);
		
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio janelaRelatorio  = new Relatorio();
				janelaRelatorio.frame.setVisible(true);
			}
		});
		btnRelatorio.setForeground(new Color(0, 0, 128));
		btnRelatorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRelatorio.setBackground(Color.WHITE);
		btnRelatorio.setBounds(509, 368, 153, 30);
		frame.getContentPane().add(btnRelatorio);
		
		JScrollPane scrollPaneMotos = new JScrollPane();
		scrollPaneMotos.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneMotos.setBounds(48, 155, 390, 158);
		frame.getContentPane().add(scrollPaneMotos);
		
		MotosDAO moto = new MotosDAO();
		JTextArea textMotos = new JTextArea(moto.listaMotos());
		textMotos.setEditable(false);
		scrollPaneMotos.setViewportView(textMotos);
		
		JLabel lblMotos = new JLabel("Motos Cadastradas:");
		lblMotos.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPaneMotos.setColumnHeaderView(lblMotos);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneCliente.setBounds(48, 335, 390, 158);
		frame.getContentPane().add(scrollPaneCliente);
		
		JLabel lblCliente = new JLabel("Clientes Cadastrados:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPaneCliente.setColumnHeaderView(lblCliente);
		
		
		ClientesDAO cliente = new ClientesDAO();
		JTextArea textCliente = new JTextArea(cliente.listaCliente());
		textCliente.setEditable(false);
		scrollPaneCliente.setViewportView(textCliente);
		
		
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(new Color(0, 0, 128));
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setBounds(509, 431, 153, 30);
		frame.getContentPane().add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Locadora janela  = new Locadora();
				janela.frame.setVisible(true);
			}
		});
		
		
		
	}
}
