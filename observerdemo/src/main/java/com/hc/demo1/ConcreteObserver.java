package com.hc.demo1;

/**
 * Created by hcitl on 2016-3-22-0022.
 */
//具体观察者
public class ConcreteObserver implements Observer {
    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}
