package Comportamiento;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String msg);
}

class ConcreteObserver implements Observer {
    public void update(String msg) {
        System.out.println("Observer received: " + msg);
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notify(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
}