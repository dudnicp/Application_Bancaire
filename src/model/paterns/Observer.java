package model.paterns;

import model.events.Event;

public interface Observer {
	public void update(Event e);
}
