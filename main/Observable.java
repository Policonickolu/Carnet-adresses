package main;


import java.util.Observer;

public interface Observable {
	public void addObserver(Observer obs);
	public void remObserver();
	public void updateObserver();
}
