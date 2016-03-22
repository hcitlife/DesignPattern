package com.hc.demo2;

import java.util.ArrayList;
import java.util.List;
//测试类
public class SimulateAWT {
    public static void main(String[] args) {
        Button b = new Button();
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        b.addActionListener(new MyActionListener3());
        b.buttonPressed();
    }
}

//具体被观察者
class Button {
    private List<ActionListener> listeners = new ArrayList<ActionListener>();

    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

    public void buttonPressed() {
        ActionEvent e = new ActionEvent(System.currentTimeMillis(), this); //事件发生的时间
        for (ActionListener listener : listeners) {
            listener.actionPerformed(e);
        }
    }
}
//抽象观察者接口
interface ActionListener {
    void actionPerformed(ActionEvent e);
}
//具体观察者
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed!");
    }
}
class MyActionListener2 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed 2!");
    }
}
class MyActionListener3 implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed 3!");
        System.out.println(e.getSource());
        System.out.println(e.getWhen());
    }
}

class ActionEvent {
    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;//事件的发生时间
    }

    public Object getSource() {
        return source;//事件源
    }
}