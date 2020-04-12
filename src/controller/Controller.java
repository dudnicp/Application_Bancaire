package controller;

public abstract class Controller {
	public void setupView() {
		setupViewText();
		setupViewButtons();
	}
	public abstract void displayView();
	public abstract void setupViewButtons();
	public abstract void setupViewText();
}
