package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;

import controller.UserController;
import controller.TransactionController;
import model.Transaction;

public class TransactionResumePanel extends JPanel implements MouseListener{
	private static final long serialVersionUID = 5174008882141088900L;
	
	private TransactionController controller;
	private JLabel categoryLabel;
	
	public TransactionResumePanel(TransactionController controller) {
		this.controller = controller;
		
		this.setPreferredSize(new Dimension(385, 100));
		this.setMaximumSize(new Dimension(385, 100));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel typeLabel = new JLabel(controller.getTransactionTypeInfo());
		typeLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		JLabel directionLabel = new JLabel(controller.getTransactionDirection() 
				+ " " + controller.getRecieverAccountName());
		directionLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		
		JLabel dateLabel = new JLabel();
		dateLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 12));
		Date transactionDate = controller.getTransactionDate();
		int day = transactionDate.getDay();
		int month = transactionDate.getMonth() + 1;
		int year = transactionDate.getYear() + 1900;
		dateLabel.setText(day + "/" + month + "/" + year);
		
		JLabel auxCategoryLabel = new JLabel("Catégorie:");
		auxCategoryLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 12));
		
		categoryLabel = new JLabel(controller.getTransactionCategory());
		categoryLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		
		JLabel amountLabel = new JLabel();
		amountLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		Double amount = controller.getTransactionAmount();
		if (amount > 0) {
			amountLabel.setText("+" + amount.toString() + " €");
			amountLabel.setForeground(new Color(50,200,50));
		} else {
			amountLabel.setText(amount.toString() + " €");
			amountLabel.setForeground(new Color(200,50,50));
		}
		
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(00, 40, 0, 0);
		this.add(amountLabel, c);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(typeLabel, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(directionLabel, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(dateLabel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0, 40, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(auxCategoryLabel, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0, 40, 0, 0);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(categoryLabel, c);
		
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(UIManager.getColor("TabbedPane.background"));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(UIManager.getColor("Panel.background"));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		if(this.contains(e.getPoint())) {
			// TODO	
		}
	}
}
