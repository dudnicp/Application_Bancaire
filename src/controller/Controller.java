package controller;

public abstract class Controller {
	public void setupView() {
		setupViewText();
		setupViewButtonsActions();
	}
	public abstract void displayView();
	public abstract void setupViewButtonsActions();
	public abstract void setupViewText();
}
