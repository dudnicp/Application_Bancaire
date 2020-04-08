package view;

import java.awt.Dimension;
import javax.swing.JFrame;
import controller.Controller;

public class AppFrame extends JFrame {
	private static final long serialVersionUID = -912989417505291367L;
	
	private Controller controller;
	
	public AppFrame(Controller controller) {
		
		this.controller = controller;
		
		this.setTitle("Bank-App");
		this.setSize(new Dimension(1000, 600));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
}
