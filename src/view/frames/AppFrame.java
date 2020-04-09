package view.frames;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

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
		
		Dimension tabSize = new Dimension(100,80);
		Color transparent = new Color(0,0,0,0);
		
		tabs.add(new AccountsPanel(controller));
		JPanel tab0 = new JPanel(new BorderLayout());
		tab0.setBackground(transparent);
		tab0.setPreferredSize(tabSize);
		tab0.add(new JLabel("Comptes"), BorderLayout.EAST);
		tabs.setTabComponentAt(0, tab0);
		
		tabs.add(new TransfersPanel());
		JPanel tab1 = new JPanel(new BorderLayout());
		tab1.setBackground(transparent);
		tab1.setPreferredSize(tabSize);
		tab1.add(new JLabel("Virements"), BorderLayout.EAST);
		tabs.setTabComponentAt(1, tab1);
		
		tabs.add(new LoansPanel());
		JPanel tab2 = new JPanel(new BorderLayout());
		tab2.setBackground(transparent);
		tab2.setPreferredSize(tabSize);
		tab2.add(new JLabel("Emprunts"),  BorderLayout.EAST);
		tabs.setTabComponentAt(2, tab2);
		
		tabs.add(new PreferencesPanel());
		JPanel tab3 = new JPanel(new BorderLayout());
		tab3.setBackground(transparent);
		tab3.setPreferredSize(tabSize);
		tab3.add(new JLabel("Préférences"),  BorderLayout.EAST);
		tabs.setTabComponentAt(3, tab3);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		contentPanel.add(tabs, c);
		
		
		JButton decoButton = new JButton("Déconnexion");
		decoButton.addActionListener(new DecoButtonListener());
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 400, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.fill = GridBagConstraints.NONE;
		contentPanel.add(decoButton, c);
		
		JButton quitButton = new JButton("Quitter");
		quitButton.addActionListener(new QuitButtonListener());
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
	
	class DecoButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.deconnectCurrentUser();
			dispose();
			LoginFrame newLogin = new LoginFrame(controller);
		}
	}
	
	class QuitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			controller.deconnectCurrentUser();
			dispose();
		}
	}
}
