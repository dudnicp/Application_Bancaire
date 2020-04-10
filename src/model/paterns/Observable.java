package model.paterns;

import model.events.Event;

public interface Observable {
	public void addObserver(Observer obs);
	public void removeObservers();
	public void notifyObservers(Event e);
}
