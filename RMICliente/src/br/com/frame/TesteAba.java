package br.com.frame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;


public class TesteAba extends JFrame implements ActionListener {
	
	private JTabbedPane tabGeral;	
	private JMenuBar menuBar;
	private JMenu mnArquivo, mnOpes;
	private JMenuItem mntmSair, mntmLogin;
	
	private JFormattedTextField edDtIni, edDTFim;
	private JFormattedTextField edHrIni, edHRFim;	
	private JButton btnEnviar;	
	private JTable table;
	private JTextField edAssunto;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteAba frame = new TesteAba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TesteAba() throws ParseException {		
		configureTelaInicial();
		configureAbaEnvolvidos();
	}
	
	private void configureTelaInicial()	{
		setTitle("Agenda Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 496);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		mnOpes = new JMenu("Opções");
		menuBar.add(mnOpes);		
		
		mntmLogin = new JMenuItem("Login");
		mnOpes.add(mntmLogin);
		
		this.tabGeral = new JTabbedPane();
		setContentPane(this.tabGeral);	
	}
	
	private void configureAbaEnvolvidos() throws ParseException{
		JPanel pnlEnvio = new JPanel();
		this.tabGeral.addTab("Enviar", pnlEnvio);
		pnlEnvio.setLayout(null);		
		
		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setBounds(12, 30, 70, 15);
		pnlEnvio.add(lblAssunto);
		
		JLabel lblDataIni = new JLabel("Dt. Inicial");
		lblDataIni.setBounds(12, 74, 70, 15);
		pnlEnvio.add(lblDataIni);
		
		MaskFormatter mascaraDt = new MaskFormatter("##/##/####");		
		
		edDtIni = new JFormattedTextField(mascaraDt);		
		edDtIni.setBounds(100, 72, 86, 19);
		pnlEnvio.add(edDtIni);
		edDtIni.setColumns(10);
		
		edDTFim = new JFormattedTextField(mascaraDt);
		edDTFim.setColumns(10);
		edDTFim.setBounds(100, 99, 86, 19);
		pnlEnvio.add(edDTFim);
		
		JLabel lblDtFinal = new JLabel("Dt. Final");
		lblDtFinal.setBounds(12, 101, 70, 15);
		pnlEnvio.add(lblDtFinal);
		
		JLabel lblHrFinal = new JLabel("Hr. Inicial");
		lblHrFinal.setBounds(193, 74, 70, 15);
		pnlEnvio.add(lblHrFinal);
		
		JLabel lblHrFinal_1 = new JLabel("Hr. Final");
		lblHrFinal_1.setBounds(193, 101, 70, 15);
		pnlEnvio.add(lblHrFinal_1);
		
		MaskFormatter mascaraHr = new MaskFormatter("##:##");
				
		edHrIni = new JFormattedTextField(mascaraHr);		
		edHrIni.setBounds(265, 72, 45, 19);
		pnlEnvio.add(edHrIni);
		edHrIni.setColumns(10);
		
		edHRFim = new JFormattedTextField(mascaraHr);
		edHRFim.setBounds(265, 99, 45, 19);
		pnlEnvio.add(edHRFim);
		edHRFim.setColumns(10);
		
		table = new JTable();		
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		table.setShowGrid(true);		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Pessoas Convidadas");		
		table.setModel(model);		
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().setBorder(null);
		scroll.setViewportView(table);
		scroll.setBounds(12, 130, 355, 211);
		pnlEnvio.add(scroll);		
		
		JButton btnAddConv = new JButton("+");		
		btnAddConv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();				
				model.insertRow(model.getRowCount(), new Object[]{});
			}
		});
		btnAddConv.setFont(new Font("Dialog", Font.BOLD, 13));
		btnAddConv.setBounds(12, 353, 45, 20);
		pnlEnvio.add(btnAddConv);	
		
		
		JButton btnRemoveConv = new JButton("-");
		btnRemoveConv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selects[] = table.getSelectedRows();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i=0; i<selects.length; i++) {
					model.removeRow(selects[i] - i);
				}				
			}
		});
		btnRemoveConv.setFont(new Font("Dialog", Font.BOLD, 13));
		btnRemoveConv.setBounds(69, 353, 45, 20);
		pnlEnvio.add(btnRemoveConv);	
		

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(250, 369, 117, 25);
		pnlEnvio.add(btnEnviar);
		
		edAssunto = new JTextField();
		edAssunto.setBounds(100, 26, 267, 19);
		pnlEnvio.add(edAssunto);
		edAssunto.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
	}
}
