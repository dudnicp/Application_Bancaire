package view.frames;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.Controller;
import view.panels.AccountsPanel;
import view.panels.DocumentsPanel;
import view.panels.LoansPanel;
import view.panels.PreferencesPanel;
import view.panels.TransfersPanel;

public class AppFrame extends JFrame {
	private static final long serialVersionUID = -912989417505291367L;
	private JTabbedPane tabs;
	
	private Controller controller;
	
	public AppFrame(Controller controller) {
		
		this.controller = controller;
		
		this.setTitle("Bank-App");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		tabs = new JTabbedPane(JTabbedPane.LEFT);
		
		tabs.add(new AccountsPanel());
		JPanel tab0 = new JPanel(new BorderLayout());
		tab0.setBackground(new Color(0, 0, 0, 0));
		tab0.setPreferredSize(new Dimension(100, 80));
		tab0.add(new JLabel("Comptes"), BorderLayout.EAST);
		tabs.setTabComponentAt(0, tab0);
		
		tabs.add(new TransfersPanel());
		JPanel tab1 = new JPanel(new BorderLayout());
		tab1.setBackground(new Color(0, 0, 0, 0));
		tab1.setPreferredSize(new Dimension(100, 80));
		tab1.add(new JLabel("Virements"), BorderLayout.EAST);
		tabs.setTabComponentAt(1, tab1);
		
		tabs.add(new LoansPanel());
		JPanel tab2 = new JPanel(new BorderLayout());
		tab2.setBackground(new Color(0, 0, 0, 0));
		tab2.setPreferredSize(new Dimension(100, 80));
		tab2.add(new JLabel("Emprunts"),  BorderLayout.EAST);
		tabs.setTabComponentAt(2, tab2);
		
		tabs.add(new DocumentsPanel());
		JPanel tab3 = new JPanel(new BorderLayout());
		tab3.setBackground(new Color(0, 0, 0, 0));
		tab3.setPreferredSize(new Dimension(100, 80));
		tab3.add(new JLabel("Documents"),  BorderLayout.EAST);
		tabs.setTabComponentAt(3, tab3);
		
		tabs.add(new PreferencesPanel());
		JPanel tab4 = new JPanel(new BorderLayout());
		tab4.setBackground(new Color(0, 0, 0, 0));
		tab4.setPreferredSize(new Dimension(100, 80));
		tab4.add(new JLabel("Préférences"),  BorderLayout.EAST);
		tabs.setTabComponentAt(4, tab4);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.ipady = 400;
		c.fill = GridBagConstraints.BOTH;
		contentPanel.add(tabs, c);
		
		
		JButton decoButton = new JButton("Déconnexion");
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipady = 0;
		c.insets = new Insets(0, 700, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.fill = GridBagConstraints.NONE;
		contentPanel.add(decoButton, c);
		
		JButton quitButton = new JButton("Quitter");
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = GridBagConstraints.PAGE_END;
		contentPanel.add(quitButton, c);
		
		this.setContentPane(contentPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
