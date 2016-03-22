package com.hc.demo1;

//测试类
public class ObserverTest {
    public static void main(String[] args) {
        System.out.println("run java");

        Observable observable = new ConcreteObservable();

        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        Observer observer3 = new ConcreteObserver();

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.notifyObservers("HelloWorld");
    }
}
