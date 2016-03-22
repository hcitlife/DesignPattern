package com.hc.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcitl on 2016-3-22-0022.
 */
//具体被观察者
public class ConcreteObservable implements Observable {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for(Observer observer : observers)
            observer.update(msg);
    }
}
