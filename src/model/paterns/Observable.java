package model.paterns;

import model.events.Event;

public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver();
	public void notifyObserver(Event e);
}
