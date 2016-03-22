package com.hc.demo1;

/**
 * Created by hcitl on 2016-3-22-0022.
 */
//抽象被观察者角色
public interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String msg);
}
