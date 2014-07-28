package org.javalusir.pattern.mediator;

public abstract class AbstractMediator {

	public abstract void addColleague(Colleague c);
	
	public abstract void removeColleague(Colleague c);
	
	public abstract void clearColleague();
	
	public abstract void action(Colleague c);
	
}
