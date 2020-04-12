package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainMenuView extends JFrame {

	private static final long serialVersionUID = -8220796308066878211L;

	
	private static final Dimension MAIN_BUTTON_DIMENSION = new Dimension(150, 120);
	private static final Dimension SECUNDARY_BUTTON_DIMENSION = new Dimension(150, 50);
	private static final Dimension PANEL_DIMENSION = new Dimension(450, 510);
	private static final Font MAIN_BUTTON_FONT = new Font(Font.DIALOG, Font.BOLD, 14);
	
	
	private JPanel contentPanel = new JPanel();
	private JButton[] mainButtons = new JButton[3];
	private JButton[] secundaryButtons = new JButton[3];
	
	public MainMenuView() {

		this.setTitle("Bank-App");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int i = 0; i < mainButtons.length; i++) {
			mainButtons[i] = new JButton();
			mainButtons[i].setPreferredSize(MAIN_BUTTON_DIMENSION);
			mainButtons[i].setFont(MAIN_BUTTON_FONT);
		}
		
		for (int i = 0; i < secundaryButtons.length; i++) {
			secundaryButtons[i] = new JButton();
			secundaryButtons[i].setPreferredSize(SECUNDARY_BUTTON_DIMENSION);
		}
		
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(mainButtons[0], c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(mainButtons[1], c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(mainButtons[2], c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(secundaryButtons[0], c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(secundaryButtons[1], c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(secundaryButtons[2], c);
		
		
		contentPanel.setPreferredSize(PANEL_DIMENSION);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		mainPanel.add(contentPanel, c);
		
		
		this.setContentPane(mainPanel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void setMainButtonText(int index, String text) {
		mainButtons[index].setText(text);
	}
	
	public void setSecundaryButtonText(int index, String text) {
		secundaryButtons[index].setText(text);
	}
	
	public void addMainButtonAction(int index, ActionListener actionListener) {
		mainButtons[index].addActionListener(actionListener);
	}
	
	public void addSecundaryButtonAction(int index, ActionListener actionListener) {
		secundaryButtons[index].addActionListener(actionListener);
	}
	
	public void changeContent(ContentView view) {
		contentPanel.removeAll();
		contentPanel.repaint();
		contentPanel.revalidate();
		contentPanel.add(view);
	}
	
	public void showLogoutMessage() {
		JOptionPane.showMessageDialog(null, "Vous avez été déconnécté", "À bientôt!", JOptionPane.INFORMATION_MESSAGE);
	}
}
