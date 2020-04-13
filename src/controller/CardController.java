package controller;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Card;
import model.CardStatus;
import view.CardView;
import view.DialogView;

public class CardController extends Controller {

	private Card card;
	private CardView view;
	
	public CardController(Card card, CardView view) {
		this.card = card;
		this.view = view;
	}
	
	
	@Override
	public void displayView() {
		view.setVisible(true);

	}

	@Override
	public void setupViewButtonsActions() {
		view.addButtonListener(new ButtonActionListener());
	}

	@Override
	public void setupViewText() {
		view.setLabelText(0, "Carte " + card.getFormatedNumber());
		view.setLabelFont(0, new Font(Font.DIALOG, Font.BOLD, 15));
		view.setLabelText(1, "Titulaire: " + card.getOwner().personalData());
		view.setLabelFont(1, new Font(Font.SERIF, Font.ITALIC, 13));
		view.setLabelText(2, card.getStatus().toString());
		view.setLabelFont(2, new Font(Font.SERIF, Font.ITALIC, 13));
		
		view.setButtonText(card.getStatus().equals(CardStatus.ACTIVE)? "Bloquer" : "Réactiver");
	}
	
	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (card.getStatus()) {
			case ACTIVE:
				int confirmation = DialogView.askConfirmation("Êtes vous sûrs de vouloir bloquer cette carte?", "Confirmation");
				if (confirmation == JOptionPane.OK_OPTION) {
					String password = DialogView.askPassword();
					if (password != null && card.getOwner().getPassword().equals(password)) {
						card.lock();
						view.setLabelText(2, CardStatus.BLOCKED.toString());
						view.setButtonText("Réactiver");
					}
				}
				break;
			case BLOCKED:
				DialogView.displayInfoDialog("Appelez votre banquier pour débloquer la carte.", null);
			default:
				break;
			}
		}
	}

}
